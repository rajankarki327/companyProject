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

import com.model.spring.NavModel;
import com.service.spring.NavService;



	@Controller
	@RequestMapping(value="nav")
	public class NavController {
		
		@Autowired
		private NavService navService;
		
		
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public ModelAndView signup() {
			NavModel loginBean = new NavModel();
			ModelAndView model = new ModelAndView("nav/add");
			model.addObject("NavModel", loginBean);
			return model;
		}

		@RequestMapping(value = "/add**", method = RequestMethod.POST)
		public String register(@ModelAttribute("NavModel") NavModel S, final RedirectAttributes redirectAttributes) {
//			String s = S.getEmail();
			navService.addNavField(S);
			redirectAttributes.addFlashAttribute("message", "Nav added successfully.");
			return "redirect:/nav/table";
		}

		@RequestMapping(value = "/table", method = RequestMethod.GET)
		public String getAllNavField(Model model) {
			ArrayList<NavModel> list = (ArrayList<NavModel>) this.navService.getAllNavField();
			model.addAttribute("homePath","nav/table");
			model.addAttribute("nav", list);
			return "nav/table";
		}

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteNavField(@PathVariable("id") int id,final RedirectAttributes redirectAttributes) {
			this.navService.deleteNav(id);
			redirectAttributes.addFlashAttribute("message","Nav data deleted successfully.");
			return "redirect:/nav/table";

		}

		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public ModelAndView updateNavField(@PathVariable("id") int id, Model model) {
			model.addAttribute("nav", this.navService.getNavById(id));
			model.addAttribute("homePath","/companyProject/table");
			NavModel model1 = new NavModel();
			ModelAndView mav = new ModelAndView("nav/edit");
			mav.addObject("message", model1);
			return mav;
		}

		@RequestMapping(value = "/edit/update/{id}", method = RequestMethod.POST)
		public String editNav(@ModelAttribute("NavModel") NavModel p) {
			this.navService.editNavField(p);
			return "redirect:/nav/table";
		}
			

	}
