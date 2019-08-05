package com.json2html.demo.repository;

import com.json2html.demo.dataobject.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Integer> {

    // 通过templateid找到模版
    Template findByTemplateId(String templateId);

    // 找到所有正常状态的模版
    List<Template> findByTemplateStatus(Integer status);
}
