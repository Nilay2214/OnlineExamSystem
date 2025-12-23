package com.exam.dao;

import com.exam.model.User;
import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User login(String username, String password);
}
