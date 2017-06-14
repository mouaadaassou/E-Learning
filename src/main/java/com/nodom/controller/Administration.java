package com.nodom.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import com.nodom.service.ViewControllerService;

@Controller
public class Administration {
	
	@Autowired
	private ViewControllerService viewControllerService;
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/Linux/Test")
	public String tests(Model model){
		ArrayList<String> tests = new ArrayList<String>();
		tests = (ArrayList<String>) viewControllerService.getTestsName();
		model.addAttribute("tests", tests);
		return "tests";
	}
	
	
	@RequestMapping("/Linux/Evaluation")
	public String evaluations(Model model){
		ArrayList<String> exercices = new ArrayList<String>();
		exercices = (ArrayList<String>) viewControllerService.getExercicesName();
		model.addAttribute("exercices", exercices);
		return "evaluations";
	}
	
	

}
