package com.json2html.demo.service.Impl;

import com.json2html.demo.dataobject.Template;
import com.json2html.demo.enums.TemplateStatusEnum;
import com.json2html.demo.repository.TemplateRepository;
import com.json2html.demo.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepository repository;

    @Override
    public Template findOneById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Template findOneByTemplateId(String templateId) {
        return repository.findByTemplateId(templateId);
    }

    @Override
    public List<Template> findUpAll() {
        return repository.findByTemplateStatus(TemplateStatusEnum.UP.getCode());
    }

    @Override
    public Page<Template> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Template save(Template template) {
        return repository.save(template);
    }

    @Override
    public Template upload(MultipartFile multipartFile) {
        return null;
    }
}
