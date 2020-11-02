package com.sammidev.tugas6;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        soal1();
        soal2();
//        soal3();
    }

    static void soal1() {
        char ch = '\u0031' + '\u0035';
        System.out.println(ch); // huruf f

        int n = 0;
        System.out.println(++n); // 1
        System.out.println(n++); // 1
        System.out.println(n++); // 2
    }

    static void soal2() {
        Scanner scanner = new Scanner(System.in);
        String teks1,teks2;
        System.out.print("Masukkan teks 1 : ");
        teks1 = scanner.nextLine();

        System.out.print("Masukkan teks 1 : ");
        teks2 = scanner.nextLine();

        teks1 = teks1.replaceAll("\\s+","");
        teks2 = teks2.replaceAll("\\s+","");

        boolean status;
        if (teks1.equalsIgnoreCase(teks2)) {
            status = true;
        }else {
            status = false;
        }

        System.out.println(status);
    }

    static void soal3() {

        String nilai;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai 10 anak : ");
        nilai = scanner.nextLine();

        for (int i = 0; i < 10; i++) {
            String[] temp = nilai.split(" ");
            int angka  = Integer.parseInt(temp[i]);

            if (angka >= 85 ) {
                System.out.print("A ");
            }else if(angka <= 84 && angka >= 75) {
                System.out.print("B ");
            }else if(angka <= 74 && angka >= 60 ) {
                System.out.print("C ");
            }else if(angka >= 45 && angka <= 59) {}
            else {}
        }
    }
}