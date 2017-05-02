package com.nodom.domain;

import java.util.ArrayList;

public class Exercice {
	
	private String exerciceName;
	private ArrayList<String> questions = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<String> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	
	public void addQuestion(String question){
		this.questions.add(question);
	}
	
	public void addAnswer(String answer){
		this.questions.add(answer);
	}
	public String getExerciceName() {
		return exerciceName;
	}
	public void setExerciceName(String exerciceName) {
		this.exerciceName = exerciceName;
	}
}
