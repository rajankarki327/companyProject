package com.service.spring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spring.NavDao;
import com.model.spring.NavModel;

@Service
public class NavService {
	@Autowired
	private NavDao NavDao;
 
	public void setNavDao(NavDao NavDao) {
		this.NavDao = NavDao;
	}


	@Transactional
	public void addNavField(NavModel s) {
		this.NavDao.addNavField(s);
	}
	
	@Transactional
	public ArrayList<NavModel> getAllNavField() {
		return (ArrayList<NavModel>) this.NavDao.getAllNavField();
	}
	
	@Transactional
	public void deleteNav(int i)
	{
		this.NavDao.deleteNavField(i);
	}
	
	@Transactional
	public NavModel getNavById(int id) {
		return this.NavDao.getNavById(id);
	}
	
	@Transactional
	public void editNavField(NavModel i)
	{
		this.NavDao.editNavField(i);
	}
	
	


}
