package com.json2html.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    TEMPLATE_UPLOAD_ERROR(10, "模版上传错误"),

    TEMPLATE_NOT_EXIST(11, "模版不存在"),

    JSONDATACONTENT_NULL_ERROR(12, "json数据不存在"),

    REPORTDATA_DOWNLOAD_ERROR(13, "报告数据获取错误"),

    JSONDATA_NOT_EXIST(14, "json数据不存在"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
