package com.sammidev.tugasFaren;

import javax.swing.*;

public class Joption {
    public static void main(String[] args) {
        joptionPane();
    }

    public static void joptionPane() {
        int n1 = showMessageDialogue("Masukkan bilangan 1 : ");
        int n2 = showMessageDialogue("Masukkan bilangan 2 : ");

        int hasil = calculate(n1, n2);
        showHasil(n1, n2, hasil);
    }

    private static void showHasil(int n1, int n2, int hasil) {
        String result = n1 + " + " + n2 + " = " + hasil;
        JOptionPane.showMessageDialog(null, result);
    }

    public static int calculate(int n1, int n2) {
        return n1 + n2;
    }

    public static int showMessageDialogue(String message) {
        int temp = Integer.parseInt(JOptionPane.showInputDialog(message));
        return temp;
    }
}