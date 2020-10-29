package com.sammidev.tugas5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        soalNo1();
        soalNo2();

        boolean status = true;
        while (status) {
            int pilihan;
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Kubus");
            System.out.println("3. Volume Silinder");
            System.out.print("Masukkan pilihan anda : ");
            Scanner scanner = new Scanner(System.in);
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                new Lingkaran().input();
                status =  check();
            }else if (pilihan == 2) {
                new Kubus().input();
                status =  check();
            }else if (pilihan == 3) {
                new Silinder().input();
                status =  check();
            }else {
                System.out.println("Pilihan anda salah");
                status =  check();
            }
        }

    }

    static boolean check() {
        String pilihan;
        System.out.print("Lanjut ? (yes/no) : ");
        Scanner scanner = new Scanner(System.in);
        pilihan = scanner.nextLine();
        if (pilihan.equalsIgnoreCase("yes")) {
            return true;
        }else {
            return false;
        }
    }

    static void soalNo1() {

        float angka1,angka2,hasil;
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan bilangan pertama : ");
        angka1 = scanner.nextFloat();
        System.out.print("masukkan bilangan kedua   : ");
        angka2 = scanner.nextFloat();


        if (angka2 == 0) {
            System.out.println("division by zero");
            System.exit(0);
        }

        hasil = angka1 / angka2;
        System.out.printf("%.3f", hasil);
    }

    static void soalNo2() {
        double ax,bx,c;
        double x1,x2;
        // ax^2 + bx + c = 0

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ax kuadrat : ");
        ax = scanner.nextDouble();

        System.out.print("Masukkan bx         : ");
        bx = scanner.nextDouble();

        System.out.print("Masukkan c          : ");
        c = scanner.nextDouble();


        double determinan = (Math.pow(bx,2)) - (4 * ax * c);
        if (determinan == 0) {
            // dua akar real yang kembar
            x1 = -bx / (2 * ax);
            x2 = x1;
        }else if (determinan > 0) {
            // terdapat dua akar real yg berlainan
            x1 = (-bx + Math.sqrt(determinan)) / (2 * ax);
            x2 = (-bx - Math.sqrt(determinan)) / (2 * ax);
        }else {
            // terdapat dua akar imajiner yg berlainan
            x1 = -bx / (2 * ax) + (Math.sqrt(-determinan) / 2 * ax);
            x2 = -bx / (2 * ax) - (Math.sqrt(-determinan) / 2 * ax);
        }
        System.out.println("X1 = " + x1);
        System.out.println("X2 = " + x2);
    }
}


interface Shape {
    void volume();
    void luas();
    void input();
}

class Lingkaran implements Shape {
    private double jariJari;


    @Override
    public void volume() {}

    @Override
    public void luas() {
        final double luas = Math.PI * Math.pow(this.jariJari, 2);
        System.out.println("Luas lingkaran : " + luas);
    }

    @Override
    public void input() {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jari-jari  : ");
        this.jariJari = scanner.nextDouble();
        luas();
    }
}

class Kubus implements Shape {
    private double sisi;

    @Override
    public void volume() {
        final double result = Math.pow(this.sisi, 3);
        System.out.println("Volume kubus : " + result);
    }

    @Override
    public void luas() {}

    @Override
    public void input() {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masuukkan sisi : ");
        this.sisi = scanner.nextDouble();
        volume();
    }
}

class Silinder implements Shape {

    private double r,t;

    @Override
    public void volume() {
        final double result = Math.PI * Math.pow(this.r,2) * this.t;
        System.out.println("volume silinder : " + result);
    }

    @Override
    public void luas() {}

    @Override
    public void input() {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan jari-jari : ");
        this.r = scanner.nextDouble();
        System.out.print("masukkan tinggi    : ");
        this.t = scanner.nextDouble();
        volume();
    }
}