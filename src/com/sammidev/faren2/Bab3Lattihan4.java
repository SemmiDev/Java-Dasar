package com.sammidev.faren2;

public class Bab3Lattihan4 {
    public static void main(String[] args) {

        boolean b1 = 5 < 10; // true
        boolean b2 = 9 > 11; // false
        boolean b3 = !b1; // false
        boolean b4 = !b2; // true

        System.out.println("TEST AND 1 = " + TestAND1(b1, b2));
        System.out.println("TEST AND 2 = " + TestAND2(b1, b2));
        System.out.println("TEST AND 3 = " + TestAND3(b1, b3));
        System.out.println("TEST AND 4 = " + TestAND4(b1, b4));

        System.out.println("TEST OR 1 = " + TestOR1(b1, b2));
        System.out.println("TEST OR 2 = " + TestOR2(b1, b2));
        System.out.println("TEST OR 3 = " + TestOR3(b1, b3));
        System.out.println("TEST OR 4 = " + TestOR4(b1, b4));

        System.out.println("TEST XOR 1 = " + TestXOR1(b1, b2));
        System.out.println("TEST XOR 2 = " + TestXOR2(b1, b3));
        System.out.println("TEST XOR 3 = " + TestXOR3(b1, b4));

    }

    // metod untuk AND-------------------------------
    static boolean TestAND1(boolean b1, boolean b2) {
        return b1 & b2;
    }
    static boolean TestAND2(boolean b1, boolean b2) {
        return b1 && b2;
    }
    static boolean TestAND3(boolean b1, boolean b3) {
        return b1 && b3;
    }
    static boolean TestAND4(boolean b1, boolean b4) {
        return b1 && b4;
    }


    // method untuk OR------------------------------
    static boolean TestOR1(boolean b1, boolean b2) {
        return b1 | b2;
    }
    static boolean TestOR2(boolean b1, boolean b2) {
        return b1 || b2;
    }
    static boolean TestOR3(boolean b1, boolean b3) {
        return b1 || b3;
    }
    static boolean TestOR4(boolean b1, boolean b4) {
        return b1 || b4;
    }

    // method untuk XOR------------------------------
    static boolean TestXOR1(boolean b1, boolean b2) {
        return b1 ^ b2;
    }
    static boolean TestXOR2(boolean b1, boolean b3) {
        return b1 ^ b3;
    }
    static boolean TestXOR3(boolean b1, boolean b4) {
        return b1 ^ b4;
    }
}