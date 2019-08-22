package com.json2html.demo.service.Impl;

import com.json2html.demo.config.MongoConfig;
import com.json2html.demo.service.MongoService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    MongoConfig mongoConfig;

    @Override
    public void save(String collectionName, Document data) {
        MongoDatabase database = mongoConfig.getMongoDatabase();
        MongoCollection collection = database.getCollection(collectionName);
        collection.insertOne(data);
    }

    @Override
    public Document findJsBydataId(String dataId) {
        MongoDatabase database = mongoConfig.getMongoDatabase();
        MongoCollection collection = database.getCollection("jsondata");
        FindIterable<Document> iterable = collection.find(
                new Document("dataId", new Document("$eq", dataId))
        );

        ArrayList<Document> jsonList = new ArrayList<Document>();
        for (Document doc : iterable) {
            jsonList.add(doc);
        }
        return jsonList.get(0);
    }

    @Override
    public Document findTemplateByTemplateId(String templateId) {
        MongoDatabase database = mongoConfig.getMongoDatabase();
        MongoCollection collection = database.getCollection("template");
        FindIterable<Document> iterable = collection.find(
                new Document("templateId", new Document("$eq", templateId))
        );

        ArrayList<Document> templateList = new ArrayList<Document>();
        for (Document doc : iterable) {
            templateList.add(doc);
        }
        return templateList.get(0);
    }
}
