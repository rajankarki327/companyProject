package com.controller.spring;

import java.util.ArrayList;

import javax.persistence.metamodel.StaticMetamodel;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.spring.UserModel;
import com.service.spring.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		UserModel loginBean = new UserModel();
		ModelAndView model = new ModelAndView("user/signup");
		model.addObject("UserModel", loginBean);
		return model;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String register(@ModelAttribute("UserModel") UserModel S, final RedirectAttributes redirectAttributes) {
//		String s = S.getEmail();
		userService.addUser(S);
		redirectAttributes.addFlashAttribute("message", "Registration successfully...");
		return "redirect:/login";
	}

	@RequestMapping(value = "/user-table", method = RequestMethod.GET)
	public String getAll(Model model) {
		ArrayList<UserModel> list = (ArrayList<UserModel>) this.userService.getAll();
		model.addAttribute("homePath","user-table");
		model.addAttribute("user", list);
		return "user/table";
	}

	@RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id,final RedirectAttributes redirectAttributes,Model model) {
		this.userService.deleteUser(id);
		redirectAttributes.addFlashAttribute("message","User data deleted successfully.");
		model.addAttribute("user", "/companyProject/delete-user");
		return "redirect:/user-table";

		// return "index";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("homePath","/companyProject/user-table");
		UserModel model1 = new UserModel();
		ModelAndView mav = new ModelAndView("user/edit");
		mav.addObject("message", model1);
		return mav;
	}

	@RequestMapping(value = "/edit/update/{id}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("UserModel") UserModel p) {
		this.userService.editUser(p);
		return "redirect:/user-table";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		UserModel model = new UserModel();
		ModelAndView mav = new ModelAndView("user/login");
		mav.addObject("login1", model);
		return mav;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("UserModel") UserModel p,ModelMap model,final RedirectAttributes redirectAttributes) {
		UserModel sum = this.userService.checkLogin(p);
		if (sum == null) {
			redirectAttributes.addFlashAttribute("msg", "Incorrect email or password...");
			return "redirect:/login";	
		}
		model.put("name",p.getEmail());
		return ("redirect:/dashboard");
	}
	
	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("dashboard", "arg1");
		return "dashboard";
	}
	

}
