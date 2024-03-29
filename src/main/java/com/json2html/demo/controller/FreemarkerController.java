package com.json2html.demo.controller;

import com.aisp.horizontal.helper.JsonHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.json2html.demo.dataobject.Jsondata;
import com.json2html.demo.dataobject.Template;
import com.json2html.demo.enums.ResultEnum;
import com.json2html.demo.enums.TemplateStatusEnum;
import com.json2html.demo.exception.Json2HtmlException;
import com.json2html.demo.holder.SpringContextHolder;
import com.json2html.demo.service.JsondataService;
import com.json2html.demo.service.TemplateService;
import com.json2html.demo.util.FileConvertUtil;
import com.json2html.demo.util.ResultConfigUtil;
import com.json2html.demo.util.ResultVOUtil;
import com.json2html.demo.vo.ResultVO;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.UUID;

@Controller
@Slf4j
public class FreemarkerController {

    @Autowired
    JsondataService jsondataService;

    @Autowired
    TemplateService templateService;

    /* 上传模版文件来获取页面 */
    @RequestMapping("upload")
    @ResponseBody
    public ResultVO upload(@RequestParam("templatefile") MultipartFile templateFile) {
        // 将模版文件上传转换为字符串；
        String templateContent = FileConvertUtil.multipartFile2String(templateFile);
        if (templateContent == null) {
            throw new Json2HtmlException(ResultEnum.TEMPLATE_UPLOAD_ERROR);
        }

        // 生成templateid
        String templateId = UUID.randomUUID().toString().replaceAll("-", "");

        // 生成模版信息，上传到数据库；
        Template template = new Template();
        template.setTemplateContent(templateContent);
        template.setTemplateId(templateId);
        template.setTemplateStatus(TemplateStatusEnum.UP.getCode());
        templateService.save(template);
        log.info("上传模版成功");

        return ResultVOUtil.success(ResultConfigUtil.templateIdResult(templateId));
    }

    /* 上传模版id和数据，生成下一步请求的链接 */
    @RequestMapping("postdata")
    @ResponseBody
    public ResultVO upload(@RequestParam("templateid") String templateId,
                           @RequestParam("jsondata") String jsonDataContent) {
        if (jsonDataContent == null) {
            throw new Json2HtmlException(ResultEnum.JSONDATACONTENT_NULL_ERROR);
        }
        // 生成jsondataid
        // String jsondataId = String.valueOf(System.currentTimeMillis());
        String jsondataId = UUID.randomUUID().toString().replaceAll("-", "");

        // 将jsondata存储到数据库
        Jsondata jsondata = new Jsondata();
        jsondata.setDataId(jsondataId);
        jsondata.setDataContent(jsonDataContent);
        jsondata.setTemplateId(templateId);
        jsondataService.save(jsondata);
        log.info("jsondata存储成功");

/*        // 验证数据库中是否有响应的模版，生成链接
        Template templatefile = templateService.findOneByTemplateId(templateId);
        if (templatefile == null) {
            throw new Json2HtmlException(ResultEnum.TEMPLATE_NOT_EXIST);
        }*/

        // 拼接出一个请求链接即可。。
        String url = "http://localhost:8080/" + "report" + "/" + jsondataId;
        log.info("链接生成成功");

        return ResultVOUtil.success(ResultConfigUtil.reportUrl(url));
    }

    /* 通过模版id和数据id来获取页面 */
    @RequestMapping(value = "report/{jsondataid}", method = RequestMethod.GET)
    @ResponseBody
    public String report(@PathVariable("jsondataid") String jsondataId) {
        // 通过jsondataId找到对应的jsondata
        Jsondata jsondata = jsondataService.findOneByDataId(jsondataId);
        if (jsondata == null) {
            throw new Json2HtmlException(ResultEnum.JSONDATA_NOT_EXIST);
        }

        // 通过jsondataid找到templateid
        String templateId = jsondata.getTemplateId();

        // 分别从数据库中读取模版字符串和数据字符串
        String templateContent = templateService.findOneByTemplateId(templateId).getTemplateContent();
        String jsondataContent = jsondata.getDataContent();
        if (templateContent == null || jsondataContent == null) {
            throw new Json2HtmlException(ResultEnum.REPORTDATA_DOWNLOAD_ERROR);
        }

        // 将模版字符串设置为模版
        freemarker.template.Configuration cfg = SpringContextHolder.getBean(Configuration.class);
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate(templateId, templateContent);
        cfg.setTemplateLoader(stringTemplateLoader);
        log.info("报告模版设置成功");

        // json字符串到map
        // LinkedHashMap map = Json2javaUtil.convert(jsondata);
        LinkedHashMap map = JsonHelper.parse(jsondataContent, new TypeReference<LinkedHashMap>() {});
        log.info("报告json设置成功");

        // 模版与map结合为新页面html
        String html = null;
        StringWriter writer = new StringWriter();
        try {
            freemarker.template.Template template = cfg.getTemplate(templateId, "utf-8");
            html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        log.info("报告生成成功");

        return html;
    }
}
