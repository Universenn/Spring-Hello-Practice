package com.example.hello.dao;


import com.example.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class UserDao {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }


    public void add(User user){
        this.jdbcTemplate.update("insert into  users(id, name, password) values (?,?,?)",
                user.getId(),user.getName(),user.getPassword());
    }

    public void deleteAll(){
//        this.dataSource = dataSource;
        this.jdbcTemplate.update("delete from users");
    }
    public User findById(String id){
        Map<String, String> env = System.getenv();
        Connection c;
        PreparedStatement ps;
        ResultSet rs;

        try {
            // DB 접속
            c = dataSource.getConnection();

            // Query 작성
            ps = c.prepareStatement("select * from users where id = ?");
            ps.setString(1,id);

            // Query 실행
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
            }

            rs.close();
            ps.close();
            c.close();

            if (user == null) throw new RuntimeException();

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int getCount(){
        String sql = "SELECT count(*) FROM users";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

}