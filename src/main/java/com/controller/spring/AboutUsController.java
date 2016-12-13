package com.controller.spring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.spring.AboutUsModel;
import com.service.spring.AboutUsService;



	@Controller
	@RequestMapping(value="about-us")
	public class AboutUsController {
		
		@Autowired
		private AboutUsService aboutUsService;
		
		public String index()
		{
			return "table";
		}
		
		
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public ModelAndView signup() {
			AboutUsModel loginBean = new AboutUsModel();
			ModelAndView model = new ModelAndView("aboutUs/add");
			model.addObject("AboutUsModel", loginBean);
			return model;
		}

		@RequestMapping(value = "/add**", method = RequestMethod.POST)
		public String register(@ModelAttribute("AboutUsModel") AboutUsModel S, final RedirectAttributes redirectAttributes) {
//			String s = S.getEmail();
			aboutUsService.addAboutUsField(S);
			redirectAttributes.addFlashAttribute("message", "AboutUs added successfully.");
			return "redirect:/about-us/table";
		}

		@RequestMapping(value = "/table", method = RequestMethod.GET)
		public String getAllAboutUsField(Model model) {
			ArrayList<AboutUsModel> list = (ArrayList<AboutUsModel>) this.aboutUsService.getAllAboutUsField();
			model.addAttribute("homePath","/companyProject/about-us/table");
			model.addAttribute("aboutUs", list);
			return "aboutUs/table";
		}

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteAboutUsField(@PathVariable("id") int id,final RedirectAttributes redirectAttributes) {
			this.aboutUsService.deleteAboutUs(id);
			redirectAttributes.addFlashAttribute("message","AboutUs data deleted successfully.");
			return "redirect:/about-us/table";

		}

		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public ModelAndView updateAboutUsField(@PathVariable("id") int id, Model model) {
			model.addAttribute("aboutUs", this.aboutUsService.getAboutUsById(id));
			model.addAttribute("homePath","/companyProject/table");
			AboutUsModel model1 = new AboutUsModel();
			ModelAndView mav = new ModelAndView("aboutUs/edit");
			mav.addObject("message", model1);
			return mav;
		}

		@RequestMapping(value = "/edit/update/{id}**", method = RequestMethod.POST)
		public String editAboutUs(@ModelAttribute("AboutUsModel") AboutUsModel p) {
			this.aboutUsService.editAboutUsField(p);
			return "redirect:/about-us/table";
		}
			

	}
