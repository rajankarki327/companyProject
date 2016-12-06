package com.model.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class SliderModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sliderName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSliderName() {
		return sliderName;
	}
	public void setSliderName(String sliderName) {
		this.sliderName = sliderName;
	}
	public SliderModel(String sliderName)
	{
		this.sliderName=sliderName;
	}
	public SliderModel()
	{
		
	}

}
