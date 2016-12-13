package com.model.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class TeamModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String post;
	private String image;
	private String details;
	private String fb_id;
	private String twiter_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getFb_id() {
		return fb_id;
	}
	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}
	public String getTwiter_id() {
		return twiter_id;
	}
	public void setTwiter_id(String twiter_id) {
		this.twiter_id = twiter_id;
	}
	
	public TeamModel(){}
	
	public TeamModel(String name, String post, String image, String details, String fb_id, String twiter_id) {
		this.name=name;
		this.post=post;
		this.image=image;
		this.details=details;
		this.fb_id=fb_id;
		this.twiter_id=twiter_id;
	}

}