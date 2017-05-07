package com.nodom.persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface TestAdministrationDAO {

	
	ArrayList<StringBuilder> executeCommand(StringBuilder command)throws IOException;
	StringBuilder getQuestionFromDB(String databaseName,String collectionName,  String name)throws IOException;
	ArrayList<StringBuilder> getAnswerFromDB(String databaseName,String collectionName,  String name);
}
