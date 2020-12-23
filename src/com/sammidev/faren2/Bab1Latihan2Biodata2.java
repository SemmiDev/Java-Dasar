package com.sammidev.faren2;

import java.util.Scanner;

public class Bab1Latihan2Biodata2 {
    public static void main(String[] args) {

        String nama,nim,ttl,alamat,email,fb,tw;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama : ");
        nama = scanner.nextLine();
        System.out.print("Masukkan nim    : ");
        nim = scanner.nextLine();
        System.out.print("Masukkan ttl    : ");
        ttl = scanner.nextLine();
        System.out.print("Masukkan alamat : ");
        alamat = scanner.nextLine();
        System.out.print("Masukkan email  : ");
        email = scanner.nextLine();
        System.out.print("Masukkan fb     : ");
        fb = scanner.nextLine();
        System.out.print("Masukkan tw     : ");
        tw = scanner.nextLine();

        System.out.println("======================================");
        System.out.println("| Nama   \t : " + nama);
        System.out.println("| NIM   \t : " + nim);
        System.out.println("| TTL   \t : " + ttl);
        System.out.println("| Alamat   \t : " + alamat);
        System.out.println("| Email   \t : " + email);
        System.out.println("| Fb     \t : " + fb);
        System.out.println("| Tw     \t : " + tw);
        System.out.println("======================================");
    }
}
