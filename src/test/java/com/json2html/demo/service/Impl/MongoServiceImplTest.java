package com.json2html.demo.service.Impl;

import com.json2html.demo.service.MongoService;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoServiceImplTest {

    @Autowired
    MongoService mongoService;

    @Test
    public void save() {
        Document jsondata = new Document();
        jsondata.put("dataId", "12");
        jsondata.put("dataContent", 32);
        jsondata.put("templateId", 45);
        mongoService.save("jsondata", jsondata);
    }

    @Test
    public void findJsBydataId() {
        Document jsondata = mongoService.findJsBydataId("12");
        System.out.println(jsondata);
    }
}
