package com.json2html.demo.repository;

import com.json2html.demo.dataobject.Jsondata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsondataRepository extends JpaRepository<Jsondata, Integer> {

    // 通过jsonid找到jsondata
    Jsondata findByDataId(String dataId);
}
