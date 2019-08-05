package com.json2html.demo.repository;

import com.json2html.demo.dataobject.Template;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateRepositoryTest {

    @Autowired
    TemplateRepository repository;

    @Test
    public void save() {
        Template template = new Template();
        template.setTemplateId("124243");
        template.setTemplateContent("jpdifnreipn");
        template.setTemplateStatus(0);
        repository.save(template);
    }

    @Test
    public void findByTemplateId() {
        Template template = repository.findByTemplateId("124243");
        Assert.assertNotNull(template);
    }

    @Test
    public void findByTemplateStatus() {
        List<Template> templateList = repository.findByTemplateStatus(0);
        Assert.assertNotEquals(0, templateList);
    }
}