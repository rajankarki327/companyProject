package com.model.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nav")
public class NavModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String navField;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNavField() {
		return navField;
	}
	public void setNavField(String navField) {
		this.navField = navField;
	}
	
	public NavModel(){}
	public NavModel(String nf)
	{
		this.navField=nf;
	}

}