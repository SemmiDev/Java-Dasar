package com.sammidev.uas;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String kodeBarang,namaBarang;
        int jumlahBeli, hargaSatuan = 0, potongan = 0, total;
        String[] listKodeBarang = {"KD001","KD002","KD003","KD004","KD005"};

        System.out.print("Masukkan kode barang : ");
        kodeBarang = scanner.nextLine();

        System.out.print("Masukkan Nama barang : ");
        namaBarang = scanner.nextLine();

        System.out.print("Masukkan Jumlah Beli : ");
        jumlahBeli = scanner.nextInt();

        if (kodeBarang.equalsIgnoreCase(listKodeBarang[0])) {
            hargaSatuan = 13000;
            potongan = 2500;
        }else if (kodeBarang.equalsIgnoreCase(listKodeBarang[1])) {
            hargaSatuan = 14000;
            potongan = 3500;
        }else if (kodeBarang.equalsIgnoreCase(listKodeBarang[2])) {
            hargaSatuan = 15500;
            potongan = 3000;
        }else if (kodeBarang.equalsIgnoreCase(listKodeBarang[3])) {
            hargaSatuan = 16000;
            potongan = 4500;
        }else if (kodeBarang.equalsIgnoreCase(listKodeBarang[4])) {
            hargaSatuan = 16500;
            potongan = 1500;
        }else {}


        int resultlist[] = {jumlahBeli, hargaSatuan, potongan};
        total = (resultlist[0] * resultlist[1]) - resultlist[2];
        System.out.println("---------------------------------");
        System.out.println("Kode Barang  : " + kodeBarang);
        System.out.println("Nama Barang  : " + namaBarang);
        System.out.println("Jumlah Beli  : " + jumlahBeli + " buah");
        System.out.println("Harga Satuan Rp." + hargaSatuan);
        System.out.println("Potongan     Rp." + potongan);
        System.out.println("Total Bayar  Rp." + total);
    }
}