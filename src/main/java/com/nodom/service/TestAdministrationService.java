package com.nodom.service;

import java.io.IOException;

import com.nodom.domain.TestAnswer;

public interface TestAdministrationService {
	
	boolean compareTheResult(TestAnswer answer, String name)throws IOException;
	StringBuilder getQuestion(String name) throws IOException;
}
