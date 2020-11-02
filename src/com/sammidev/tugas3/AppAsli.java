package com.sammidev.tugas3;
import java.util.Scanner;

public class AppAsli {
    public static void main(String[] args) {
        arithmetcOperation();
        declarationAndInitializationOfDataTypes();
        convertToSecond();
        menghitungKecepatan();
    }

    static void arithmetcOperation () {
        int i = 37;
        int j = 2;
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
        System.out.println(x + " % " + y + " = " + (x % y) + "\n\n");
        System.out.println("\n\n");
    }

    static void declarationAndInitializationOfDataTypes() {
        int number = 10;
        char letter = 'a';
        boolean result = true;
        String str = "hello";

        System.out.println("Number = " + number);
        System.out.println("Letter = " + letter);
        System.out.println("Result = " + result);
        System.out.println("Str    = " + str + "\n\n");
    }

    static void convertToSecond() {
        final int hoursToSecond    = 3600;
        final int minutesToSsecond = 60;
        int jamInput,menitInput,detikInput,result;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jam : ");
        jamInput   = scanner.nextInt();

        System.out.print("Masukkan menit : ");
        menitInput = scanner.nextInt();

        System.out.print("Masukkan detik : ");
        detikInput = scanner.nextInt();

        result = (jamInput * hoursToSecond) + (menitInput * minutesToSsecond) + detikInput;
        System.out.println("Data yang anda masukkan  : ");
        System.out.println("JAM         = " + jamInput);
        System.out.println("MENIT       = " + menitInput);
        System.out.println("TOTAL DETIK = " + result + " seconds \n\n");
    }

    static void menghitungKecepatan() {
        int jarak,kecepatan,waktu;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kecepatan : ");
        kecepatan = scanner.nextInt();

        System.out.print("Masukkan waktu : ");
        waktu = scanner.nextInt();

        jarak = kecepatan * waktu;
        System.out.println("Data yang anda masukkan");
        System.out.println("Kecepatan(v) = " + kecepatan);
        System.out.println("Waktu(t)     = " + waktu);
        System.out.println("Jarak(s)     -> " + jarak + " m");
    }
}