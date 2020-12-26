package com.sammidev.faren2.percabangan;

import java.util.Scanner;

public class Kelulusan1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nama anda = ");
        String nama = inp.nextLine();

        System.out.print("Masukkan NIM = ");
        String nim = inp.nextLine();

        System.out.print("Masukkan Nilai = ");
        int nilai = inp.nextInt();

        String statusLulus;

        if (nilai <= 55) {
            statusLulus = "Anda tidak lulus";
        }else {
            statusLulus = "Selamat anda lulus";
        }

        System.out.println(statusLulus);
    }
}
