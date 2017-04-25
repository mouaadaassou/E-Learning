package com.nodom.persistence;

import java.util.ArrayList;

public interface AdministrationDAO {
	
	ArrayList<String> executeCommand(String[] command);
	ArrayList<String> getDBResult(String dataBase, String collection, String id);
	boolean compareResult(ArrayList<String> commandResult, ArrayList<String> dbResult);
}
