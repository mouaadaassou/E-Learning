package com.nodom.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nodom.domain.Test;
import com.nodom.persistence.AddTestAdministrartionDAOImpl;

@Controller
@RequestMapping("/Linux")
public class AddTestAdministrationController {
	
	@Autowired
	private AddTestAdministrartionDAOImpl addTestAdministrationDAOImpl;
	
	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public String addExercice(Model model){
		Test test = new Test();
		model.addAttribute("test", test);
		return "addTest";
	}
	
	@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	public String addExerciceResponse(Model model, @ModelAttribute("test") Test test) throws IOException{
		/*for(String s : exercice.getQuestions()){
			System.out.println(s);
		}
		for(String s : exercice.getAnswers()){
			System.out.println(s);
		}
		System.out.println(exercice.getExerciceName());*/
		addTestAdministrationDAOImpl.addATest(test);;
		return "redirect:/Linux/addTest";
	}
}
