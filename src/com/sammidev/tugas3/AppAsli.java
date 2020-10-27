package com.sammidev.tugas3;
import java.util.*;

public class AppAsli {
    public static void main(String[] args) {
        aritmatikaDemo();
        soalNo2();
        convertToSecond();
        menghitungKecepatan();
    }

    static void menghitungKecepatan() {
        // s = v * t
        int s,v,t;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kecepatan : ");
        v = scanner.nextInt();

        System.out.print("Masukkan waktu : ");
        t = scanner.nextInt();

        s = v * t;
        System.out.println("DATA YANG ANDA MASUKKAN ADALAH : ");
        System.out.println("KECEPATAN = " + v);
        System.out.println("WAKTU     = " + t);
        System.out.println("HASIL = " + s + " m");
    }

    static void convertToSecond() {
        final int jamToDetik = 3600;
        final int menitToDetik = 60;
        int result;
        int jamInput,menitInput,detikInput;


        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jam : ");
        jamInput   = scanner.nextInt();
        System.out.print("Masukkan menit : ");
        menitInput = scanner.nextInt();
        System.out.print("Masukkan detik : ");
        detikInput = scanner.nextInt();

        result = (jamInput * jamToDetik) + (menitInput * menitToDetik) + detikInput;
        System.out.println("data yang anda masukkan : ");
        System.out.println("JAM   = " + jamInput);
        System.out.println("MENIT = " + menitInput);
        System.out.println("TOTAL DETIK = " + result);

    }

    static void soalNo2() {
        int number = 10;
        char letter = 'a';
        boolean result = true;
        String str = "hello";

        System.out.println("Number = " + number);
        System.out.println("letter = " + letter);
        System.out.println("result = " + result);
        System.out.println("str = " + str);
    }

    static void aritmatikaDemo() {
        int i = 37;
        int j = 0;
        double x = 27.475;
        double y = 7.22;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        System.out.println("ADDING");
        System.out.println(i + " + " + j + " = " + (i + j));
        System.out.println(x + " + " + y + " = " + (x + y));

        System.out.println("SUBTRACT");
        System.out.println(i + " - " + j + " = " + (i - j));
        System.out.println(x + " - " + y + " = " + (x - y));

        System.out.println("MULTIPLY");
        System.out.println(i + " * " + j + " = " + (i * j));
        System.out.println(x + " * " + y + " = " + (x * y));

        System.out.println("DIVIDE");
        System.out.println(i + " / " + j + " = " + (i / j));
        System.out.println(x + " / " + y + " = " + (x / y));

        System.out.println("MODULO");
        System.out.println(i + " % " + j + " = " + (i % j));
        System.out.println(x + " % " + y + " = " + (x % y));
    }
}