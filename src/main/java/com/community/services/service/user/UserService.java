package com.community.services.service.user;

import com.community.services.pojo.user.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	List<User> findAllUser();

	void addUser(User user);

	List<User> getUsers(Map condition);

	void deleteUser(int id);

	User getUser(int id);

	void updateUser(User user);

	User findUserByUsername(String username);

	User getUserByUserNameAndPassword(String username, String password);
}
