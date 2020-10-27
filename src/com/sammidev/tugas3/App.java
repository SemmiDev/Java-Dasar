package com.sammidev.tugas3;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("------------- WELCOME ------------- ");
        daftar();
    }

    static void daftar() {
        String username, password, confirm;
        Scanner scanner = new Scanner(System.in);
        String acc[] = who();
        System.out.print("confirm password : ");
        confirm = scanner.nextLine();

        List<SignUp> list = new ArrayList<>();
        if (confirm.equalsIgnoreCase(acc[1])) {
            SignUp signUp = new SignUp(acc[0], acc[1], confirm);
            list.add(signUp);
        } else {
            new Tetteeet("salah");
        }

        String det[] = who();
        list.forEach(a -> {
            if (a.getUsername().equalsIgnoreCase(det[0]) && a.getPassword().equalsIgnoreCase(det[1])) {
                System.out.println("\n\n");
                System.out.println("WELCOME " + det[0]);
                start();
            } else {
                System.err.println("upsss wrong credential");
                System.exit(404);
            }
        });
    }

    static String[] who() {
        String username,password,confirm;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username : ");
        username = scanner.nextLine();
        System.out.print("Masukkan password : ");
        password = scanner.nextLine();

        return new String[]{username,password};
    }

    static void start() {
        System.out.println("\n");
        int pilihan;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("1. ARITMATIKA");
        System.out.println("2. VARIABLE");
        System.out.println("3. KONVERSI (JAM,MENIT,DETIK) KE KE DETIK");
        System.out.println("4. KECEPATAN,JARAK,DAN WAKTU");
        System.out.println("----------------------------------------------");

        System.out.print("Masukkan nomor pilihan anda : ");
        pilihan = scanner.nextInt();
        boolean isNext = true;

        while (isNext) {
            switch (pilihan) {
                case 1: aritmatika();
                case 2: tabel();
                case 3: convert();
                case 4: svt();
                default: new CommandNotFound("YANG ANDA MASUKKAN SALAH").showError();
            }

            boolean isNext2 = next();
            if (isNext2) {
                isNext = true;
            }else {
                isNext = false;
            }
        }

        System.out.println("THANK YOU");
        System.exit(0);
    }

    static boolean next() {
        Scanner scanner = new Scanner(System.in);
        String status;
        System.out.print("Apakah anda ingin melanjutkan : (yes/no)");
        status = scanner.nextLine();
        if (status.equalsIgnoreCase("yes")) {
            return true;
        }else if(status.equalsIgnoreCase("no")){
            return false;
        }else {
            new CommandNotFound("tidak diketahui").showError();
            return next();
        }
    }
    static void aritmatika() {
        System.out.println("-----ARITMATIKA-----");
        String message = "1. Bilangan Bulat \n2. Bilangan Asli";
        String pilihanUser;
        Scanner scanner;

        System.out.println(message);
        scanner = new Scanner(System.in);
        System.out.print("Pilihan anda nomor : ");
        pilihanUser = scanner.next();


        if (pilihanUser.equalsIgnoreCase("2")) {
            double[] temp = inputDouble();
            adding(temp[0], temp[1]);
            substract(temp[0], temp[1]);
            multiply(temp[0], temp[1]);
            modulo(temp[0], temp[1]);
            divide(temp[0], temp[1]);
            start();
        }else if (pilihanUser.equalsIgnoreCase("1")) {
            int[] temp = inputInt();
            adding(temp[0], temp[1]);
            substract(temp[0], temp[1]);
            multiply(temp[0], temp[1]);
            modulo(temp[0], temp[1]);
            divide(temp[0], temp[1]);
            start();
        }else {
            System.out.println("ANDA MEMASUKKAN PILIHAN YANG SALAH");
            aritmatika();
        }
    }
    static int[] inputInt() {
        Scanner scanner = new Scanner(System.in);
        int i,j;
        System.out.print("Masukkan angka pertama : ");
        i = scanner.nextInt();
        System.out.print("Masukkan angka kedua   : ");
        j = scanner.nextInt();
        return new int[]{i,j};
    }
    static double[] inputDouble() {
        Scanner scanner = new Scanner(System.in);
        double i,j;
        System.out.print("Masukkan angka pertama : ");
        i = scanner.nextDouble();
        System.out.print("Masukkan angka kedua   : ");
        j = scanner.nextDouble();
        return new double[]{i,j};
    }

    static void adding(int x, int y) {
        header("ADDING");
        showNumber(x,y);
        System.out.println("HASIL PENJUMLAHAN = " + (x + y));
        footer();
    }
    static void adding(double x, double y) {
        header("ADDING");
        showNumber(x,y);
        System.out.println("HASIL PENJUMLAHAN = " + (x + y));
        footer();
    }
    static void substract(int x, int y) {
        header("SUBSTRACT");
        showNumber(x,y);
        System.out.println("HASIL PENGURANGAN = " + (x - y));
        footer();
    }
    static void substract(double x, double y) {
        header("SUBSTRACT");
        showNumber(x,y);
        System.out.println("HASIL PENGURANGAN = " + (x - y));
        footer();
    }
    static void divide(int x, int y) {
        header("DIVIDE");
        showNumber(x,y);
        if (y == 0) {
            throw new CannotDividedByZero("PEMBAGI TIDAK BOLEH DENGAN ANGKA NOL YA");
        }else {
            System.out.println("HASIL PEMBAGIAN = " + (x / y));
        }
        footer();
    }
    static void divide(double x, double y) {
        header("DIVIDE");
        showNumber(x,y);
        if (y == 0) {
            throw new CannotDividedByZero("PEMBAGI TIDAK BOLEH DENGAN ANGKA NOL YA");
        }else {
            System.out.println("HASIL PEMBAGIAN = " + (x / y));
        }
        footer();
    }
    static void multiply(int x, int y) {
        header("MULTIPLY");
        showNumber(x,y);
        System.out.println("HASIL PERKALIAN = " + (x * y));
        footer();
    }
    static void multiply(double x, double y) {
        header("MULTIPLY");
        showNumber(x,y);
        System.out.println("HASIL PERKALIAN = " + (x * y));
        footer();
    }
    static void modulo(int x, int y) {
        header("MODULO");
        showNumber(x,y);
        System.out.println("HASIL SISA BAGI = " + (x % y));
        footer();
    }
    static void modulo(double x, double y) {
        header("MODULO");
        showNumber(x,y);
        System.out.println("HASIL SISA BAGI = " + (x % y));
        footer();
    }
    static void showNumber(int x, int y) {
        System.out.println("ANGKA 1 = " + x);
        System.out.println("ANGKA 2 = " + y);
    }
    static void showNumber(double x, double y) {
        System.out.println("ANGKA 1 = " + x);
        System.out.println("ANGKA 2 = " + y);
    }
    static void header(String title){
        System.out.printf("---------------- %s\n",title);
    }
    static void footer(){
        System.out.println("---------------");
    }


    static void tabel() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        int number      = 10;
        char letter     = 'a';
        boolean result  = true;
        String str      = "hello";

        System.out.print("Masukkan angka     : ");
        number = scanner.nextInt();

        System.out.print("Masukkan boolean   : ");
        result = scanner.nextBoolean();

        System.out.print("Masukkan string    : ");
        str = scannerStr.nextLine();

        System.out.println();
        showTableAnswer(number,letter,result,str);
    }
    static void showTableAnswer(int number, char letter, boolean result, String str) {
        System.out.println("Number : " + number);
        System.out.println("Letter : " + letter);
        System.out.println("Result : " + result);
        System.out.println("Str    : " + str);
        start();
    }

    static void convert() {
        int jam,menit,detik,result;
        final int satuJamKeDetik = 3600;
        final int satuMenitKeDetik = 60;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jam   : ");
        jam = scanner.nextInt();
        System.out.print("Masukkan menit : ");
        menit = scanner.nextInt();
        System.out.print("Masukkan detik : ");
        detik = scanner.nextInt();

        result = (jam * satuJamKeDetik) + (menit * satuMenitKeDetik) + detik;
        System.out.println("Data yang anda masukkan : ");
        System.out.println("JAM   = " + jam);
        System.out.println("MENIT = " + menit);
        System.out.println("DETIK = " + detik);
        System.out.println("TOTAL = " + result + " detik");
        start();
    }


    static void svt() {
        int kecepatan = 0,jarak = 0,waktu = 0;
        int rumusJarak,rumusKecepatan,rumusWaktu;

        Scanner scanner = new Scanner(System.in);
        int pilihan;
        System.out.println("-----------------------");
        System.out.println("1. MENENTUKAN JARAK)");
        System.out.println("2. MENENTUKAN KECEPATAN)");
        System.out.println("3. MENENTUKAN WAKTU)");
        System.out.println("-----------------------");
        System.out.print("Masukkan pilihan anda : ");
        pilihan = scanner.nextInt();

        if (pilihan == 1) {
            System.out.println("----- MENENTUKAN JARAK -----");
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("masukkan kecepatan : ");
            kecepatan = scanner2.nextInt();
            System.out.print("masukkan waktu     : ");
            waktu = scanner2.nextInt();

            rumusJarak = kecepatan * waktu;
            System.out.println("JARAK YG DITEMPUH = " + rumusJarak);
            start();
        }else if (pilihan == 2) {
            System.out.println("----- MENENTUKAN KECEPATAN -----");
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("masukkan jarak  : ");
            jarak = scanner2.nextInt();
            System.out.print("masukkan waktu  : ");
            waktu = scanner2.nextInt();
            if (waktu == 0) {
                throw new ArithmeticException("TAK BOLEH NOL LHOOOOOOOOOOOOO");
            }
            rumusKecepatan = jarak / waktu;
            System.out.println("KECEPATAN  = " + rumusKecepatan + "m/s");
            start();
        }else if (pilihan == 3) {
            System.out.println("----- MENENTUKAN WAKTU -----");
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("masukkan jarak : ");
            jarak = scanner2.nextInt();
            System.out.print("masukkan kecepatan     : ");
            kecepatan = scanner2.nextInt();

            if (kecepatan == 0) {
                throw new ArithmeticException("TAK BOLEH NOL LHOOOOOOOOOOOOO");
            }
            rumusWaktu = jarak / kecepatan;
            System.out.println("WAKTU = " + rumusWaktu);
            start();
        }else  {
            System.out.println("COMMAND NOT FOUND");
            svt();
        }
    }
}

class CannotDividedByZero extends ArithmeticException{
    public CannotDividedByZero(String message) {
        super(message);
    }
}
class CommandNotFound {
    private String message;
    public CommandNotFound(String message){
        this.message = message;
    }
    public void showError() {
        System.out.println("PERINTAH " + message.toUpperCase());
    }
}

class SignUp {
    private String username;
    private String password;
    private String confirmPass;

    @Override
    public String toString() {
        return "SignUp{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                '}';
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public SignUp(String username, String password, String confirmPass) {
        this.username = username;
        this.password = password;
        this.confirmPass = confirmPass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUp signUp = (SignUp) o;
        return Objects.equals(username, signUp.username) &&
                Objects.equals(password, signUp.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

class Tetteeet {
    public Tetteeet(String message) {
        System.out.println(message.toUpperCase());
        System.exit(0);
    }
}