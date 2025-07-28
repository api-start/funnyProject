package com.project.api.repository;

import com.project.api.model.RequestMethod;
import com.project.api.repository.interfaces.RequestMethodRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestMethodDataAccessService implements RequestMethodRepository {
    private JdbcTemplate jdbcTemplate;

    public RequestMethodDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findAllMethodsNames() {
        String sql = "SELECT name FROM request_method";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<String>>() {
            @Override
            public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<String> methods = new ArrayList<>();
                while (rs.next()){
                    methods.add(rs.getString("name"));
                }
                return methods;
            }
        });
    }

    @Override
    public void create(RequestMethod requestMethod) {
        String sql = "INSERT INTO request_method(id,name) values (?,?)";

        jdbcTemplate.update(sql, (PreparedStatement ps) -> {
            ps.setObject(1, requestMethod.getId());
            ps.setString(2, requestMethod.name());
        });
    }
}
