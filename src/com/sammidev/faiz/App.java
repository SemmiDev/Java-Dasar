package com.sammidev.faiz;

public class App {
    public static void main(String[] args) {

        int a = 30;
        int b = 11;
        int c = 14;

        int terkecilCaraPertama = nilaiTerkecilCaraPertama(a,b,c);
        int terkecilCaraKedua = nilaiTerkecilCaraKedua(a,b,c);
        int terkecilCaraKetiga = nilaiTerkecilCaraKetiga(a,b,c);

        System.out.println("nilai terkecil menggunakan cara pertama : " + terkecilCaraPertama);
        System.out.println("nilai terkecil menggunakan cara kedua   : " + terkecilCaraKedua);
        System.out.println("nilai terkecil menggunakan cara ketiga  : " + terkecilCaraKetiga);

    }

   public static int nilaiTerkecilCaraPertama(int a, int b, int c) {
        int terkecilTemp = a;
        if (b < terkecilTemp) terkecilTemp = b;
        if (c < terkecilTemp) return c;
        return terkecilTemp;
   }


   public static int nilaiTerkecilCaraKedua(int a, int b, int c) {
        int terkecilTemp = Math.min(a,b);
        terkecilTemp = Math.min(terkecilTemp, c);
        return terkecilTemp;
   }


    public static int nilaiTerkecilCaraKetiga(int a, int b, int c){
        int[] arr = {a, b, c};
        sort(arr, 0, arr.length-1);
        return arr[0];
    }


    public static int partition(int ar[], int start, int end) {
        int pivot = ar[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (ar[j] <= pivot) {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i + 1];
        ar[i + 1] = ar[end];
        ar[end] = temp;
        return (i + 1);
    }

    static void sort(int ar[], int start, int end) {
        if (start < end) {
            int p = partition(ar, start, end);
            sort(ar, start, p - 1);
            sort(ar, p + 1, end);
        }

    }
}
