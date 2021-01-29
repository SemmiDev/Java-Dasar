package entity;

public class Soal4 {
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
