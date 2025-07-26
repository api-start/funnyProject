package com.project.api.service;

import com.project.api.model.Account;
import com.project.api.model.security.AccountUserDetails;
import com.project.api.repository.AccountDataAccessService;
import com.project.api.service.dto.CreateAccountRequest;
import com.project.api.service.exception.EmailAlreadyInUseException;
import com.project.api.service.exception.UsernameAlreadyInUseException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService implements UserDetailsService {

    private final AccountDataAccessService accountDao;

    public AccountService(AccountDataAccessService accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public String createUser(CreateAccountRequest accountDto){
        validateAccountUniqueness(accountDto);
        UUID id = UUID.randomUUID();
        Account account = Account.createNew(id,accountDto.getUsername(), accountDto.getEmail(),accountDto.getPassword());
        accountDao.save(account);
        return account.getId().toString();
    }

    private void validateAccountUniqueness(CreateAccountRequest accountDto){
        Optional<Account> accountByUsername = accountDao.findByUsername(accountDto.getUsername());
        if (accountByUsername.isPresent()){
            throw new UsernameAlreadyInUseException("Username already in use");
        }
        Optional<Account> accountByEmail = accountDao.findByEmail(accountDto.getEmail());
        if (accountByEmail.isPresent()){
            throw new EmailAlreadyInUseException("Email already in use");
        }
    }

    public Account getAccount(String id){
        return accountDao.findById(UUID.fromString(id)).orElse(null); // TODO: SHOULD HAVE DTOS FOR OBJECT RETRIEVALS
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //TODO: ADD EXCEPTION TO EXCEPTION HANDLER
        Optional<Account> account = accountDao.findByUsername(username);
        if (account.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return new AccountUserDetails(account.get().getId(), account.get().getUsername(),account.get().getPassword());
    }
}
