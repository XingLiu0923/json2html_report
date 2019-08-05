package com.json2html.demo.service.Impl;

import com.json2html.demo.dataobject.Template;
import com.json2html.demo.enums.TemplateStatusEnum;
import com.json2html.demo.service.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateServiceImplTest {

    @Autowired
    TemplateService templateService;

    @Test
    public void save() {
        Template template = new Template();
        template.setTemplateId("242351");
        template.setTemplateContent("jdifnceu");
        template.setTemplateStatus(TemplateStatusEnum.UP.getCode());
        templateService.save(template);
    }
}