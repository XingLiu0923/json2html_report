package com.json2html.demo.exception;

import com.json2html.demo.enums.ResultEnum;

public class Json2HtmlException extends RuntimeException {

    private Integer code;

    public Json2HtmlException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());

        this.code = code;
    }
}
