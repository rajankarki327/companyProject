package com.service.spring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spring.AboutUsDao;
import com.model.spring.AboutUsModel;

@Service
public class AboutUsService {
	@Autowired
	private AboutUsDao AboutUsDao;
 
	public void setAboutUsDao(AboutUsDao AboutUsDao) {
		this.AboutUsDao = AboutUsDao;
	}


	@Transactional
	public void addAboutUsField(AboutUsModel s) {
		this.AboutUsDao.addAboutUsField(s);
	}
	
	@Transactional
	public ArrayList<AboutUsModel> getAllAboutUsField() {
		return (ArrayList<AboutUsModel>) this.AboutUsDao.getAllAboutUsField();
	}
	
	@Transactional
	public void deleteAboutUs(int i)
	{
		this.AboutUsDao.deleteAboutUsField(i);
	}
	
	@Transactional
	public AboutUsModel getAboutUsById(int id) {
		return this.AboutUsDao.getAboutUsById(id);
	}
	
	@Transactional
	public void editAboutUsField(AboutUsModel i)
	{
		this.AboutUsDao.editAboutUsField(i);
	}
	
	


}
