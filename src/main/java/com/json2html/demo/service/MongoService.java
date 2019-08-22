package com.json2html.demo.service;

import org.bson.Document;

public interface MongoService {

    void save(String collectionName, Document data);

    Document findJsBydataId(String dataId);

    Document findTemplateByTemplateId(String templateId);

}
