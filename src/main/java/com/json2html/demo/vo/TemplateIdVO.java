package com.json2html.demo.vo;

import lombok.Data;

@Data
public class TemplateIdVO {

    String templateId;

    public TemplateIdVO(String templateId) {
        this.templateId = templateId;
    }
}
