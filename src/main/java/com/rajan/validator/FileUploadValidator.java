
package com.rajan.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.spring.FileUpload;

public class FileUploadValidator implements Validator{
	
	

	public boolean supports(Class clazz) {
		//just validate the FileUpload instances
		return FileUpload.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		FileUpload file = (FileUpload)target;
		
		if(file.getFile().getSize()==0){
			errors.rejectValue("file", "uploadForm.selectFile",  
				     "Please select a file!");
		}
	}
}