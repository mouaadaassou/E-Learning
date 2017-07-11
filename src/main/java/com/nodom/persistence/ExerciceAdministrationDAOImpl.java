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
import com.nodom.domain.Answer;
import com.nodom.domain.Exercice;

@Repository
public class ExerciceAdministrationDAOImpl implements ExerciceAdministrationDAO{
	
	/*
	 * Adding an exercise 
	 * 
	 */
	
	public void addExercice(Exercice exercice) throws IOException{
		String command = "";
		ArrayList<String> result = exercice.getAnswers();
		if(result.size() > 1){
			for(int i = 0; i < result.size() - 1; i++)
				command += result.get(i) + "@";
			command += result.get(result.size()-1);
		}
		else
			if(result.size() != 0)
				command += result.get(0);
		System.out.println(command);
		if(!command.equals("")){
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
		MongoCollection<Document> collection = database.getCollection("exercices");
		Document exerciceName = new Document("exercice_name", exercice.getExerciceName());
		for(String t : array){
			System.out.println(t);
		}
		collection.insertOne(exerciceName.append("questions", exercice.getQuestions()).append("answers", array));
		mongoClient.close();
		}
	}
	
	
	/*
	 * Get the answers or questions from the database 
	 */
	
	public ArrayList<String> getQAFromDatabase(String exercice_name, String QA){
		ArrayList<String> db = new ArrayList<String>(); 
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("Linux");
		MongoCollection<Document> collection = database.getCollection("exercices");
		List<Document> documents = (List<Document>) collection.find(new Document("exercice_name", exercice_name)).into(new ArrayList<Document>());
		for(Document document : documents){
			@SuppressWarnings("unchecked")
			List<String> answers = (List<String>) document.get(QA);
			for(int i = 0; i < answers.size(); i++){
				db.add(answers.get(i));
				System.out.println(answers.get(i));
			}
		}
		mongoClient.close();
		return db;
	}
	
	/*
	 * Execute User Answers 
	 * 
	 */
	
	public ArrayList<String> executeAnswers(Answer answer)throws IOException{
		String command = "";
		/*for(String s : answer.getAnswers()){
			command += s + " @ ";
		}*/
		String[] answers = answer.getAnswers();
		if(answers.length > 1){
			for(int i = 0 ; i < answers.length -1; i++){
				command +=  answers[i]+ " @ ";
			}
			command += answers[answers.length -1];
		}
		else{
			command += answers[0];
		}
		
		System.out.println("this is your command : " + command);
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
		return array;
	}
	
	/*
	 * compare the user answers with the right answers from the database
	 */
	public boolean compareResult(ArrayList<String> userAnswers, ArrayList<String> databaseAnswers){
		for(String s : databaseAnswers)
			if(!userAnswers.contains(s))
				return false;
		return true;
	} 

}
