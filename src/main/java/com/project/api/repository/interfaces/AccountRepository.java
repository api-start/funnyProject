package com.project.api.repository.interfaces;

import com.project.api.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    int save(Account account);
    Optional<Account> findById(UUID id);
    Optional<Account> findByUsername(String username);
    Optional<Account> findByEmail(String email);
    List<Account> findAll();
}
