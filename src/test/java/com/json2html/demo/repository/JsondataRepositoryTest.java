package com.json2html.demo.repository;

import com.json2html.demo.dataobject.Jsondata;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsondataRepositoryTest {

    @Autowired
    JsondataRepository repository;

    @Test
    public void save() {
        Jsondata jsonData = new Jsondata();
        jsonData.setDataContent("1ihdpfuhwpe9qhf3h9jcnejna");
        jsonData.setDataId("2141");
        repository.save(jsonData);
    }

    @Test
    public void findByDataId() {
        Jsondata jsondata = repository.findByDataId("2141");
        Assert.assertNotNull(jsondata);
    }
}