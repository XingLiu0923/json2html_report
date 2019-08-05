package com.json2html.demo.service.Impl;

import com.json2html.demo.dataobject.Jsondata;
import com.json2html.demo.service.JsondataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsondataServiceImplTest {

    @Autowired
    JsondataService jsondataService;

    @Test
    public void save() {
        Jsondata jsondata = new Jsondata();
        jsondata.setDataId("45234");
        jsondata.setDataContent("dfnpinepcq");
        jsondataService.save(jsondata);
    }
}