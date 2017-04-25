package com.nodom.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodom.persistence.AdministrationDAO;

@Service
public class AdministrationServiceImpl {
	
	@Autowired
	private AdministrationDAO adminnistrationDAO;
	
	public boolean getUserLsCommandResult(String command){
		String[] array = new String[]{command};
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(array);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "ls");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}
	
	public boolean getUserCdCommandResult(String command){
		String[] array = new String[]{command, "pwd"};
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(array);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "pwd");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}
	
	public boolean getUserMoreCommandResult(String command){
		String[] array = new String[]{command};
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(array);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "more");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}

}
