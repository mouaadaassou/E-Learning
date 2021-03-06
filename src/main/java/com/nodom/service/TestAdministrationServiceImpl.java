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
		checkCommand(name, answer);
		ArrayList<StringBuilder> userAnswer = this.testAdministrationDAO.executeCommand(answer.getAnswer());
		ArrayList<StringBuilder> dbAnswer  = this.testAdministrationDAO.getAnswerFromDB("Linux", "test", name);
		ArrayList<String> comp = new ArrayList<String>();
		for(StringBuilder sb : userAnswer)
			comp.add(sb.toString());
		for(StringBuilder sb : dbAnswer)
			if(!comp.contains(sb.toString()))
				return false;
		
		return true;
	}
	
	public StringBuilder getQuestion(String name) throws IOException{
		return this.testAdministrationDAO.getQuestionFromDB("Linux", "test", name);
	}
	
	/*
	 * to append the suffix to the user answer
	 */
	public void checkCommand(String name, TestAnswer answer){
		if("mkdir".equals(name) || "touch".equals(name)){
			answer.setAnswer(answer.getAnswer().append(" @ ls /home"));
			System.out.println("the answer :" + answer.getAnswer());
		}
		else if("cd".equals(name)){
			answer.setAnswer(answer.getAnswer().append(" @ pwd"));
			System.out.println("the answer :" + answer.getAnswer());
		}
		else if("echo".equals(name)){
			answer.setAnswer(answer.getAnswer().append(" @ more /home/file1"));
			System.out.println("the answer :" + answer.getAnswer());
		}
	}
}
