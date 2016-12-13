package com.model.spring;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadTeam {
	int id;
	String name;
	String post;
	MultipartFile image;
	String details;
	String fb_id;
	String twiter_id;
	
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
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
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
	

}
