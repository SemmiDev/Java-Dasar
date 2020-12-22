package com.sammidev.strings;

public class TugasString {
    public static void main(String[] args) {

        // soal 1
        StringBuffer a = new StringBuffer("PHP Exercises and");
        StringBuffer b = new StringBuffer("Python Exercises");
        String concatenated = a.append(" ").append(b).toString();
        System.out.println(concatenated); // PHP Exercises and Python Exercises


        // soal 2
        String original = "abcdefabcdeabcdaaa";
        String second = original.replace("a","");
        System.out.println(second); // bcdefbcdebcd

        // soal 3
        StringBuffer sample = new StringBuffer("zebrazone");
        StringBuffer deleteZAtIndex5 = sample.deleteCharAt(5);
        System.out.println(deleteZAtIndex5); // zebraone

    }
}
