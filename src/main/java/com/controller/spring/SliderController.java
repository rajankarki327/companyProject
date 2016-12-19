package com.controller.spring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.spring.FileUpload;
import com.model.spring.SliderModel;
import com.rajan.validator.FileUploadValidator;
import com.service.spring.SliderService;

@Controller
@RequestMapping(value="slider")
public class SliderController {

	
	
	@Autowired
	FileUploadValidator fileValidator;

	@Autowired
	SliderService sliderService;

	@RequestMapping("/upload")
	public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") FileUpload uploadedFile, BindingResult result,Model model) {
		model.addAttribute("slider","slider");
		return new ModelAndView("slider/sliderUpload");
	}

	@RequestMapping("/submitFileUpload**")
	public String fileUploaded(@ModelAttribute("uploadedFile") FileUpload uploadedFile, SliderModel sliderModel,
			final RedirectAttributes redirectAttributes, BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// Getting uploaded file
		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);


		String fileName = file.getOriginalFilename();
		sliderModel.setSliderName(fileName);


		// If it has error, redirect it to same page
		if (result.hasErrors()) {
			return ("slider/sliderUpload");
		}

		try {
			
			inputStream = file.getInputStream();

			File newFile = new File("D:/springWorkspace/companyProject/src/main/webapp/resources/uploads/" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[2048];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sliderService.uploadImage(sliderModel);
		redirectAttributes.addFlashAttribute("message", "slider uploaded successfully...");
		return "redirect:/slider/table";
	}

	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String getAllSlider(Model model) {
		ArrayList<SliderModel> list = (ArrayList<SliderModel>) this.sliderService.getAllSlider();
		model.addAttribute("homePath", "/companyProject/slider/table");
		model.addAttribute("slider", list);
		return "slider/table";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSlider(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		this.sliderService.deleteSlider(id);
		redirectAttributes.addAttribute("message", "Slider image deleted successfully.");
		return "redirect:/slider/table";

		// return "index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updateSlider(@PathVariable("id") int id, Model model) {
		model.addAttribute("slider", this.sliderService.getSliderById(id));
		model.addAttribute("homePath","/companyProject/slider/table");
		SliderModel model1 = new SliderModel();
		ModelAndView mav = new ModelAndView("slider/edit");
		mav.addObject("message", model1);
		return mav;
	}

	@RequestMapping(value = "/edit/update/{id}", method = RequestMethod.POST)
	public String editFileUploaded(@ModelAttribute("uploadedFile") FileUpload uploadedFile, SliderModel sliderModel,
			final RedirectAttributes redirectAttributes, BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// Getting uploaded file
		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);

		// If it has error, redirect it to same page
		if (result.hasErrors()) {
			return ("slider/edit");
		}

		try {
			inputStream = file.getInputStream();
			String fileName = file.getOriginalFilename();
			sliderModel.setSliderName(fileName);

			File newFile = new File("D:/springWorkspace/companyProject/src/main/webapp/resources/uploads/" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[2048];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sliderService.editSlider(sliderModel);
		redirectAttributes.addFlashAttribute("message", "slider updated successfully...");
		return "redirect:/slider/table";
	}
	
	

	// @RequestMapping(value = "/slider/table", method = RequestMethod.GET)
	// public ModelAndView getAllSlider(ModelMap map) {
	// ArrayList<SliderModel> list = (ArrayList<SliderModel>)
	// this.sliderService.getAllSlider();
	// // model.addAttribute("user", list);
	//
	// for (SliderModel s : list) {
	// // System.out.println("id:"+s.getId()+",
	// // sliderName:"+s.getSliderName());
	// File file = new File(
	// "D:/springWorkspace/companyProject/src/main/webapp/resources/uploads/" +
	// s.getSliderName());
	// try {
	// FileInputStream fis = new FileInputStream(file);
	// ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// int b;
	// byte[] buffer = new byte[1024];
	// while ((b = fis.read(buffer)) != -1) {
	// bos.write(buffer, 0, b);
	// }
	// byte[] fileBytes = bos.toByteArray();
	// fis.close();
	// byte[] encoded1 = Base64.encodeBase64(fileBytes);
	// String encodedString = new String(encoded1);
	// map.put("image", encodedString);
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// return new ModelAndView("slider/table");
	// }
}
