package com.service.spring;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spring.UserDao;
import com.model.spring.UserModel;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Transactional
	public void addUser(UserModel s) {
		this.userDao.addUser(s);
	}
	
	@Transactional
	public ArrayList<UserModel> getAll() {
		return (ArrayList<UserModel>) this.userDao.getAll();
	}
	
	@Transactional
	public void deleteUser(int i)
	{
		this.userDao.deleteUser(i);
	}
	
	@Transactional
	public UserModel getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
	@Transactional
	public void editUser(UserModel i)
	{
		this.userDao.editUser(i);
	}
	
	@Transactional
	public UserModel checkLogin(UserModel i)
	{
		return this.userDao.checkLogin(i);
	}


}
