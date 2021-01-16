package com.sammidev.faren2.bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) throws IOException {

        // program biodata menggunakan buffered reader
        programBiodata();

        // program kalkulator menggunakan buffered reader
        programKalkulator();

        // program belanja menggunakan buffered reader
        programBelanja();
    }

    public static void programBiodata() throws IOException {
        System.out.println("---------------PROGRAM BIODATA---------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nama,nim,email;

        System.out.print("Masukkan nama  : ");
        nama = reader.readLine();

        System.out.print("Masukkan NIM   : ");
        nim = reader.readLine();

        System.out.print("Masukkan email : ");
        email = reader.readLine();

        System.out.println("Nama  : " + nama + "\n" +
                           "NIM   : " + nim + "\n" +
                           "Email : " + email + "\n\n");
    }

    public static void programKalkulator() throws IOException {
        System.out.println("---------------PROGRAM KALKULATOR---------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int angka1,angka2;

        System.out.print("Masukkan angka pertama : ");
        angka1 = Integer.parseInt(reader.readLine());

        System.out.print("Masukkan angka kedua : ");
        angka2 = Integer.parseInt(reader.readLine());

        System.out.println("hasil penjumlahan : " + (angka1 + angka2));
        System.out.println("hasil pengurangan : " + (angka1 - angka2));
        System.out.println("hasil perkalian   : " + (angka1 * angka2));
        System.out.println("hasil pembagian   : " + (angka1 / angka2) + "\n\n");
    }

    public static void programBelanja() throws IOException {
        System.out.println("---------------PROGRAM BELANJA---------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity, barang;
        BigDecimal price = BigDecimal.ZERO;

        System.out.println("---Barang tersedia---");
        System.out.println("1. MacBook pro 13 2020 inch apple sillicon M1");
        System.out.println("2. DELL Lattitude 15 2020 Intel I7");
        System.out.println("3. MacBook Pro 15 inch Intel I7 2019");

        System.out.print("Masukkan nomor pilihan barang : ");
        barang = Integer.parseInt(reader.readLine());

        System.out.print("Masukkan total barang yg akan dibeli : ");
        quantity = Integer.parseInt(reader.readLine());

        if (barang == 1) {
            price = new BigDecimal("20000000");
        }else if (barang == 2) {
            price = new BigDecimal("25000000");
        }else if (barang == 3) {
            price = new BigDecimal("18000000");
        }else {
            System.err.println("SALAH INPUT");
        }

        BigDecimal total = price.multiply(BigDecimal.valueOf(quantity));
        System.out.println("total harga yang harus anda bayar : " + total);
    }
}