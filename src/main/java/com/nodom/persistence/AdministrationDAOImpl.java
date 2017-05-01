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
public class AdministrationDAOImpl implements AdministrationDAO{
	
	/*
	 * code to be used in the mkdir method : to get the number of directories and files created  
	 * private static int numberOfDirectoriesCreated;
	private static int numberOfFilesCreated;
	
	static{
		MongoClient mongoClient = null;
		try{
			mongoClient = new MongoClient();
			MongoDatabase database = mongoClient.getDatabase("Linux");
			MongoCollection<Document> collection = database.getCollection("command");
			List<Document> document1 = collection.find(new Document("_id", "mkdir")).into(new ArrayList<Document>());
			List<Document> document2 = collection.find(new Document("_id", "touch")).into(new ArrayList<Document>());
			for(Document doc : document1){
				List<Integer> res1 = (List<Integer>)doc.get("size");
				for(int r : res1)
					numberOfDirectoriesCreated = r;
			}
			for(Document doc : document2){
				List<Integer> res2 = (List<Integer>)doc.get("size");
				for(int r : res2)
					numberOfFilesCreated = r;
			}
		}finally{
			mongoClient.close();
		}
	}*/

	public ArrayList<String> executeCommand(String[] command) {
		String array = "";
		for(String s : command){
			array += s + "; ";
		}
		ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", array );
		ArrayList<String> result = new ArrayList<String>();
		String s;
		BufferedReader in = null;
		try{
			Process process = pb.start();
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while((s = in.readLine()) != null){
				result.add(s);
			}
		}catch(IOException e){
			result.add(e.getMessage());
		}finally{
			try{
				in.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public ArrayList<String> getDBResult(String dataBase, String  Collection, String id) {
		ArrayList<String> result = new ArrayList<String>();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase(dataBase);
		MongoCollection<Document> collection = database.getCollection(Collection);
		List<Document> documents = (List<Document>)collection.find(new Document("_id", id)).into(new ArrayList<Document>());
		for(Document document : documents){
			@SuppressWarnings("unchecked")
			List<String> res = (List<String>) document.get("result");
			for(String r : res){
				result.add(r);
			}
		}
		mongoClient.close();
		return result;
	}
	
	public ArrayList<String> getDBResult1(String dataBase, String  Collection, String id) {
		ArrayList<String> result = new ArrayList<String>();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase(dataBase);
		MongoCollection<Document> collection = database.getCollection(Collection);
		List<Document> documents = (List<Document>)collection.find(new Document("exercice_name", "files and directories")).into(new ArrayList<Document>());
		for(Document document : documents){
			@SuppressWarnings("unchecked")
			List<Document> res = (List<Document>) document.get("answers");
			for(Document d : res){
				for(int i = 0; i < 4; i++){
					result.add(d.getString("answer "+(i  +1)));
					System.out.println(d.getString("answer "+(i  +1)));
				}
			}
			
		}
		mongoClient.close();
		return result;
	}

	public boolean compareResult(ArrayList<String> commandResult, ArrayList<String> dbResult) {
		for(String res : commandResult)
			if(dbResult.contains(res))
				return true;
		return false;
	}
	
	public ArrayList<String> getAnswersFromDatabase(String databaseName, String collectionName, String element){
		ArrayList<String> db = new ArrayList<String>(); 
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = database.getCollection(collectionName);
		List<Document> documents = (List<Document>) collection.find(new Document("exercice_name", element)).into(new ArrayList<Document>());
		for(Document document : documents){
			@SuppressWarnings("unchecked")
			List<String> answers = (List<String>) document.get("answers");
			for(int i = 0; i < answers.size(); i++){
				db.add(answers.get(i));
				System.out.println(answers.get(i));
			}
		}
		mongoClient.close();
		return db;
	}
	
	public ArrayList<String> getAQuestionsFromDatabase(String databaseName, String collectionName, String element){
		ArrayList<String> db = new ArrayList<String>(); 
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = database.getCollection(collectionName);
		List<Document> documents = (List<Document>) collection.find(new Document("exercice_name", element)).into(new ArrayList<Document>());
		for(Document document : documents){
			@SuppressWarnings("unchecked")
			List<String> answers = (List<String>) document.get("questions");
			for(int i = 0; i < answers.size(); i++){
				db.add(answers.get(i));
				System.out.println(answers.get(i));
			}
		}
		mongoClient.close();
		return db;
	}
	
	public ArrayList<String> executeQuestionQuery(String command)throws IOException{
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "python tester.py " + command);
		pb.directory(new File("/home/mouaad/Desktop/JS/ANGULARJS"));
		Process process = pb.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String s;
		ArrayList<String> array = new ArrayList<String>();
		while((s = in.readLine()) != null){
			array.add(s);
			//System.out.println(s);
		}
		return array;
	}
	
	public String compareAnswersAndUserAnswers(ArrayList<String> array, ArrayList<String> db){
		String t = "";
		for(String r : db){
			if(!array.contains(r)){
				t = "" + false;
				break;
			}
		}
		if(!t.equals("false"))
			t = "" + true;
		return t;
	}
	
}
