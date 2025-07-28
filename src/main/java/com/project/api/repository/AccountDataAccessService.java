package com.project.api.repository;

import com.github.f4b6a3.uuid.UuidCreator;
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
                                UuidCreator.fromString(rs.getString("id")),
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
    public Optional<Account> findByUsername(String username) {
        return jdbcTemplate.query(
                "SELECT * FROM account WHERE username = ?",
                (PreparedStatement ps) -> {ps.setObject(1, username);},
                (ResultSet rs) -> {
                    if (rs.next()){
                        return Optional.of(Account.fromDatabase(
                                UuidCreator.fromString(rs.getString("id")),
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
    public Optional<Account> findByEmail(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM account WHERE email = ?",
                (PreparedStatement ps) -> {ps.setObject(1, email);},
                (ResultSet rs) -> {
                    if (rs.next()){
                        return Optional.of(Account.fromDatabase(
                                UuidCreator.fromString(rs.getString("id")),
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
                        UuidCreator.fromString(rs.getString("id")),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("enabled"),
                        rs.getDate("created_date").toLocalDate()
                ))
        );

    }

}
