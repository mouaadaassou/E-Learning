package com.nodom.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nodom.domain.Page;
import com.nodom.service.AdministrationServiceImpl;

@Controller
public class AdministrationController {
	
	private String message;

	@Autowired
	private AdministrationServiceImpl administrationService;
	
	@RequestMapping(value = "/ls", method = RequestMethod.GET)
	public String listPerson(Model model){
		Page page1 = new Page();
		model.addAttribute("page", page1);
		model.addAttribute("message", this.message);
		return "ls";
	}
	
	@RequestMapping(value = "/ls", method = RequestMethod.POST)
	public String listPerson(Model model, @ModelAttribute("page") Page page )throws IOException{
		
		
		this.message = "the answer is : " + administrationService.getUserLsCommandResult(page.getCommand());
		return "redirect:/ls";
	}
	
	@RequestMapping(value = "/cd", method = RequestMethod.GET)
	public String cdCommand(Model model){
		Page page = new Page();
		model.addAttribute("page", page);
		model.addAttribute("message", this.message);
		return "cd";
	}
	
	@RequestMapping(value = "/cd", method = RequestMethod.POST)
	public String cdCommand(Model model, @ModelAttribute("page") Page page )throws IOException{
		
		
		this.message = "the answer is : " + administrationService.getUserCdCommandResult(page.getCommand());
		return "redirect:/cd";
	}
	
	@RequestMapping(value = "/cat", method = RequestMethod.GET)
	public String moreCommand(Model model){
		Page page = new Page();
		model.addAttribute("page", page);
		model.addAttribute("message", this.message);
		return "cat";
	}
	
	@RequestMapping(value = "/cat", method = RequestMethod.POST)
	public String moreCommand(Model model, @ModelAttribute("page") Page page )throws IOException{
		
		
		this.message = "the answer is : " + administrationService.getUserMoreCommandResult(page.getCommand());
		return "redirect:/cat";
	}
	
	

}
