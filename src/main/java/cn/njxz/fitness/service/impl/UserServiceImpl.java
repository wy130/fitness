package cn.njxz.fitness.service.impl;

import java.util.List;
import java.util.Map;


import cn.njxz.fitness.mapper.UserMapper;
import cn.njxz.fitness.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.njxz.fitness.service.UserService;

@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public int delete(int id) {
		return userMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<User> findAll() {
		List<User> findAllList = userMapper.selectAll();
		return findAllList;
	}
	@Override
	public User findById(int id) {

		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	@Override
	public int add(User user) {
		return userMapper.insertSelective(user);
	}
	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}


	@Override
	public User findUserByNameOrPhoneOrEmail(String name) {
		String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String ph = "^[1][34578]\\d{9}$";
		User user = new User();
		if (name.matches(ph)) {//手机号登录
			user.setUPhone(name);
			return userMapper.findUserByPhone(user);
		}else if(name.matches(em)){
			user.setUEmail(name);
			return  userMapper.findUserByEmail(user);
		}else {
			user.setUName(name);
			return  userMapper.findUserByName(user);
		}
	}

	@Override
	public int countUser() {
		return userMapper.userCount();
	}
	@Override
	public List<User> selectByName(Map params) {
		// TODO Auto-generated method stub
		return userMapper.selectByName(params);
	}

	@Override
	public List<User> countselectByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.countselectByName(username);
	}


}
