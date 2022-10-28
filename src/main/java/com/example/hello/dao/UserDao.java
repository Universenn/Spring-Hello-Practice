package com.example.hello.dao;

import com.example.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;


    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
            return user;
        }
    };

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }

    public void add(User user){
        this.jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES (?, ?, ?)",user.getId(),user.getName(),user.getPassword());
    }

    public User findById(String id){
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }


    public int getCount(){
        String sql = "SELECT count(*) FROM users";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public void deleteById(String id){
        String sql = "delete from users where id = ?";
        this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
}
