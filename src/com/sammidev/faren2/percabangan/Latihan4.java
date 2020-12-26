package com.sammidev.faren2.percabangan;

import java.util.Scanner;

public class Latihan4 {
    public static void main(String[] args) {
        Scanner nilaiInput = new Scanner(System.in);

        System.out.print("Masukkan huruf = ");
        String nilai = nilaiInput.next();

        switch (nilai) {
            case "A":
                System.out.println(4);
                break;
            case "B":
                System.out.println(3);
                break;
            case "C":
                System.out.println(2);
                break;
            case "D":
                System.out.println(1);
                break;
            case "E":
                System.out.println(0);
                break;
            default:
                System.out.println("not found");
        }
    }
}
