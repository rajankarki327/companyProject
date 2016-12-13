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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.spring.FileUpload;
import com.model.spring.ImageUploadTeam;
import com.model.spring.TeamModel;
import com.service.spring.TeamService;

@Controller
@RequestMapping(value="team")
public class TeamController {
//	@Autowired
//	FileUploadValidator fileValidator;
	@Autowired
	TeamService teamService;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView getUploadForm(@ModelAttribute("imageUploadTeam") ImageUploadTeam imageUploadTeam, BindingResult result,Model model) {
		model.addAttribute("team","team");
		return new ModelAndView("team/add");
	}

	@RequestMapping(value="/addData**", method = RequestMethod.POST)
	public String fileUploaded(@ModelAttribute("imageUploadTeam") ImageUploadTeam imageUploadTeam,
			final RedirectAttributes redirectAttributes, BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// Getting uploaded file
		MultipartFile file = imageUploadTeam.getImage();
//		fileValidator.validate(imageUploadTeam, result);
		TeamModel teamModel=new TeamModel();

		String imageName = file.getOriginalFilename();
		teamModel.setName(imageUploadTeam.getName());
		teamModel.setPost(imageUploadTeam.getPost());
		teamModel.setImage(imageName);
		teamModel.setDetails(imageUploadTeam.getDetails());
		teamModel.setFb_id(imageUploadTeam.getFb_id());
		teamModel.setTwiter_id(imageUploadTeam.getTwiter_id());
		
		teamService.uploadImage(teamModel);

		// If it has error, redirect it to same page
		if (result.hasErrors()) {
			return ("team/table");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File("D:/springWorkspace/companyProject/src/main/webapp/resources/uploads/" + imageName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "team uploaded successfully...");
		return "redirect:/team/table";
	}

	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String getAllTeam(Model model) {
		ArrayList<TeamModel> list = (ArrayList<TeamModel>) this.teamService.getAllTeam();
		model.addAttribute("homePath", "team/table");
		model.addAttribute("team", list);
		return "team/table";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		this.teamService.deleteTeam(id);
		redirectAttributes.addAttribute("message", "Team image deleted successfully.");
		return "redirect:/team/table";

		// return "index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updateTeam(@PathVariable("id") int id, Model model) {
		model.addAttribute("team", this.teamService.getTeamById(id));
		model.addAttribute("homePath","/companyProject/team/table");
		TeamModel model1 = new TeamModel();
		ModelAndView mav = new ModelAndView("team/edit");
		mav.addObject("message", model1);
		return mav;
	}

	@RequestMapping(value = "/edit/update/{id}**", method = RequestMethod.POST)
	public String updateTeam(@ModelAttribute("imageUploadTeam") ImageUploadTeam imageUploadTeam,
			final RedirectAttributes redirectAttributes, BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// Getting uploaded file
		MultipartFile file = imageUploadTeam.getImage();
//		fileValidator.validate(imageUploadTeam, result);
		TeamModel teamModel=new TeamModel();
		
		String imageName = file.getOriginalFilename();
		teamModel.setName(imageUploadTeam.getName());
		teamModel.setPost(imageUploadTeam.getPost());
		teamModel.setImage(imageName);
		teamModel.setDetails(imageUploadTeam.getDetails());
		teamModel.setFb_id(imageUploadTeam.getFb_id());
		teamModel.setTwiter_id(imageUploadTeam.getTwiter_id());
		teamModel.setId(imageUploadTeam.getId());
		
		teamService.editTeam(teamModel);

		// If it has error, redirect it to same page
		if (result.hasErrors()) {
			return ("team/edit");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File("D:/springWorkspace/companyProject/src/main/webapp/resources/uploads/" + imageName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "team updated successfully...");
		return "redirect:/team/table";
	}
}