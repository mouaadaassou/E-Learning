package com.nodom.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodom.domain.Answer;
import com.nodom.domain.Exercice;
import com.nodom.persistence.AdministrationDAO;

@Service
public class AdministrationServiceImpl {
	
	@Autowired
	private AdministrationDAO adminnistrationDAO;
	
	public boolean getUserLsCommandResult(String command){
		String[] array = new String[]{command};
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(array);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "ls");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}
	
	public boolean getUserCdCommandResult(String command){
		String[] array = new String[]{command, "pwd"};
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(array);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "pwd");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}
	
	public boolean getUserMoreCommandResult(String command){
		String[] array = new String[]{command};
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(array);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "more");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}
	
	public String getAnswersComparaison(Answer answer)throws IOException{
		String command = "";
		for(String s : answer.getAnswers() ){
			command += " " + s + " ";
		}
		ArrayList<String> array = adminnistrationDAO.executeQuestionQuery(command);
		ArrayList<String> db = adminnistrationDAO.getAnswersFromDatabase("Linux", "exercices", "exercice_1");
		return adminnistrationDAO.compareAnswersAndUserAnswers(array, db);
	}
	
	public ArrayList<String> getQuestions(){
		return adminnistrationDAO.getAQuestionsFromDatabase("Linux", "exercices", "exercice_1");
	}
	
	public void addExercice(Exercice exercice)throws IOException{
		this.adminnistrationDAO.addExercice(exercice);
	}

}
