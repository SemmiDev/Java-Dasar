package com.sammidev.tugasFaren;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menggunakanScanner();
        menggunakanBufferedReader();
        menggunakanJoptionpane();
    }

    static void menggunakanScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan n1 : ");
        int n1 = scanner.nextInt();
        System.out.print("Masukkan n2 : ");
        int n2 = scanner.nextInt();
        calculate(n1,n2);
    }
    static void menggunakanBufferedReader() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            int n1 = 0, n2 = 0;
            System.out.print("Masukkan n1 : ");
            n1 = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Masukkan n2 : ");
            n2 = Integer.parseInt(bufferedReader.readLine());
            calculate(n1, n2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void menggunakanJoptionpane() {
        int n1 =  Integer.parseInt(JOptionPane.showInputDialog("Masukkan n1 "));
        int n2 =  Integer.parseInt(JOptionPane.showInputDialog("Masukkan n2 "));
        calculate(n1,n2);
    }

    static void calculate(int n1, int n2) {
        int h1 = (n1 + n2) * (n2 + n1);
        int h2 = (n1 % 4) * n2;
        boolean b1 = h1 >= h2;
        boolean b2 = h2 >= h1;
        boolean b3 = (h1 % 4) == (++h2 % 5);
        boolean b4 = (b1 ^ b3) && (b2 || b3);
        boolean b5 = b2 || (b3 && (b2 ^ b1));
        System.out.println(
                "n1 : " + n1 + "\n"
                        + "n2 : " + n2 + "\n"
                        + "h1 : " + h1 + "\n"
                        + "h2 : " + h2 + "\n");

        System.out.println(
                "b1 : " + b1 + "\n"
                        + "b2 : " + b2 + "\n"
                        + "b3 : " + b3 + "\n"
                        + "b4 : " + b4 + "\n"
                        + "b5 : " + b5);
    }
}