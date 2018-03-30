package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        //使用System.in() 获取 BufferReader
        char c;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("输入单个字符， 按下'q'字母退出");

        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        }while (c != 'q');

        System.out.write('B');
        System.out.write('\n');
    }
}
