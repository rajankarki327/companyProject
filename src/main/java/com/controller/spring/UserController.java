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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.spring.UserModel;
import com.service.spring.UserService;

@Controller
@RequestMapping(value = "user")
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
		String email = S.getEmail();
		String username=S.getUsername();
		ArrayList<UserModel> email1 = this.userService.isEmailExit(email);
		ArrayList<UserModel> username1=this.userService.isUsernameExit(username);
		if(!username1.isEmpty() || !email1.isEmpty()){
			if (!email1.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Duplicate email");
			}
			if(!username1.isEmpty()){
			redirectAttributes.addFlashAttribute("message1","Dublicate username");
			}
			return "redirect:/user/signup";
		}
		
		else {
			this.userService.addUser(S);
			redirectAttributes.addFlashAttribute("message", "Registration successfully...");
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String getAll(Model model) {
		ArrayList<UserModel> list = (ArrayList<UserModel>) this.userService.getAll();
		model.addAttribute("homePath", "/companyProject/user/table");
		model.addAttribute("user", list);
		return "user/table";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes, Model model) {
		this.userService.deleteUser(id);
		redirectAttributes.addFlashAttribute("message", "User data deleted successfully.");
		model.addAttribute("user", "/companyProject/delete");
		return "redirect:/user/table";

		// return "index";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("homePath", "/companyProject/user/table");
		UserModel model1 = new UserModel();
		ModelAndView mav = new ModelAndView("user/edit");
		mav.addObject("message", model1);
		return mav;
	}

	@RequestMapping(value = "/edit/update/{id}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("UserModel") UserModel p) {
		this.userService.editUser(p);
		return "redirect:/user/table";
	}

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public ModelAndView login() {
		UserModel model = new UserModel();
		ModelAndView mav = new ModelAndView("user/login");
		mav.addObject("login1", model);
		return mav;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public String loginCheck(@ModelAttribute("UserModel") UserModel
	// p,ModelMap model,final RedirectAttributes redirectAttributes) {
	// UserModel sum = this.userService.checkLogin(p);
	// if (sum == null) {
	// redirectAttributes.addFlashAttribute("msg", "Incorrect email or
	// password...");
	// return "redirect:/user/login";
	// }
	// model.put("name",p.getEmail());
	// return ("redirect:/user/dashboard");
	// }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			final RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("message", "Invalid username and password!");
			redirectAttributes.addFlashAttribute("msg", "Incorrect email or password...");

		}

		if (logout != null) {
			model.addObject("msg1", "You've been logged out successfully.");
			redirectAttributes.addFlashAttribute("msg", "Incorrect email or password...");

		}
		model.setViewName("user/login");

		return model;

	}

	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("dashboard", "arg1");
		return "dashboard";
	}

}
