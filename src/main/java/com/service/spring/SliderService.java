package com.service.spring;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spring.SliderDao;
import com.model.spring.SliderModel;
import com.model.spring.UserModel;

@Service
public class SliderService {

	private SliderDao sliderDao;


	public void setSliderDao(SliderDao sliderDao) {
		this.sliderDao = sliderDao;
	}


	@Transactional
	public void uploadImage(SliderModel s) {
		this.sliderDao.uploadImage(s);
	}
	
	@Transactional
	public ArrayList<SliderModel> getAllSlider() {
		return (ArrayList<SliderModel>) this.sliderDao.getAllSlider();
	}
	
	@Transactional
	public void deleteSlider(int i)
	{
		this.sliderDao.deleteSlider(i);
	}
	@Transactional
	public SliderModel getSliderById(int id) {
		return this.sliderDao.getSliderById(id);
	}
	
	@Transactional
	public void editSlider(SliderModel i)
	{
		this.sliderDao.editSlider(i);
	}


}
