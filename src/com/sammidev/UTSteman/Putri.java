package com.sammidev.UTSteman;
import java.util.Scanner;

public class Putri {
    public static void main(String[] args) {
        // soal no 1
        soal1();

        // soal no 2
        int angka = new Scanner(System.in).nextInt();
        int[] a = new int[angka];
        if (angka <= Math.pow(10,2) && angka >= 1) {
            hitungRataRata(a,angka);
        }
    }

    static void soal1() {
        System.out.print("masukkan angka : ");
        int angka = new Scanner(System.in).nextInt();

        for (int i = 1; i <= angka; i++) {
            int temp =  i;
            for (int j = 1; j <= i; j++) {
                System.out.print(temp + " ");
                temp += i;
            }
            System.out.println();
        }
    }

    static void hitungRataRata(int a[], int N) {
        String temp = new Scanner(System.in).nextLine();
        String[] temp2 = temp.split(" ");
        double total = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(temp2[i]);
            total += a[i];
        }
        System.out.println(total / N);
    }
}



