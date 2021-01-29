package entity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SoalNo1 {
    public static void main(String[] args) {
        System.out.println("Program Input Data Diri");
        System.out.println("=======================");

        Scanner scanner = new Scanner(System.in);
        String name,jenisKelamin,hobby,alamat;
        int umur;

        System.out.print("Silahkan masukkan nama : ");
        name = scanner.next();

        System.out.print("Jenis kelamin Anda (L/P) : ");
        jenisKelamin = scanner.next();

        System.out.print("Berapa usia Anda : ");
        umur = scanner.nextInt();

        System.out.print("Apa hobi Anda : ");
        hobby = scanner.next();

        System.out.print("Dimana Anda tinggal : ");
        alamat = scanner.next();


        System.out.println("\n\nTerima kasih telah memasukkan data dengan benar");
        System.out.println("Nama : " + name + "\n" +
                "Jenis Kelamin : " + jenisKelamin + "\n" +
                "Usia : " + umur + "\n" +
                "Hobi : " + hobby + "\n" +
                "Alamat : " + alamat);
    }
}

class SoalNo2 {
    public static void main(String[] args) {
        System.out.println("Program Syair Anak Ayam");
        System.out.println("=======================");
        Scanner scanner = new Scanner(System.in);

        System.out.print("SIlahkan masukkan jumlah anak ayam : ");
        int anakAyam = scanner.nextInt();

        System.out.println(rekursif(anakAyam));
    }

    public static String rekursif(int nAyam) {
        if (nAyam == 1) {
            return "Anak ayam turun " + nAyam + ", mati satu tinggal induknya";
        }

        return "Anak ayam turun " + nAyam + ", mati satu tinggal " + (nAyam-1) + "\n"  + rekursif(nAyam-1);
    }
}

class SoalNo3 {

    public static void main(String[] args) {
        System.out.println("Program POST TEST menu");
        System.out.println("=======================");

        Scanner scanner = new Scanner(System.in);
        int pilihan;
        boolean status = true;

        while (status) {
            System.out.println("1. Tampilkan waktu sekarang");
            System.out.println("2. Tampilkan tipe OS anda");
            System.out.println("3. Tampilkan program input data diri");
            System.out.println("4. Keluar\n");

            System.out.print("Silahkan masukkan pilihan anda : ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.println(LocalDateTime.now());
                status = false;
            }else if (pilihan == 2) {
                System.out.println(System.getProperty("os.name"));
                status = false;
            }else if (pilihan == 3) {
                System.out.println("Program Input Data Diri");
                System.out.println("=======================");

                Scanner scan = new Scanner(System.in);
                String name,jenisKelamin,hobby,alamat;
                int umur;

                System.out.print("Silahkan masukkan nama : ");
                name = scan.next();

                System.out.print("Jenis kelamin Anda (L/P) : ");
                jenisKelamin = scan.next();

                System.out.print("Berapa usia Anda : ");
                umur = scan.nextInt();

                System.out.print("Apa hobi Anda : ");
                hobby = scan.next();

                System.out.print("Dimana Anda tinggal : ");
                alamat = scan.next();

                System.out.println("\n\nTerima kasih telah memasukkan data dengan benar");
                System.out.println("Nama : " + name + "\n" +
                        "Jenis Kelamin : " + jenisKelamin + "\n" +
                        "Usia : " + umur + "\n" +
                        "Hobi : " + hobby + "\n" +
                        "Alamat : " + alamat);
                status = false;
            }else if (pilihan == 4) {
                System.out.print("Yakin ingin keluar (y/t) : ");
                String pil = scanner.next();
                if (pil.equalsIgnoreCase("y")) {
                    status = false;
                }else {
                    status = true;
                }
            }else {
                status = true;
            }
        }
    }
}

class SoalNo4 {
    public static void main(String[] args) {
        double[] nilaiUjianBase = new double[]{80.5, 76.7, 90, 69.3, 70.1, 70.7, 88.5, 95.4, 77.6, 68.3};
        double[] nilaiUjian = new double[]{80.5, 76.7, 90, 69.3, 70.1, 70.7, 88.5, 95.4, 77.6, 68.3};
        String[] namaMahasiswa = new String[]{"Budi","Zulfa","Hasan","Sisil","Adam","Deni","Mirna","Ferdi","Lina","Cyntia"};
        String[] namaMahasiswaBase = new String[]{"Budi","Zulfa","Hasan","Sisil","Adam","Deni","Mirna","Ferdi","Lina","Cyntia"};

        double[] asc = new double[10];
        double[] desc = new double[10];

        bubblesort(nilaiUjian);
        for (int i = 0; i < nilaiUjian.length; i++) {
            asc[i] = nilaiUjian[i];
        }

        int[] arrBaseIndex = new int[10];
        int[] arrBaseIndexNama = new int[10];

        double[] resultTheDesc = reverse(asc, nilaiUjian.length);
        for (int i = 0; i < resultTheDesc.length; i++) {
            for (int j = 0; j < resultTheDesc.length; j++) {
                if (resultTheDesc[i] == nilaiUjianBase[j]) {
                    arrBaseIndex[i] = j;
                }
            }
        }

        String[] namaBaru = new String[10];
        ascBerdasarkanNama(namaMahasiswa);
        for (int i = 0; i < namaMahasiswa.length; i++) {
            namaBaru[i] = namaMahasiswa[i];
        }

        for (int i = 0; i < namaBaru.length; i++) {
            for (int j = 0; j < namaBaru.length; j++) {
                if (namaBaru[i].equalsIgnoreCase(namaMahasiswaBase[j])) {
                    arrBaseIndexNama[i] = j;
                }
            }
        }

        System.out.println("HASIL PENGURUTAN ASCENDING BERDASARKAN NAMA");
        System.out.println("NAMA  -  NILAI");
        for (int i = 0; i < namaBaru.length; i++) {
            System.out.println(namaMahasiswaBase[arrBaseIndexNama[i]] + "     " + nilaiUjianBase[arrBaseIndexNama[i]]);
        }

        System.out.println("\nHASIL PENGURUTAN DESCENDING BERDASARKAN NILAI");
        System.out.println("NAMA  -  NILAI");
        for (int i = 0; i < nilaiUjian.length; i++) {
            System.out.println(namaMahasiswa[arrBaseIndex[i]] + "     " +  resultTheDesc[i]);
        }
    }

    static void ascBerdasarkanNama(String[] namaMahasiswa) {
        String temp;
        for (int i = 0; i < namaMahasiswa.length; i++) {
            for (int j = i+1; j < namaMahasiswa.length; j++) {
                if (namaMahasiswa[i].compareTo(namaMahasiswa[j]) > 0) {
                    temp = namaMahasiswa[i];
                    namaMahasiswa[i] = namaMahasiswa[j];
                    namaMahasiswa[j] = temp;
                }
            }
        }
    }

    static void bubblesort(double[] nilai) {
        int n = nilai.length;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (nilai[j-1] > nilai[j]) {
                    temp = nilai[j-1];
                    nilai[j-1] = nilai[j];
                    nilai[j] = temp;
                }
            }
        }
    }

    static double[] reverse(double[] nilai, int n) {
        double[] b = new double[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j-1] = nilai[i];
            j = j - 1;
        }
        return b;
    }
}

class SoalNo5 {
    public static void main(String[] args) {
        double[] nilaiUjianBase = new double[]{80.5, 76.7, 90, 69.3, 70.1, 70.7, 88.5, 95.4, 77.6, 68.3};
        String[] namaMahasiswaBase = new String[]{"Budi","Zulfa","Hasan","Sisil","Adam","Deni","Mirna","Ferdi","Lina","Cyntia"};
//        int index = binSearch(namaMahasiswaBase, "Zulfa");
//        TODO
    }

/*    static int binSearch(String[] namaMahasiswaBase, String zulfa) {
        int l = 0;
        int r = namaMahasiswaBase.length - 1;

        while (l <= r) {
            int m = l + ( r - l) / 2;
            int res = zulfa.compareTo(namaMahasiswaBase[m]);
            if (res == 0) {
                return m;
            }

            if (res > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }*/
}



