package com.json2html.demo.util;


import com.json2html.demo.vo.TemplateIdVO;
import com.json2html.demo.vo.UrlVO;

public class ResultConfigUtil {

    public static TemplateIdVO templateIdResult(String templateId) {
        return new TemplateIdVO(templateId);
    }

    public static UrlVO reportUrl(String Url) {
        return new UrlVO(Url);
    }
}
