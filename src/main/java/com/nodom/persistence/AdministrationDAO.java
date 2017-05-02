package com.nodom.persistence;

import java.io.IOException;
import java.util.ArrayList;

import com.nodom.domain.Exercice;

public interface AdministrationDAO {
	
	ArrayList<String> executeCommand(String[] command);
	ArrayList<String> getDBResult(String dataBase, String collection, String id);
	boolean compareResult(ArrayList<String> commandResult, ArrayList<String> dbResult);
	String compareAnswersAndUserAnswers(ArrayList<String> array, ArrayList<String> db);
	public ArrayList<String> executeQuestionQuery(String command)throws IOException;
	public ArrayList<String> getAnswersFromDatabase(String databaseName, String collectionName, String element);
	public ArrayList<String> getAQuestionsFromDatabase(String databaseName, String collectionName, String element);
	public void addExercice(Exercice exercice)throws IOException;

}
