package com.project.api.repository;

import com.project.api.model.Account;
import com.project.api.repository.interfaces.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountDataAccessService implements AccountRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Account account) {
        System.out.println("test");
        return jdbcTemplate.update(
                "INSERT INTO account (id, username, email, password, created_date, enabled) " +
                        "VALUES (?,?,?,?,?,?)",
                account.getId(),
                account.getUsername(),
                account.getEmail(),
                account.getPassword(),
                account.getCreatedDate(),
                account.isEnabled()
        );
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return jdbcTemplate.query(
                "SELECT * FROM account WHERE id = ?",
                (PreparedStatement ps) -> {ps.setObject(1, id);},
                (ResultSet rs) -> {
                    if (rs.next()){
                        return Optional.of(Account.fromDatabase(
                                UUID.fromString(rs.getString("id")),
                                rs.getString("username"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getBoolean("enabled"),
                                rs.getDate("created_date").toLocalDate()
                        ));
                    }
                    return Optional.empty();
                }
        );
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM account",
                ((rs, rowNum) -> Account.fromDatabase(
                        UUID.fromString(rs.getString("id")),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("enabled"),
                        rs.getDate("created_date").toLocalDate()
                ))
        );
    }
}
