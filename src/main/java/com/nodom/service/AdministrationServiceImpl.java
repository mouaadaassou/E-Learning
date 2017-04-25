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
		ArrayList<String> commandResult = adminnistrationDAO.executeCommand(command);
		ArrayList<String> databaseResul = adminnistrationDAO.getDBResult("Linux", "command", "ls");
		return adminnistrationDAO.compareResult(commandResult, databaseResul);
	}

}
