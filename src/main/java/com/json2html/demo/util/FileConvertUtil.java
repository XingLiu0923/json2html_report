package com.json2html.demo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileConvertUtil {

    /* 将multipartFile转换到字符串 */
    public static String multipartFile2String(MultipartFile multipartFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream input = multipartFile.getInputStream();   // 打开输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            boolean firstLine = true;
            String line = null; ;
            while((line = bufferedReader.readLine()) != null){
                if(!firstLine){
                    stringBuilder.append(System.getProperty("line.separator"));
                }else{
                    firstLine = false;
                }
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stringBuilder.toString() ;
    }
}
