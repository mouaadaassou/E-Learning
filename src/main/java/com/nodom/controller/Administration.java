package com.nodom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Administration {
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/Linux/Test")
	public String tests(){
		return "tests";
	}
	
	
	@RequestMapping("/Linux/Evaluation")
	public String evaluations(){
		return "evaluations";
	}
	
	

}
