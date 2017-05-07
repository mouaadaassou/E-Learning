package com.nodom.service;

import java.io.IOException;
import java.util.ArrayList;

import com.nodom.domain.Answer;

public interface ExerciceAdministrationService {
	
	ArrayList<String> getQuestionsOrAnswers(String exercice_name);
	boolean getResult(Answer answer, String exercice_name) throws IOException;
}
