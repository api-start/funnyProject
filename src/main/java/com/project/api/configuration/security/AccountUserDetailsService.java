package com.project.api.configuration.security;

import com.project.api.model.Account;
import com.project.api.repository.interfaces.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountRepository accountDao;

    @Autowired
    public AccountUserDetailsService(AccountRepository accountDao) {
        this.accountDao = accountDao;
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
