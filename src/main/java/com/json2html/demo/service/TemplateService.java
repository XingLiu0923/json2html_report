package com.json2html.demo.service;

import com.json2html.demo.dataobject.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TemplateService {

    // 通过id找
    Template findOneById(Integer id);

    // 通过uid找
    Template findOneByTemplateId(String templateId);

    // 找到所有的模版
    List<Template> findUpAll();
    Page<Template> findAll(Pageable pageable);

    // 存储模版信息
    Template save(Template template);

    // 读取文件信息，转换到字符串并上传到数据库
    Template upload(MultipartFile multipartFile);
}
