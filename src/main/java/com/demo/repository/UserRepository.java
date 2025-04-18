package com.demo.repository;

import com.demo.config.DBUtil;
import com.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    Connection conn = DBUtil.getConnection();

    public UserRepository() throws Exception {

    }

    public User CreateUser(User user) throws SQLException{

        String sql = "INSERT INTO tb_users (id, name) VALUES (?, ? )";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());

        ps.executeQuery();

        return user;
    }

    public List<User> ListUsers() throws SQLException {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM tb_users;";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);

        while (res.next()){
            User user = new User(res.getInt("id"), res.getString("name"));
            users.add(user);
        }

        return users;
    }

    public User ListUser(int id) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM tb_users WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id); // substitui o primeiro "?" pelo valor de 'id'

        return (User) ps.executeQuery(sql);

    }

    public void UpdateUser(User user) throws SQLException {
        String sql = "UPDATE tb_users SET (name = ? ) WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setInt(2, user.getId()); // substitui o primeiro "?" pelo valor de 'id'

        ps.executeQuery(sql);
    }


}


