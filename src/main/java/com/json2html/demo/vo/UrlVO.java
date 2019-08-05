package com.json2html.demo.vo;

import lombok.Data;

@Data
public class UrlVO {
    String url;

    public UrlVO(String url) {
        this.url = url;
    }
}
