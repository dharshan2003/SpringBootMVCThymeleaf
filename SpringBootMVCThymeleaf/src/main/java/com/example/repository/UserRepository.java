package com.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean userExists(String username) {
        String sql = "SELECT COUNT(*) FROM usertable WHERE username = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count != null && count > 0;
    }

    public int saveUser(User user) {
        String sql = "INSERT INTO usertable (username, password) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }
}
