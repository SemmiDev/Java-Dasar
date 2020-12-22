package com.sammidev.strings;

public class Main {
    public static void main(String[] args) {

        // StringBuffer
        var name = new StringBuffer("Sammi");
        name.append(" Aldhi Yanto");
        System.out.println(name); // Sammi Aldhi Yanto

        // reverse()
        var reverse = name.reverse();
        System.out.println(reverse); // otnaY ihdlA immaS

        // delete()
        name.reverse();
        var delete = name.delete(3,7); // index 3 sampai index 6 (offset)
        System.out.println(delete); // Samldhi Yanto

        // insert()
        var insert = name.insert(2, "INSERT"); // start from index 2
        System.out.println(insert); // SaINSERTmldhi Yanto

        // replace()
        var replace = name.replace(3,7,"REPLACE"); // start from index 3-6
        System.out.println(replace); // SaIREPLACETmldhi Yanto

        // length()
        var length = name.length();
        System.out.println(length); // 22

        // concat()
        var concat = name + " ganteng" + " hahaha";
        System.out.println(concat); // SaIREPLACETmldhi Yanto ganteng hahaha

        char[] arrName = {'S','a','m'};
        String nickname = new String(arrName);
        System.out.println(nickname);

        StringBuffer sample = new StringBuffer("sammidev");
        int cap = sample.capacity();
        System.out.println(cap);

        System.out.println(sample.charAt(5));

    }
}

