package com.sammidev.faren2.bool;

// © 2021 sammidev

public class Main {
    public static void main(String[] args) {

        // misalkan nilai integer n1 kita isi dengan angka 10
        int n1 = 10;

        // misalkan nilai integer n2 kita isi dengan angka 12
        int n2 = 12;

        /*
         kita isi h1 dengan (n1 + n2) * (n2 + n1);
         = (10 + 12) * (12 + 10)
         = 22 * 22
         = 484
        */
        int h1 = (n1 + n2) * (n2 + n1);

        /*
         kita isi h2 dengan (n1 % 4) * n2;
         = (10 % 4) * 12)
         = 2 * 12
         = 24
        */
        int h2 = (n1 % 4) * n2;

        // kita tampung return nilai dari function2 nya di boolean b1,b2,b3,dan b4
        boolean b1 =  b1(h1, h2);
        boolean b2 =  b2(h1, h2);
        boolean b3 =  b3(h1, h2);
        boolean b4 =  b4(b1, b2, b3);

        // tampilkan hasil nya
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }

    public static Boolean b1(int h1, int h2) {
        // kita cek apakah nilai h1 besar sama dengan h2
        // jika nilai h1 besar sama dengan h2, kita return TRUE, kalau tidak return FALSE
        return h1 >= h2;
    }

    public static Boolean b2(int h1, int h2) {
        // kita cek apakah nilai h2 besar sama dengan h1
        // jika nilai h2 besar sama dengan h1, kita return TRUE, kalau tidak return FALSE
        return h2 >= h1;
    }

    public static Boolean b3(int h1, int h2) {
        // kita cek apakah h1 di modulo 4 sama dengan (h2+1) di modulo dengan 5
        // kalau sama return true, kalau tidak return false
        return (h1 % 4) == (++h2 % 5);
    }

    public static Boolean b4(boolean b1, boolean b2, boolean b3) {
        // kita cek apakah (boolean b1 di AND dengan boolean b3) AND (boolean b2 di OR dengan boolean b3)
        // return true jika kedua nya TRUE, return false jika salah satu false
        return  (b1 ^ b3) && (b2 || b3);
    }
}