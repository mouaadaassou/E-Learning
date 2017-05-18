package com.nodom.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nodom.domain.TestAnswer;
import com.nodom.service.TestAdministrationService;

@Controller
@RequestMapping("/Linux/Test")
public class TestAdministrationController {

	@Autowired
	private TestAdministrationService testAdministrationService;
	
	@RequestMapping(value="/{commandName}", method = RequestMethod.GET )
	public String passATest(Model model, @PathVariable("commandName") String commandName) throws IOException{
		TestAnswer answer = new TestAnswer();
		StringBuilder question = testAdministrationService.getQuestion(commandName);
		model.addAttribute("question", question);
		System.out.println("the question is : " + question);
		model.addAttribute("userAnswer", answer);
		model.addAttribute("url", commandName);
		return "test";
	}
	
	@RequestMapping(value= "/{commandName}", method = RequestMethod.POST)
	public String passTestResult(Model model, @PathVariable("commandName") String commandName, @ModelAttribute("answer") TestAnswer answer) throws IOException{
		boolean result = testAdministrationService.compareTheResult(answer, commandName);
		return "redirect:/Linux/Test/" + commandName + "?message=" + result ;
	}
	
}
