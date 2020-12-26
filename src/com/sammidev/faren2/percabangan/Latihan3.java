package com.sammidev.faren2.percabangan;

import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nama anda = ");
        String nama = inp.nextLine();

        System.out.print("Masukkan jenis kelamin(Laki-Laki / Perempuan) = ");
        String jenisKelamin = inp.nextLine();

        System.out.print("Masukkan tinggi badan = ");
        int tinggiBadan = inp.nextInt();

        String status = null;

        if (jenisKelamin.equalsIgnoreCase("Laki-Laki")) {
            if (tinggiBadan >= 0 && tinggiBadan <= 170) {
                status = "Anda Gagal";
            }else if (tinggiBadan >= 171 && tinggiBadan <= 230) {
                status = "Selamat Anda Lulus";
            }else {
                status = "Not Found";
            }
        }else if (jenisKelamin.equals("Perempuan")) {
            if (tinggiBadan >= 0 && tinggiBadan <= 160) {
                status = "Anda Gagal";
            }else if (tinggiBadan >= 161 && tinggiBadan <= 210) {
                status = "Selamat Anda Lulus";
            }else {
                status = "Not Found";
            }
        }
        System.out.println(status);
    }
}
