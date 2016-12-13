package com.model.spring;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	MultipartFile file;
	MultipartFile image;
	

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
