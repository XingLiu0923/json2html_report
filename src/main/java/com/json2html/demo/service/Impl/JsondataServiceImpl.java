package com.json2html.demo.service.Impl;

import com.json2html.demo.dataobject.Jsondata;
import com.json2html.demo.repository.JsondataRepository;
import com.json2html.demo.service.JsondataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsondataServiceImpl implements JsondataService {

    @Autowired
    JsondataRepository repository;

    @Override
    public Jsondata findOneByDataId(String dataId) {
        return repository.findByDataId(dataId);
    }

    @Override
    public Jsondata save(Jsondata jsondata) {
        return repository.save(jsondata);
    }
}
