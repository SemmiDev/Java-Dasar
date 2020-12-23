package com.sammidev.faren2;

public class Bab3Latihan5Operator {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 15;

        int h1 = (n1 + n2) * (n2 + n1);
        int h2 = (n1 % 4) * n2;
        System.out.println("h1 = " + h1);
        System.out.println("h2 = " + h2);

        boolean b1 = h1 >= h2;
        boolean b2 = h2 >= h1;
        boolean b3 = (h1 % 4) == (++h2 % 5);
        boolean b4 = (b1 ^ b3) && (b2 || b3);
        boolean b5 = b2 || (b3 && (b2 ^ b1));

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println("b4 = " + b4);
        System.out.println("b5 = " + b5);
    }
}
