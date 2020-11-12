package com.sammidev.tugas7;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AppJOptionPane {
    static String name = "User";

    public static void main(String[] args) {
        greeting();
    }

    static void greeting() {
        JOptionPane.showMessageDialog(null, "Selamat Datang");
        AppJOptionPane.name =  JOptionPane.showInputDialog("Masukkan nama anda : ");
        log("USER LOGIN WITH NAME " + AppJOptionPane.name);
        menu();
    }

    static void menu() {
        String mainMessage = "Selamat Datang " + AppJOptionPane.name + "\n" +
                "1. Upah Karyawan \n" +
                "2. Cek Status Suhu \n" +
                "3. Gaji Bersih Karyawan \n" +
                "4. Menentuakan Bil terbesar di antara 2 bilangan \n" +
                "5. Menentuakan Bil terbesar di antara 3 bilangan \n" +
                "6. Exit \n\n" +
                "\n Masukkan pilihan anda" ;

        String pilihan =  JOptionPane.showInputDialog(mainMessage);
        switch (Integer.parseInt(pilihan)) {
            case 1 :
                Options.upahKaryawan();
                break;
            case 2 :
                Options.cekSuhu();
                break;
            case 3:
                Options.tunjangan();
            case 4:
                Options.compare2Number();
            case 5:
                Options.compare3Number();
            case 6:
                log(AppJOptionPane.name + " exit dari program");
                JOptionPane.showMessageDialog(null, "Terima Kasih " + AppJOptionPane.name);
                System.exit(0);
            default:
                menu();
        }
    }

    static void log(String message) {
        int detik,menit,jam,hari,bulan,tahun;
        GregorianCalendar date = new GregorianCalendar();
        String[] months = {
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"};

        detik = date.get(Calendar.SECOND);
        menit = date.get(Calendar.MINUTE);
        jam   = date.get(Calendar.HOUR_OF_DAY);
        hari  = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);

        System.out.println(
                hari + " " +
                months[bulan] + " " +
                tahun + " -> " +
                jam + ":" +
                menit + ":" + detik + " ->> " + message);
    }

    static class Options {

        static void upahKaryawan() {
            log(AppJOptionPane.name + " mengakses upah karyawan");
            final int UPAH_PER_JAM = 2000;
            final int UPAH_PER_JAM_LEMBUR = 3000;
            final int LIMIT = 48;
            int jam = 0, jamLembur = 0, gaji, gajiLembur = 0;

            String pilihan =  JOptionPane.showInputDialog("Masukkan total jam anda bekerja : ");
            try {
                jam = Integer.parseInt(pilihan);
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bukan angka yang anda masukkan");
                compare3Number();
            }

            if (jam <= LIMIT) {
                gaji = jam * UPAH_PER_JAM;
            }else {
                jamLembur = jam - LIMIT;
                gajiLembur = jamLembur * UPAH_PER_JAM_LEMBUR;
                gaji = gajiLembur + (jam - jamLembur) * UPAH_PER_JAM;
            }

            final String result = "Jam kerja lembur anda = " + jamLembur + " jam\n" +
                    "Bonus hasil kerja lembur = Rp." + gajiLembur + "\n" +
                    "Total gaji 		      = Rp." + gaji;
            JOptionPane.showMessageDialog(null, result);
            next();
        }
        static void cekSuhu() {
            log(AppJOptionPane.name + " mengakses suhu");
            int suhu = 0;
            String pilihan =  JOptionPane.showInputDialog("Masukkan suhu");
            try {
                suhu = Integer.parseInt(pilihan);
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bukan angka yang anda masukkan");
                compare3Number();
            }

            // switch with lambda style
            String status = switch (suhu) {
                case 30 -> suhu + " Derajat = PANAS  (HOT)";
                case 24 -> suhu + " Derajat = NORMAL (NORMAL)";
                case 20 -> suhu + " Derajat = DINGIN (COOL)";
                default -> suhu + " = STATUS SUHU TIDAK DIKETAHUI";
            };

            JOptionPane.showMessageDialog(null, status);
            next();
        }

        static void tunjangan() {
            log(AppJOptionPane.name + " mengakses golongan");
            String golongan =  JOptionPane.showInputDialog("Masukkan golongan (A,B,C, atau D) ");

            double gajiBersih = 0, tunjangan;
            final double golonganA = 400, golonganB = 500, golonganC = 750, golonganD = 900;

            if (golongan.equalsIgnoreCase("A")) {
                tunjangan = 0.05 * golonganA;
                gajiBersih = golonganA + ((0.3 * golonganA) + tunjangan) + tunjangan;
            } else if (golongan.equalsIgnoreCase("B")) {
                tunjangan = 0.05 * golonganB;
                gajiBersih = golonganB + ((0.3 * golonganB) + tunjangan) + tunjangan;
            } else if (golongan.equalsIgnoreCase("C")) {
                tunjangan = 0.05 * golonganC;
                gajiBersih = golonganC + ((0.3 * golonganC) + tunjangan) + tunjangan;
            } else if (golongan.equalsIgnoreCase("D")) {
                tunjangan = 0.05 * golonganD;
                gajiBersih = golonganD + ((0.3 * golonganD) + tunjangan) + tunjangan;
            } else {
               tunjangan();
            }

            final String result = "" +
                    "Nama        : " + name + "\n" +
                    "Golongan    : " + golongan + "\n" +
                    "Gaji bersih : " + gajiBersih + "\n\n" +
                    "FILE NOTA BERHASIL DIBUAT";
            log(AppJOptionPane.name + " file nota berhasil dibuat");

            String fileName = "src\\com\\sammidev\\tugas7\\nota-" + AppJOptionPane.name + ".txt";
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(result);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("FAILED ");
            }

            JOptionPane.showMessageDialog(null, result);
            next();
        }

        static void compare2Number() {
            log(AppJOptionPane.name + " mengakses compare 2  numbers");
            int angka1 = 0, angka2 = 0;
            String angka1A =  JOptionPane.showInputDialog("Masukkan angka pertama ");
            String angka1B =  JOptionPane.showInputDialog("Masukkan angka kedua ");

            try {
                angka1 = Integer.parseInt(angka1A);
                angka2 = Integer.parseInt(angka1B);
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bukan angka yang anda masukkan");
                compare3Number();
            }

            /*
               TERNARY OPERATOR
			   int besar = if (angka1 < angka2) ? angka2 : angka1;
		    */

            int besar = Math.max(angka1, angka2);
            final String result = "" +
                    "Angka pertama : " + angka1 + "\n" +
                    "Angka kedua   : " + angka2 + "\n" +
                    "Angka TERBESAR  : " + besar;
            JOptionPane.showMessageDialog(null, result);
            next();
        }

        static void compare3Number() {
            log(AppJOptionPane.name + " mengakses compare 3 numbers");
            int angka1 = 0, angka2 = 0, angka3 = 0;

            String angka1A =  JOptionPane.showInputDialog("Masukkan angka pertama");
            String angka1B =  JOptionPane.showInputDialog("Masukkan angka kedua");
            String angka1C =  JOptionPane.showInputDialog("Masukkan angka ketiga");
            try {
                angka1 = Integer.parseInt(angka1A);
                angka2 = Integer.parseInt(angka1B);
                angka3 = Integer.parseInt(angka1C);
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bukan angka yang anda masukkan");
                compare3Number();
            }

            int angkaTerkecil = angka1, angkaTerbesar = angka1;

            // TERKECIL
            if (angka2 < angkaTerkecil) angkaTerkecil = angka2;
            if (angka3 < angkaTerkecil) angkaTerkecil = angka3;

            // TERBESAR
            if (angka2 > angkaTerbesar) angkaTerbesar = angka2;
            if (angka3 > angkaTerbesar) angkaTerbesar = angka3;

            final String result = "" +
                    "Angka terkecil = " + angkaTerkecil + "\n" +
                    "Angka terbesar = " + angkaTerbesar;
            JOptionPane.showMessageDialog(null, result);
            next();
        }

        static void next() {
            String pilihan =  JOptionPane.showInputDialog("1. Menu \n" + "2. Exit");
            log(AppJOptionPane.name + " memasukkan pilihan " + pilihan);
            if (Integer.parseInt(pilihan) == 1) {
                menu();
            }else if(Integer.parseInt(pilihan) == 2){
                System.exit(0);
            }else {
                next();
            }
        }
    }
}