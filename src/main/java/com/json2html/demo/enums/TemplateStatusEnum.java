package com.json2html.demo.enums;

import lombok.Getter;

@Getter
public enum TemplateStatusEnum {
    UP(0, "模版可用"),
    DOWN(1, "模版不可用"),
    ;

    private Integer code;

    private String msg;

    TemplateStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
