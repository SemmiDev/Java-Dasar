package com.sammidev.tugasKP4;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        mathAPI();
        System.out.println(minimumFunction(2,3));
        rankPointProcedure(89D);
        swapProcedure(30,45);
        JOptionPane.showMessageDialog(
                null,
                "The square of integer 7 is "+square(7)+
                        "\nThe square of double 7.5 is "+square(7.5));
        dadu();

        mathAPI();
        minimumFunction(2,3);
        rankPointProcedure(89);
        swapProcedure(30,45);
        square(7);
        square(7.5);


    }

    /*
     * function/method = with return value
     * procedure = no return value (void)
    */
    public static void mathAPI() {
        double a1,a2;
        String hasil = "";
        String x = JOptionPane.showInputDialog("Input angka 1 : ");
        String y = JOptionPane.showInputDialog("Input angka 2 : ");
        a1 = Double.parseDouble(x);
        a2 = Double.parseDouble(y);
        System.out.println("Hasil x  : " + a1 + "\n y : " + a2);
        hasil += "\n Kuadrat dari x  : " + Math.sqrt(a1);
        hasil += "\n Nilai absolut y : " + Math.abs(a2);
        hasil += "\n Nilai terbesar  : " + Math.max(a1,a2);
        hasil += "\n " + a1 + " ^ " + a2 + " : " + Math.pow(a1,a2);
        JOptionPane.showMessageDialog(null,
                hasil,
                "Contoh Java API",
                JOptionPane.INFORMATION_MESSAGE);
        }
    public static int minimumFunction(int n1, int n2) {
       /*
        @param1 = 2
        @param2 = 3
         int min;
         if (n1 > n2) min = n2;
         else min = n1;
         return min;
        */
        return Math.min(n1, n2);
    }
    public static void rankPointProcedure(double points) {
        // param = 89
        if (points >= 202.5) JOptionPane.showMessageDialog(null,"Rank:A1");
        else if (points >= 122.4) JOptionPane.showMessageDialog(null,"Rank:A2");
        else JOptionPane.showMessageDialog(null,"Rank:A3");
    }
    public static void swapProcedure(int a, int b) {
        // @param1 = 30 param2 = 45
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);
        int c = a; a = b; b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
    }
    public static int square(int intValue){
        // param = 7
        return intValue * intValue;
    }
    public static double square(double doubleValue){
        // param = 7.5
        return doubleValue * doubleValue;
    }
    public static void dadu() {
        int nilaiPemain = 0;
        Random random = new Random();
        int dadu1 = random.nextInt(7);
        int dadu2 = random.nextInt(7);

        System.out.println("lemparan dadu pertama ");
        System.out.println("MELEMPAR ....");
        sleep();
        System.out.println("NILAI DADU -> " + dadu1);

        System.out.println("lemparan dadu kedua ");
        System.out.println("MELEMPAR ....");
        sleep();
        System.out.println("NILAI DADU -> " + dadu2);

        int total = dadu1 + dadu2;
        if (total == 7 || total == 11) {
            System.out.println("MENANG");
            System.exit(0);
        }else if(total == 2 || total == 3 || total == 12) {
            System.out.println("KALAH");
            System.exit(0);
        }else {
            nilaiPemain = total;
            System.out.println("PEMAIN MENDAPAT NILAI : " + nilaiPemain);
        }
        System.out.println("\n------------------------------------------\n");
        int temp1, temp2;
        int totalDadu;
        int repeat = 1;
        do {
            System.out.println("MELEMPAR ...");
            temp1 = random.nextInt(7);
            sleep();
            System.out.println("PEMAIN MENDAPAT NILAI : DADU -> " + temp1);

            System.out.println("MELEMPAR ...");
            temp2 = random.nextInt(7);
            sleep();
            System.out.println("PEMAIN MENDAPAT NILAI DADU -> " + temp2);

            totalDadu = temp1 + temp2;
            System.out.println("TOTAL DADU PEMAIN -> " + totalDadu);
            if (totalDadu == nilaiPemain) {
                System.out.println("\nMENANG!!!");
                System.exit(0);
            }else if (totalDadu == 7 || totalDadu == 11) {
                System.out.println("KALAH!!!");
                System.exit(0);
            }else {
                System.out.println("------------------------------------------- PERULANGAN KE-" + repeat);
                repeat++;
            }
        }while (true);

    }
    static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
