package com.xiaoyao.hy;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public List<User> findAll(){
		List<User> list= userDao.findAll();
		return list;
	}
	
	public User findByUserName(String usernme){
		return userDao.findBySusername(usernme);
	}
}
