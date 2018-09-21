package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.User;

public interface UserDAO {
	void addUser(User user);
	void deleteUser(int id);
	List<User> getAllUsers();
	void updateUser(int id, User user);
}
