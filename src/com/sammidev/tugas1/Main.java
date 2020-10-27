package com.sammidev.tugas1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        programBelanja();
        programKaryawan();
        programAirMinum();
        soal4();
    }

    /* DESKRIPSI SOAL
        Seorang ibu berbelanja kebutuhan sehari-hari di warung dekat rumahnya.
        Harga barang-barang yang dibeli Ibu adalah:
        a.	Beras Rp. 10000 per kg
        b.	Daging Rp. 60000 per kg
        c.	Sayuran Rp. 2000 per ikat
        Diinputkan jumlah belanjaan ibu untuk masing-masing barang.
        Buatlah program untuk meminta jumlah pembelian ibu tersebut pada setiap barang,
        kemudian cari total pembelian.
        Kemudian program berlanjut dengan meminta uang pembayaran belanja ibu tersebut
        dan keluarkan total uang kembalian yang dihasilkan.
        Uang kembalian tersebut kemudian konversikan kedalam 5000, 2000, 1000 dan 100.
    */
    static void programBelanja() {
        final int berasPerKG     = 10_000;
        final int dagingPerKG    = 60_000;
        final int sayuranPerIkat = 2_000;

        int qtyBeras,qtyDaging,qtySayuran;
        int uangIbu;
        int totalPembelian, totalKembalian;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan total belanja beras   (kg)   : ");
        qtyBeras   = scanner.nextInt();

        System.out.print("Masukkan total belanja daging  (kg)   : ");
        qtyDaging  = scanner.nextInt();

        System.out.print("Masukkan total belanja sayuran (Ikat) : ");
        qtySayuran = scanner.nextInt();

        totalPembelian = (qtyBeras * berasPerKG) + (qtyDaging * dagingPerKG) + (qtySayuran * sayuranPerIkat);
        System.out.println("TOTAL PEMBELIAN   : " + totalPembelian + "\n");
        System.out.print("MASUKKAN UANG IBU : ");
        uangIbu = scanner.nextInt();

        String status;
        if (uangIbu < totalPembelian) {
            status = "UANG IBU TIDAK CUKUP";
            System.exit(0);
        }else {
            status = "UANG IBU CUKUP";
        }

        int pecahanLimaRibu, pecahanDuaRibu,pecahanSeribu,pecahanSeratus;
        totalKembalian =  (int) uangIbu - totalPembelian;
        pecahanLimaRibu = totalKembalian / 5000;
        pecahanDuaRibu  = (totalKembalian - (pecahanLimaRibu * 5000)) / 2000;
        pecahanSeribu   = (totalKembalian - (pecahanLimaRibu * 5000 + pecahanDuaRibu * 2000)) / 1000;
        pecahanSeratus  = ((totalKembalian - ((pecahanLimaRibu * 5000) + (pecahanDuaRibu * 2000) + (pecahanSeribu * 1000)))) / 100;

        System.out.println("TOTAL KEMBALIAN = " + totalKembalian);
        System.out.println("------------------------------------");
        System.out.println("PECAHAN 5 RB    = " + pecahanLimaRibu);
        System.out.println("PECAHAN 2 RB    = " + pecahanDuaRibu);
        System.out.println("PECAHAN 1 RB    = " + pecahanSeribu);
        System.out.println("PECAHAN 100     = " + pecahanSeratus);
        System.out.println("------------------------------------");
    }

    /* DESKRIPSI SOAL
        Upah karyawan sebuah pabrik tekstil dibayarkan setiap minggu dengan menghitung berapa jam seorang karyawan bekerja dalam minggu tersebut.
        Upah karyawan adalah 3000/jam. Jika karyawan bekerja lebih dari 40 jam,
        kelebihannya dihitung sebagai lembur dengan upah lembur perjam adalah 5000.
        Buatlah program yang menghitung total upah mingguan karyawan pabrik tsb
    */
    static void programKaryawan() {
        final int upahKaryawanPerJam = 3000;
        final int upahLemburPerJam = 5000;
        int totalUpah = 0, totalBonus = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan total jam anda bekerja : ");
        int totalJam = scanner.nextInt();
        if (totalJam < 1) {
            System.out.println("minimal 1 jam bekerja");
            System.exit(0);
        } else if (totalJam < 40 || totalJam == 40) {
            totalUpah = totalJam * upahKaryawanPerJam;
        } else {
            totalBonus = (totalJam - 40) * 5000;
            totalUpah = 40 * 3000 + totalBonus;
        }
        System.out.println("TOTAL JAM   : " + totalJam);
        System.out.println("TOTAL BONUS : " + totalBonus);
        System.out.println("TOTAL UPAH  : " + totalUpah);
    }

    /* DESKRIPSI SOAL
        Perusahaan air minum melakukan sistem pembayaran bertingkat untuk pemakaian air bulanan pelanggannya.
        Untuk pemakaian 20 kubik pertama pelanggan dikenakan biaya 3000/kubik.
        Pemakaian berikutnya dikenakan biaya 5000/kubik.
        Buatlah algoritma yang menghitung biaya pemakaian air pelanggan.
        Buatlah program untuk menangani permasalahan tersebut.
    */
    static void programAirMinum() {
        final int defaultPerKubik = 3000;
        final int defaultTotalKubikPertama = 20;
        int hasil = 0,totalKubik;

        System.out.print("Masukkan total kubik : ");
        Scanner scanner = new Scanner(System.in);
        totalKubik = scanner.nextInt();

        if (totalKubik < defaultTotalKubikPertama) {
            System.out.println("minimal pemakain harus 20 kubik");
        }else if (totalKubik == defaultTotalKubikPertama) {
            hasil = totalKubik * defaultPerKubik;
        }else {
            hasil = (defaultTotalKubikPertama * defaultPerKubik) + ((totalKubik - defaultTotalKubikPertama) * 5000);
        }
        System.out.println("TOTAL KUBIK : " + totalKubik);
        System.out.println("TOTAL BIAYA : " + hasil);
    }


    /* SOAL-4.jpeg*/
    static void soal4() {
        /* SAMPLE
         * 0 + 7  = 7  - 3 = 4
         * 4 + 7  = 11 - 3 = 8
         * 8 + 7  = 15 - 3 = 12
         * 12 + 7 = 19 - 3 = 16
         * 16 + 7 = 23 - 3 = 20
         * 20 + 7 = 27 - 3 = 24
         * 24 + 7 + 31 - 3 = 28
           total = 7 hari
         */

        int H = 0, A = 0, B = 0;
        int hari = 0, calculate = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------KETERANGAN--------------------------");
        System.out.println(" H : tinggi pohon teh \n A : angka kemampuan siput memanjat dalam sehari \n"
                + " B : angka merosotnya siput turun kebawah dalam sehari");
        System.out.println("-----------------------------------------------------------");

        System.out.print("Masukkan tinggi pohon teh : ");
        try {
            H = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ANDA MELANGGAR ATURAN");
            System.exit(0);
        }

        System.out.print("Masukkan angka kemampuan siput memanjat dalam sehari : ");
        try {
            A = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ANDA MELANGGAR ATURAN");
            System.exit(0);
        }

        System.out.print("Masukkan angka merosotnya siput turun kebawah dalam sehari : ");
        try {
            B = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ANDA MELANGGAR ATURAN");
            System.exit(0);
        }

        if (H < B || A < B || H < B) {
            System.out.println("ANDA MELANGGAR ATURAN");
            System.exit(0);
        }

        Boolean status = true;
        while (status) {
            calculate = calculate + A - B;
            hari++;
            if (calculate >= H) {
                status = false;
            }
        }

        System.out.println("H = " + H);
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("Sampai dalam = " + hari + " hari");
    }
}
