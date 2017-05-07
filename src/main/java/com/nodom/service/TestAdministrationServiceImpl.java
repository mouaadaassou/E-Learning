package com.nodom.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodom.domain.TestAnswer;
import com.nodom.persistence.TestAdministrationDAO;

@Service
public class TestAdministrationServiceImpl implements TestAdministrationService{
	
	
	@Autowired
	private TestAdministrationDAO testAdministrationDAO;
	
	public boolean compareTheResult(TestAnswer answer, String name)throws IOException{
		ArrayList<StringBuilder> userAnser = this.testAdministrationDAO.executeCommand(answer.getAnswer());
		ArrayList<StringBuilder> dbAnswer  = this.testAdministrationDAO.getAnswerFromDB("Linux", "test", name);
		for(StringBuilder sb : dbAnswer)
			if(!userAnser.contains(sb))
				return false;
		return true;
	}
	
	public StringBuilder getQuestion(String name) throws IOException{
		return this.testAdministrationDAO.getQuestionFromDB("Linux", "test", name);
	}
}
