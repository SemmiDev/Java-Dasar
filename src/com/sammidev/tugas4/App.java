package com.sammidev.tugas4;
import java.util.*;


public class App {
    public static void main(String[] args) {

        // flowchart = ladangprogrammer.blogspot.com
        // keyword   = contoh algoritma flowchart dan pseudocode

//        luasLingkaran();
//        jamMenitToDetik();
//        genapGanjil();
//        luasLingkaran();
//        minMaxRataRata();
        answer();
    }

    static void luasPersegiPanjang() {

        float panjang,lebar,hasil;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan panjang  : ");
        panjang = scanner.nextFloat();

        System.out.print("Masukkan lebar  : ");
        lebar = scanner.nextFloat();

        hasil = panjang * lebar;
        System.out.println("luas persegi panjang = " + hasil);
    }

    static void jamMenitToDetik() {

        final int satuJamKeDetik = 3600;
        final int satuMenitKeDetik = 60;

        String namaInput;
        int inputJam,inputMenit,hasil;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama  : ");
        namaInput = scanner.nextLine();

        System.out.print("Masukkan jam   : ");
        inputJam = scanner.nextInt();

        System.out.print("Masukkan menit : ");
        inputMenit = scanner.nextInt();

        hasil = (inputJam * satuJamKeDetik) + (inputMenit * satuMenitKeDetik);
        System.out.println("Nama anda = " + namaInput);
        System.out.println("Hasil     = " + hasil);
    }

    static void genapGanjil() {
        int angkaInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan angka yang ingin anda check : ");
        angkaInput = scanner.nextInt();

        if (angkaInput % 2 == 0) {
            System.out.println("angka " + angkaInput + " = GENAP");
        }else {
            System.out.println("angka " + angkaInput + " = GANJIL");
        }
    }

    static void luasLingkaran() {
        final float phi = 3.14f;
        float jariJariInput,hasil;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jari-jari = ");
        jariJariInput = scanner.nextFloat();

        hasil = phi *  jariJariInput *  jariJariInput;
        System.out.println("Luas lingkaran = " + hasil);
    }

    static void minMaxRataRata(){
        int angka1,angka2,angka3;
        int min,max,average = 0;
        // 0 1 2
        int[] kumpulanAngka = new int[3];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka pertama : ");
        angka1 = scanner.nextInt();

        System.out.print("Masukkan angka kedua : ");
        angka2 = scanner.nextInt();

        System.out.print("Masukkan angka ketiga : ");
        angka3 = scanner.nextInt();

        kumpulanAngka[0] = angka1;
        kumpulanAngka[1] = angka2;
        kumpulanAngka[2] = angka3;

        min = kumpulanAngka[0];
        max = kumpulanAngka[0];

        for (int i = 0; i < kumpulanAngka.length; i++) {
            if (kumpulanAngka[i] < min) {
                min = kumpulanAngka[i];
            }else if(kumpulanAngka[i] > max) {
                max = kumpulanAngka[i];
            }

            average += kumpulanAngka[i];
        }
        System.out.println("maximum   = " + max);
        System.out.println("minimum   = " + min);
        System.out.println("rata-rata = " + average / kumpulanAngka.length);
    }


    static void answer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Banyaknya data : ");
        int banyakData = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < banyakData; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Data ke-" + (i + 1) + " : " );
            total += input.nextDouble();
        }
        System.out.println("Rata-rata : " + total / banyakData);
        System.out.println("Jumalh    : " + total);
    }
}