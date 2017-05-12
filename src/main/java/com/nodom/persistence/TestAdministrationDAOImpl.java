package com.nodom.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class TestAdministrationDAOImpl implements TestAdministrationDAO{
	
	/*
	 * Execute  command in a container and get the result then return the result  
	 * to be registered in the database if the caller is the addTest page
	 * otherwise it will be returned to be compared ...
	 */
	public ArrayList<StringBuilder> executeCommand(StringBuilder command)throws IOException{
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "python regex_program.py " + command);
		pb.directory(new File("/home/mouaad/Desktop/JS/script/"));
		String s = "";
		ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
		Process process = pb.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while((s = in.readLine()) != null){
			result.add(new StringBuilder(s));
		}
		for(StringBuilder ss : result){
			System.out.println("--"+ss);
		}
		return result;
	}
	
	/*
	 * get the test question from the database 
	 * to be displayed on the user test page
	 */
	public StringBuilder getQuestionFromDB(String databaseName,String collectionName,  String name)throws IOException{
		StringBuilder result = new StringBuilder();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = db.getCollection(collectionName);
		List<Document> documents = collection.find(new Document("name", name)).into(new ArrayList<Document>());
		for(Document document : documents){
			result = new StringBuilder((String)document.get("question"));
		}
		mongoClient.close();
		return result;
	}
	
	/*
	 * get the answer from the database to be compared with
	 * the user answer result ...
	 */
	public ArrayList<StringBuilder> getAnswerFromDB(String databaseName,String collectionName,  String name){
		ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = db.getCollection(collectionName);
		List<Document> documents = collection.find(new Document("name", name)).into(new ArrayList<Document>());
		for(Document document : documents){
			@SuppressWarnings("unchecked")
			List<String> answers = (List<String>) document.get("answer");
			for(int i = 0; i < answers.size(); i++){
				result.add(new StringBuilder(answers.get(i)));
				System.out.println("****" + answers.get(i));
			}		}
		mongoClient.close();
		return result;
	}

}
