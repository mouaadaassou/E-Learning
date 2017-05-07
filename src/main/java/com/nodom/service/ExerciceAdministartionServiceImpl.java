package com.nodom.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodom.domain.Answer;
import com.nodom.persistence.ExerciceAdministrationDAO;

@Service
public class ExerciceAdministartionServiceImpl implements ExerciceAdministrationService{
	
	@Autowired
	ExerciceAdministrationDAO exerciceAdministrationDAOImpl;
	/*
	 * Get the questions from the database using the exerciceAdministrationDAOImpl :
	 */
	public ArrayList<String> getQuestionsOrAnswers(String exercice_name){
		return exerciceAdministrationDAOImpl.getQAFromDatabase(exercice_name, "questions");
	}
	
	public boolean getResult(Answer answer, String exercice_name) throws IOException{
		ArrayList<String> userAnswers = exerciceAdministrationDAOImpl.executeAnswers(answer);
		ArrayList<String> databaseAnswers = exerciceAdministrationDAOImpl.getQAFromDatabase(exercice_name, "answers");
		return exerciceAdministrationDAOImpl.compareResult(userAnswers, databaseAnswers);
	}
}
