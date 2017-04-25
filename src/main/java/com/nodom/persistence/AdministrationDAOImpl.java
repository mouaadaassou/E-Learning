package com.nodom.persistence;

import java.io.BufferedReader;
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

	public ArrayList<String> executeCommand(String command) {
		ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", command);
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

	public boolean compareResult(ArrayList<String> commandResult, ArrayList<String> dbResult) {
		for(String res : commandResult)
			if(dbResult.contains(res))
				return true;
		return false;
	}
	
}
