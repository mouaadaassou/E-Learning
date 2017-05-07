package com.nodom.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nodom.domain.Exercice;
import com.nodom.persistence.ExerciceAdministrationDAO;

@Controller
public class AddExerciceAdministrationController {
	
	@Autowired
	private ExerciceAdministrationDAO exerciceAdministration; 
	
	/*@RequestMapping(value = "/{exercice_name}", method = RequestMethod.GET)
	public String answerYourQuestion(Model model, @PathVariable("exercice_name") String exercice_name){
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
	
		ArrayList<String> questions = administrationService.getQuestions(exercice_name);
		int s = questions.size();
		Integer length[] = new Integer[s];
		for(int i = 0; i < s; i++){
			length[i] = i;
		}
		model.addAttribute("length", length);
		model.addAttribute("question", questions);
		return "answer";
	}
	
	@RequestMapping(value = "/{exercice_name}", method = RequestMethod.POST)
	public String answerYourQuestion(Model model, @PathVariable("exercice_name") String exercice_name, @ModelAttribute("answer") Answer answer )throws IOException{
		String t = "";
		t = administrationService.getAnswersComparaison(answer, exercice_name);
		return "redirect:/linux/" + exercice_name +"?message="+t;
	}*/
	
	/*
	 * Adding an Exercice : 
	 */
	
	@RequestMapping(value = "/addExo", method = RequestMethod.GET)
	public String addExercice(Model model){
		Exercice exercice = new Exercice();
		model.addAttribute("exercice", exercice);
		return "addExercice";
	}
	
	@RequestMapping(value = "/addExo", method = RequestMethod.POST)
	public String addExerciceResponse(Model model, @ModelAttribute("exercice") Exercice exercice) throws IOException{
		/*for(String s : exercice.getQuestions()){
			System.out.println(s);
		}
		for(String s : exercice.getAnswers()){
			System.out.println(s);
		}
		System.out.println(exercice.getExerciceName());*/
		exerciceAdministration.addExercice(exercice);
		return "redirect:/addExo";
	}
}
