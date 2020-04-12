package cn.njxz.fitness.service;

import cn.njxz.fitness.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
	int add(User user);
	int update(User user);

	int delete(int id);
	User findById(int id);
	List<User> findAll();
	//通过用户名查找用户
	List<User>  selectByName(Map params);
	//通过用户名查找admin的个数
	List<User> countselectByName(String username);

	User  findUserByNameOrPhoneOrEmail(String name);
	int countUser();
}



