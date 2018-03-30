package com.company;

public class FabonacciDemo {

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            System.out.println("Fabonacci %d is %d\n");
        }
    }


    public static long fabonacci(long number){
        if (number == 0 || number == 1){
            return number;
        }else {
            return fabonacci(number-1) + fabonacci(number-2);
        }
    }
}
