package com.json2html.demo.vo;


import lombok.Data;

@Data
public class ResultVO<T> {
    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //详细数据
    private T result;
}