package com.nodom.domain;

import java.util.ArrayList;

public class Test {

	private int id;
	private String name;
	private StringBuilder question;
	private ArrayList<StringBuilder> answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringBuilder getQuestion() {
		return question;
	}

	public void setQuestion(StringBuilder question) {
		this.question = question;
	}

	public ArrayList<StringBuilder> getAnswer() {
		return answer;
	}

	public void setAnswer(ArrayList<StringBuilder> answer) {
		this.answer = answer;
	}
}
