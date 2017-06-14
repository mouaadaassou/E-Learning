package com.nodom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodom.persistence.ViewControllerDAO;

@Service
public class ViewControllerServiceImpl implements ViewControllerService{
	
	@Autowired
	private ViewControllerDAO viewControllerDAO;
	
	public List<String> getTestsName(){
		return viewControllerDAO.getTestsName();
	}
	public List<String> getExercicesName(){
		return viewControllerDAO.getExercicesName();
	}
}
