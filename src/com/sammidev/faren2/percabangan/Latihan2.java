package com.sammidev.faren2.percabangan;

import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner nilaiInput = new Scanner(System.in);

        System.out.print("Masukkan nilai = ");
        int nilai = nilaiInput.nextInt();
        String statusNilai;

        if (nilai >= 0 && nilai <= 55) {
            statusNilai = "E";
        } else if (nilai >= 56 && nilai <= 65) {
            statusNilai = "D";
        } else if (nilai >= 66 && nilai <= 75){
            statusNilai = "C";
        } else if (nilai >= 76 && nilai <= 85) {
            statusNilai = "B";
        } else if (nilai >= 86 && nilai <= 100){
            statusNilai = "A";
        }else {
            statusNilai = "Error";
        }

        System.out.println(statusNilai);
    }
}
