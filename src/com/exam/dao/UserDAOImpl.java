package com.exam.dao;

import com.exam.model.User;
import com.exam.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
