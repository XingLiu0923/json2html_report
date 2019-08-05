package com.json2html.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // templateid，唯一标识
    private String templateId;

    // 状态，0正常1下架
    private Integer templateStatus;

    // 内容
    private String templateContent;
}
