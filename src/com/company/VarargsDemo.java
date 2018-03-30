package com.company;

public class VarargsDemo {

    public static void main(String[] args){

        int[] ints = new int[]{1,2,3};

        int sumVarargs = sumVarargs(ints);

        System.out.println("Sum-->" + sumVarargs);
    }

    public static int sumVarargs(int... ints){

        if (ints == null || ints.length == 0) return 0;

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum;
    }
}
