package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BfrReadLine {
    public static void main(String[] args) throws IOException {

        String test;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter lines of text");
        System.out.println("Enter 'end' to quit");

        do {
            test = bufferedReader.readLine();
            System.out.println(test);
        }while (!test.equals("end"));
    }
}
