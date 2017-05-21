package com.nodom.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nodom.domain.Answer;
import com.nodom.service.ExerciceAdministrationService;

@Controller
@RequestMapping("/Linux/Evaluation")
public class ExerciceAdministrationController {
	
	@Autowired
	ExerciceAdministrationService exerciceAdministrationServiceImpl;
	
	@RequestMapping(value="/{exercice_name}", method = RequestMethod.GET)
	public String exerciceGet(Model model, @PathVariable("exercice_name")String url){
		Answer answer = new Answer();
		ArrayList<String> questions = exerciceAdministrationServiceImpl.getQuestionsOrAnswers(url);
		int s = questions.size();
		Integer length[] = new Integer[s];
		for(int i = 0; i < s; i++){
			length[i] = i;
		}
		model.addAttribute("length", length);
		model.addAttribute("question", questions);
		System.out.println(url);
		model.addAttribute("url", url);
		model.addAttribute("answer", answer);
		return "answer";
	}
	
	@RequestMapping(value="/{exercice_name}", method = RequestMethod.POST)
	public String exercicePOST(Model model, @PathVariable("exercice_name")String url, @ModelAttribute("answer")Answer answer) throws IOException{
		boolean result = exerciceAdministrationServiceImpl.getResult(answer, url);
		System.out.println("the answer is " + result );
		System.out.println(url);
		return "redirect:/Linux/Evaluation/" + url + "?message=" + result;
	}

}
