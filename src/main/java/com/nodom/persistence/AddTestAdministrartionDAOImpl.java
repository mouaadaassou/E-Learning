package com.nodom.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.nodom.domain.Test;

@Repository
public class AddTestAdministrartionDAOImpl {
	
	/*
	 * Adding a Test to the collection of tests in the Database
	 * and before the recording we execute the command (the answer in a Container)
	 * Using Docker API 
	 */
	public void addATest(Test test)throws IOException{
		StringBuilder command = test.getAnswer().get(0);
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "python regex_program.py " + command);
		pb.directory(new File("/home/mouaad/Desktop/JS/script/"));
		Process process = pb.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String s;
		ArrayList<String> array = new ArrayList<String>();
		
		
		while((s = in.readLine()) != null){
			array.add(s);
			System.out.println(s);
		}
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("Linux");
		MongoCollection<Document> collection = database.getCollection("test");
		Document exerciceName = new Document("name", test.getName());
		for(String t : array){
			System.out.println(t);
		}
		collection.insertOne(exerciceName.append("question", new String(test.getQuestion())).append("answer", array));
		mongoClient.close();
	}
}
