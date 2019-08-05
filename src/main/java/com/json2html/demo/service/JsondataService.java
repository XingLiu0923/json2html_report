package com.json2html.demo.service;

import com.json2html.demo.dataobject.Jsondata;

public interface JsondataService {

    // 通过uid找到数据
    public Jsondata findOneByDataId(String dataId);

    // save
    public Jsondata save(Jsondata jsondata);
}
