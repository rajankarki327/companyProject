package com.controller.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.spring.AboutUsModel;
import com.model.spring.NavModel;
import com.model.spring.SliderModel;
import com.model.spring.TeamModel;
import com.service.spring.AboutUsService;
import com.service.spring.NavService;
import com.service.spring.SliderService;
import com.service.spring.TeamService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@Autowired
	private NavService navService;
	@Autowired
	private SliderService sliderService;
	@Autowired
	private AboutUsService aboutUsService;
	@Autowired
	private TeamService teamService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView indexPage(Model model)
	{
		ArrayList<NavModel> nav = (ArrayList<NavModel>) this.navService.getAllNavField();
		String slider ="";
		for(SliderModel s:this.sliderService.getAllSlider()){
			slider+=s.getSliderName()+",";
		};
		
		ArrayList<AboutUsModel> aboutUs = (ArrayList<AboutUsModel>) this.aboutUsService.getAllAboutUsField();
		ArrayList<TeamModel> team = (ArrayList<TeamModel>) this.teamService.getAllTeam();
		
		model.addAttribute("nav", nav);
		model.addAttribute("slider", slider);
		model.addAttribute("aboutUs", aboutUs);
		model.addAttribute("team", team);

		return new ModelAndView("/home/index");
		
	}

}
