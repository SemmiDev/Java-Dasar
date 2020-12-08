package com.sammidev.tugasFaren;

public class App {
    public static void main(String[] args) {
        System.out.println("hello world");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}