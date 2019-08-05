package com.json2html.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Jsondata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // templateid，唯一标识
    private String dataId;

    // 内容
    private String dataContent;

    // template_id，用来找到对应的template
    private String templateId;
}
