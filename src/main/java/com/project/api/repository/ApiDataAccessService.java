package com.project.api.repository;

import com.project.api.model.Api;
import com.project.api.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ApiDataAccessService implements ApiRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ApiDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Api> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM account",
                ((rs, rowNum) -> Api.fromDatabase(
                        UUID.fromString(rs.getString("id")),
                        rs.getString("name"),
                        rs.getString("url_base"),
                        rs.getString("description"),
                        rs.getString("version"),
                        rs.getDate("updated_date").toLocalDate(),
                        rs.getDate("created_date").toLocalDate(),
                        UUID.fromString(rs.getString("account_id")),
                        Category.fromId(UUID.fromString(rs.getString("id_category")))
                ))
        );
    }

    @Override
    public Optional<Api> findById(UUID id) {
        return jdbcTemplate.query(
                "SELECT * FROM api WHERE id = ?",
                (PreparedStatement ps) -> {ps.setObject(1, id);},
                (ResultSet rs) -> {
                    if (rs.next()){
                        return Optional.of(Api.fromDatabase(
                                UUID.fromString(rs.getString("id")),
                                rs.getString("name"),
                                rs.getString("url_base"),
                                rs.getString("description"),
                                rs.getString("version"),
                                rs.getDate("created_date").toLocalDate(),
                                rs.getDate("updated_date").toLocalDate(),
                                UUID.fromString(rs.getString("account_id")),
                                Category.fromId(UUID.fromString(rs.getString("id_category")))
                        ));
                    }
                    return Optional.empty();
                }
        );
    }

    @Override
    public int update(Api api) {
        return jdbcTemplate.update(
                "UPDATE api" +
                    "SET" +
                        "name = ?,"+
                        "url_base = ?," +
                        "description = ?," +
                        "updated_date = ?," +
                        "version = ?," +
                        "id_category = ?" +
                    "WHERE id = ?",
                ps -> {
                    ps.setString(1, api.getName());
                    ps.setString(2, api.getUrlBase());
                    ps.setString(3, api.getDescription());
                    ps.setDate(4, Date.valueOf(api.getUpdatedDate()));
                    ps.setString(5, api.getVersion());
                    ps.setObject(6, api.getCategory().getId());
                    ps.setObject(7, api.getId());
                }
        );
    }

    @Override
    public int save(Api api) {
        return jdbcTemplate.update(
                "INSERT INTO api (id, name, url_base, description, created_date, updated_date, version, account_id, id_category)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                api.getId(),
                api.getName(),
                api.getUrlBase(),
                api.getDescription(),
                Date.valueOf(api.getCreatedDate()),
                Date.valueOf(api.getUpdatedDate()),
                api.getVersion(),
                api.getAccountId(),
                api.getCategory().getId()
        );
    }
}
