package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        //fileInputStream.
        // 构建FileOutputStream对象,文件不存在会自动新建
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8"));
        outputStreamWriter.append("中文输入");

        outputStreamWriter.append("\r\n");

        outputStreamWriter.append("English");

        outputStreamWriter.close();

        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        StringBuffer stringBuffer = new StringBuffer();

        while (inputStreamReader.ready()){
            stringBuffer.append((char) inputStreamReader.read());
        }

        System.out.println(stringBuffer);

        inputStreamReader.close();

        fileInputStream.close();

        //会在工作盘（D盘）目录下创建tem文件夹
        String  dirName = "/tem/java/bin/bean/hyy";
        File file1 = new File(dirName);

        System.out.println(file1.mkdirs());
    }
}
