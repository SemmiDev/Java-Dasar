package com.sammidev.tugasKP2;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AppJOptionPane {
    static String name = "USER";
    static String dir;
    static Logs logs = new Logs();

    public static void main(String[] args) {
        start();
    }

    static void start() {
        JOptionPane.showMessageDialog(null, "Selamat Datang");
        AppJOptionPane.name =  JOptionPane.showInputDialog("Masukkan Nama Anda ");
        log("USER LOGIN WITH NAME " + AppJOptionPane.name);
        menu();
    }

    static void menu() {
        AppJOptionPane.dir = "C:\\Users\\DELL\\Desktop\\JavaDasar-jawaban-soal-teman\\src\\com\\sammidev\\tugasKP2\\data-" + AppJOptionPane.name + "\\";
        createFolderForUser();
        log(AppJOptionPane.name + " Mengakses menu");
        String mainMessage = "Selamat Datang " + AppJOptionPane.name + " :) \n" +
                "1. Upah Karyawan \n" +
                "2. Cek Status Suhu \n" +
                "3. Gaji Bersih Karyawan \n" +
                "4. Menentuakan Bil terbesar di antara 2 bilangan \n" +
                "5. Menentuakan Bil terbesar di antara 3 bilangan \n" +
                "6. Exit \n\n" +
                "\n Masukkan pilihan anda" ;

        String pilihan =  JOptionPane.showInputDialog(mainMessage);
        int choose = 0;
        try {    
            choose = Integer.parseInt(pilihan);
        }catch (NumberFormatException ex) {
            log("Kesalahan input, gagal parsing dari string to integer");
            JOptionPane.showMessageDialog(null, "Input Salah");
            menu();
        }

        switch (choose) {
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
                Options.next();
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

        String log = hari + " " +
                months[bulan] + " " +
                tahun + " -> " +
                jam + ":" +
                menit + ":" + detik + " ->> " + message;
        logs.add(log + "\n");
        System.out.println(log);
    }

    static class Options {

        static void upahKaryawan() {
            log(AppJOptionPane.name + " Mengakses upah karyawan");
            final int UPAH_PER_JAM = 2000;
            final int UPAH_PER_JAM_LEMBUR = 3000;
            final int LIMIT = 48;
            int jam = 0, jamLembur = 0, gaji, gajiLembur = 0;

            String pilihan =  JOptionPane.showInputDialog("Masukkan total jam anda bekerja");
            try {
                jam = Integer.parseInt(pilihan);
            }catch (NumberFormatException ex) {
                log(AppJOptionPane.name + " Memasukkan input yang salah");
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

            final String result =
                    "Jam kerja lembur anda    : " + jamLembur + " jam\n" +
                    "Bonus hasil kerja lembur : Rp " + gajiLembur + "\n" +
                    "Total gaji : Rp " + gaji;
            JOptionPane.showMessageDialog(null, result);
            next();
        }

        static void cekSuhu() {
            log(AppJOptionPane.name + " Mengakses cek suhu");
            int suhu = 0;
            String pilihan =  JOptionPane.showInputDialog("Masukkan suhu");
            try {
                suhu = Integer.parseInt(pilihan);
            }catch (NumberFormatException ex) {
                log(AppJOptionPane.name + " Memasukkan input yang salah");
                JOptionPane.showMessageDialog(null, "Bukan angka yang anda masukkan");
                compare3Number();
            }

            // switch with lambda style
            String status = switch (suhu) {
                case 30 -> suhu + " Derajat, " + StatusSuhu.PANAS.getDescription();
                case 24 -> suhu + " Derajat, " + StatusSuhu.NORMAL.getDescription();
                case 20 -> suhu + " Derajat, " + StatusSuhu.DINGIN.getDescription();
                default -> suhu + " Derajat, " + StatusSuhu.TIDAK_DIKETAHUI.getDescription();
            };
            log(AppJOptionPane.name + " Status Suhu " + status);
            JOptionPane.showMessageDialog(null, status);
            next();
        }

        enum StatusSuhu {
            PANAS("THE TEMPERATURE STATUS IS HOT (PANAS)"),
            NORMAL("THE TEMPERATURE STATUS IS NORMAL (NORMAL)"),
            DINGIN("THE TEMPERATURE STATUS IS COLD (DINGIN)"),
            TIDAK_DIKETAHUI("THE TEMPERATURE STATUS IS NOT FOUND (TIDAK DIKETAHUI)");

            private final String description;
            StatusSuhu(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }
        }

        static void tunjangan() {
            log(AppJOptionPane.name + " Mengakses tunjangan berdasarkan golongan");
            String golongan =  JOptionPane.showInputDialog("Masukkan golongan (A,B,C, atau D) ");

            double gajiBersih = 0, tunjangan = 0;
            final double golonganA = 400000, golonganB = 500000, golonganC = 750000, golonganD = 900000;
            double pajak = 0;

            if (golongan.equalsIgnoreCase("A")) {
                tunjangan = 0.3 * golonganA;
                pajak = (0.05 * golonganA) + tunjangan;
                gajiBersih = golonganA + tunjangan - pajak;
            } else if (golongan.equalsIgnoreCase("B")) {
                tunjangan = 0.3 * golonganB;
                pajak = (0.05 * golonganB) + tunjangan;
                gajiBersih = golonganB + tunjangan - pajak;
            } else if (golongan.equalsIgnoreCase("C")) {
                tunjangan = 0.3 * golonganC;
                pajak = (0.05 * golonganC) + tunjangan;
                gajiBersih = golonganC + tunjangan - pajak;
            } else if (golongan.equalsIgnoreCase("D")) {
                tunjangan = 0.3 * golonganD;
                pajak = (0.05 * golonganD) + tunjangan;
                gajiBersih = golonganD + tunjangan - pajak;
            } else {
               tunjangan();
            }

            final String result = "" +
                    "Nama : " + name + "\n" +
                    "Golongan : " + golongan + "\n" +
                    "Tunjangan : Rp "+ tunjangan + "\n" +
                    "Pajak : Rp " + pajak + "\n" +
                    "Gaji bersih : Rp " + gajiBersih + "\n";
            log("Data " + result);
            JOptionPane.showMessageDialog(null, result);

            printSalarySlip(result);
        }

        static void compare2Number() {
            log(AppJOptionPane.name + " Mengakses compare 2  numbers");
            int angka1 = 0, angka2 = 0;
            String angka1A =  JOptionPane.showInputDialog("Masukkan angka pertama ");
            String angka1B =  JOptionPane.showInputDialog("Masukkan angka kedua ");

            try {
                angka1 = Integer.parseInt(angka1A);
                angka2 = Integer.parseInt(angka1B);
            }catch (NumberFormatException ex) {
                showErrorNumberFormat();
                compare2Number();
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

        static void showErrorNumberFormat(){
            log(AppJOptionPane.name + " Memasukkan input yang salah");
            JOptionPane.showMessageDialog(null, "Bukan angka yang anda masukkan");
        }

        static void compare3Number() {
            log(AppJOptionPane.name + " mengakses compare 3 numbers");
            int angka1 = 0, angka2 = 0, angka3 = 0;

            String angka1A =  JOptionPane.showInputDialog("Masukkan angka pertama");
            String angka1B =  JOptionPane.showInputDialog("Masukkan angka kedua");
            String angka1C =  JOptionPane.showInputDialog("Masukkan angka ketiga");
            try {
                angka1 = Integer.parseInt(angka1A);
            }catch (NumberFormatException ex) {
                showErrorNumberFormat();
                compare3Number();
            }

            try {
                angka2 = Integer.parseInt(angka1B);
            }catch (NumberFormatException ex) {
                showErrorNumberFormat();
                compare3Number();
            }

            try {
                angka3 = Integer.parseInt(angka1C);
            }catch (NumberFormatException ex) {
                showErrorNumberFormat();
                compare3Number();
            }

            int angkaTerkecil = angka1;
            int angkaTerbesar = angka1;

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
            log("Result " + result);
            next();
        }

        static void next() {
            int jawab = JOptionPane.showOptionDialog(null,
                    "Apakah anda ingin keluar ?",
                    "CONFIRMATION",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,null,null);

            if (jawab == JOptionPane.YES_OPTION){
                log(AppJOptionPane.name + " Keluar dari program");
                questionLog();
            }
            menu();
        }

        static void printSalarySlip(String result) {
            int jawab = JOptionPane.showOptionDialog(null,
                    "Apakah anda ingin cetak slip gaji ?",
                    "PRINT",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,null,null);

            if (jawab == JOptionPane.YES_OPTION) {
                String fileName = AppJOptionPane.dir + "SLIP-GAJI-" + AppJOptionPane.name + ".txt";
                try {
                    FileWriter fileWriter = new FileWriter(fileName);
                    fileWriter.write(result);
                    fileWriter.close();
                } catch (IOException e) {
                    log("FAILED GENERATE AND WRITE FILE SALARY SLIP");
                }

                JOptionPane.showMessageDialog(null, "Hay, " +
                        AppJOptionPane.name.toUpperCase() + ".. File slip gaji kamu telah berhasil dibuat");
            }
            next();
        }

        static void questionLog() {
            int quest = JOptionPane.showConfirmDialog(null,
                    "Apakah anda ingin generate logs ke file ? \n ");

            switch (quest) {
                case JOptionPane.YES_OPTION:
                    printLog();
                    JOptionPane.showMessageDialog(null, "DONE! \nTerima Kasih");
                    clearScreen();
                    System.exit(0);
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(null, "Terima Kasih");
                    System.exit(0);
                case JOptionPane.NO_OPTION:
                    questionLog();
                default:
                    questionLog();
            }
        }

        static void clearScreen() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033\143");
                }
            } catch (Exception ex) {
                System.err.println("tidak bisa clear screen");
            }
        }

        private static void printLog() {
            String fileName = AppJOptionPane.dir + "LOGS-" + AppJOptionPane.name + ".txt";
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(logs.toString());
                fileWriter.close();
            } catch (IOException e) {
                log("FAILED GENERATE LOGS");
                System.exit(0);
            }
        }
    }
    static void createFolderForUser() {
        try {
            Path path = Paths.get(AppJOptionPane.dir);
            Files.createDirectories(path);
        } catch (IOException e) {
            System.out.println("FAILED TO CREATE DIRECTORY : " +  e.getMessage());
        }
    }
}

class Logs {
    final private StringBuilder logs = new StringBuilder("");

    public void add(String message) {
        this.logs.append(message);
    }

    public String toString() {
        return logs.toString();
    }
}