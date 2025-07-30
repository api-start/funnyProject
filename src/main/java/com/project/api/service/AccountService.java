package com.project.api.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.project.api.model.Account;
import com.project.api.configuration.security.AccountUserDetails;
import com.project.api.repository.AccountDataAccessService;
import com.project.api.service.dto.CreateAccountRequest;
import com.project.api.service.exception.EmailAlreadyInUseException;
import com.project.api.service.exception.UsernameAlreadyInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountDataAccessService accountDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountDataAccessService accountDao,PasswordEncoder passwordEncoder) {
        this.accountDao = accountDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String createUser(CreateAccountRequest accountDto){
        validateAccountUniqueness(accountDto);
        UUID id = generateUUIDV7();
        String hashedPassword = passwordEncoder.encode(accountDto.getPassword());
        Account account = Account.createNew(id,accountDto.getUsername(), accountDto.getEmail(),hashedPassword);
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
        return accountDao.findById(UuidCreator.fromString(id)).orElse(null); // TODO: SHOULD HAVE DTOS FOR OBJECT RETRIEVALS
    }

    private UUID generateUUIDV7(){
        return UuidCreator.getTimeOrderedEpoch();
    }
}
