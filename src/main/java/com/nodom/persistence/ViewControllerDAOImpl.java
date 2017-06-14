package com.nodom.persistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class ViewControllerDAOImpl implements ViewControllerDAO{

	public List<String> getTestsName() {
		ArrayList<String> testsName = new ArrayList<String>();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("Linux");
		MongoCollection<Document> collection = database.getCollection("test");
		List<Document> list = collection.find().into(new ArrayList<Document>());
		for(Document document : list){
			String name = document.getString("name");
			testsName.add(name);
		}
		mongoClient.close();
		return testsName;
	}

	public List<String> getExercicesName() {
		ArrayList<String> testsName = new ArrayList<String>();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("Linux");
		MongoCollection<Document> collection = database.getCollection("exercices");
		List<Document> list = collection.find().into(new ArrayList<Document>());
		for(Document document : list){
			String name = document.getString("exercice_name");
			testsName.add(name);
		}
		mongoClient.close();
		return testsName;
	}

}
