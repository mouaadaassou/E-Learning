package com.nodom.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nodom.domain.Answer;
import com.nodom.domain.Exercice;
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
	
	
	@RequestMapping(value = "/answer", method = RequestMethod.GET)
	public String answerYourQuestion(Model model){
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
		//model.addAttribute("questions", new Integer[] {1,2,3,4});
		//model.addAttribute("message", this.message);
		
		ArrayList<String> questions = administrationService.getQuestions();
		int s = questions.size();
		Integer length[] = new Integer[s];
		for(int i = 0; i < s; i++){
			length[i] = i;
		}
		model.addAttribute("length", length);
		model.addAttribute("question", questions);
		return "answer";
	}
	
	
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public String answerYourQuestion(Model model, @ModelAttribute("answer") Answer answer )throws IOException{
		String t = "";
		t = administrationService.getAnswersComparaison(answer);
		return "redirect:/answer?message="+t;
	}
	
	@RequestMapping(value = "/addExercice", method = RequestMethod.GET)
	public String addExercice(Model model){
		Exercice exercice = new Exercice();
		model.addAttribute("exercice", exercice);
		return "addExercice";
	}
	
	@RequestMapping(value = "/addExercice", method = RequestMethod.POST)
	public String addExerciceResponse(Model model, @ModelAttribute("exercice") Exercice exercice) throws IOException{
		for(String s : exercice.getQuestions()){
			System.out.println(s);
		}
		for(String s : exercice.getAnswers()){
			System.out.println(s);
		}
		System.out.println(exercice.getExerciceName());
		this.administrationService.addExercice(exercice);
		return "addExercice";
	}

}
