package com.json2html.demo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedHashMap;

public class Json2javaUtil {
    private static final Gson GSON = new GsonBuilder().create();

    public static LinkedHashMap convert(String json) {
        if (json == null) return null;
        else {
            LinkedHashMap<?, ?> map = GSON.fromJson(json, LinkedHashMap.class);
            return map;
        }
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "\n" +
                "\t\"list\": [\"string1\", \"string2\", \"string3\", \"string4\", \"string5\"],\n" +
                "\t\"map\": {\n" +
                "\t\t\"key1\": \"value1\",\n" +
                "\t\t\"key2\": \"value2\",\n" +
                "\t\t\"key3\": \"value3\",\n" +
                "\t\t\"key4\": \"value4\",\n" +
                "\t\t\"key5\": \"value5\"\n" +
                "\t},\n" +
                "\t\"name\": \"   htTps://wWw.zHyD.mE   \",\n" +
                "\t\"htmlText\": \"<span>html内容</span>\",\n" +
                "\t\"num\": 123.012,\n" +
                "\t\"null\": null,\n" +
                "\t\"bol\": true\n" +
                "}";
        //System.out.println(convert(json));
    }
}
