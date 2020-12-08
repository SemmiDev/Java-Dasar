package com.sammidev.array;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Object[] semuaType = new Object[6];
        semuaType[0] = "Sammidev";
        semuaType[1] = 'a';
        semuaType[2] = true;
        semuaType[3] = 2342;
        semuaType[4] = 4.4F;
        semuaType[5] = 4.4;

        Arrays.stream(semuaType).forEach(System.out::println);
    }
}