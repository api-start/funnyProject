package com.project.api.repository;

import com.project.api.model.Category;
import com.project.api.repository.interfaces.CategoryRepository;
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
public class CategoryDataAccessService implements CategoryRepository {
    private JdbcTemplate jdbcTemplate;

    public CategoryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findAllCategoriesNames() {
        String sql = "SELECT name FROM api_category";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<String>>() {
            @Override
            public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<String> categories = new ArrayList<>();
                while (rs.next()){
                    categories.add(rs.getString("name"));
                }
                return categories;
            }
        });
    }



    @Override
    public void create(Category category) {
        String sql = "INSERT INTO api_category(id,name) values (?,?)";

        jdbcTemplate.update(sql, (PreparedStatement ps) -> {
            ps.setObject(1, category.getId());
            ps.setString(2, category.name());
        });
    }
}
