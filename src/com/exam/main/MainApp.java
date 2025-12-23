package com.exam.main;

import com.exam.dao.UserDAO;
import com.exam.dao.UserDAOImpl;
import com.exam.model.User;

public class MainApp {

    public static void main(String[] args) {

        UserDAO dao = new UserDAOImpl();

        System.out.println("----- All Users -----");
        for (User u : dao.getAllUsers()) {
            System.out.println(
                u.getId() + " " +
                u.getUsername() + " " +
                u.getRole()
            );
        }

        System.out.println("\n----- Login Test -----");
        User user = dao.login("admin", "admin123");

        if (user != null) {
            System.out.println("Login Successful: " + user.getUsername());
        } else {
            System.out.println("Invalid Credentials");
        }
    }
}
