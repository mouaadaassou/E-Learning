package com.nodom.persistence;

import java.io.IOException;
import java.util.ArrayList;

import com.nodom.domain.Answer;
import com.nodom.domain.Exercice;

public interface ExerciceAdministrationDAO {
	
	void addExercice(Exercice exercice) throws IOException;
	ArrayList<String> getQAFromDatabase(String exercice_name, String QA);
	ArrayList<String> executeAnswers(Answer answer)throws IOException;
	boolean compareResult(ArrayList<String> userAnswers, ArrayList<String> databaseAnswers);
}
