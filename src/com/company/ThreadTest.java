package com.company;

public class ThreadTest {

    public static void main(String[] args){
        RunnableDemo hyy = new RunnableDemo("HYY");
        hyy.start();

        RunnableDemo hsw = new RunnableDemo("HSW");
        hsw.start();
    }
}
