package com.radiotherapy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radiotherapy.dao.UserDao;
import com.radiotherapy.model.User;
import com.radiotherapy.model.conditionModel.UserCondition;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User getUserByNumber(String number){
		return userDao.getUserByNumber(number);
	}
	
	public List<User> getAllUser(UserCondition condition){
		return userDao.getAllUser(condition);
	}
	
	public List<User> getAllUser(){
		return getAllUser(null);
	}
	
	public boolean addUser(User user){
		return userDao.addUser(user) == 1;
	}
}
