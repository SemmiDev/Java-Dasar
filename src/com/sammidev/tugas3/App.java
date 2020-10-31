package com.sammidev.tugas3;

import java.util.*;

public class App {
    public static void main(String[] args) {
        choose();
    }

    static void choose() {
        new Helper().clearScreen();
        int pilihan;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        try {
            System.out.print("Masukkan pilihan : ");
            pilihan = scanner.nextInt();
            if (pilihan == 1) {
                new SignUp().signUp();
            }else if(pilihan == 2) {
                Login login = new Login();
                login.signIn();
            }else {
                choose();
            }
        }catch (InputMismatchException ex) {
            choose();
        }
    }
}

class SignUp {
    private String username;
    private String password;
    private String confirmPassword;
    static Set<String> accounts = new HashSet<>();

    void signUp() {

        Helper helper = new Helper();
        helper.clearScreen();
        System.out.println("----------PLEASE SIGN UP----------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan username : ");
        this.username = scanner.nextLine();

        System.out.print("Masukkan password : ");
        this.password = scanner.nextLine();

        System.out.print("Masukkan confirm password : ");
        this.confirmPassword = scanner.nextLine();

        String validationCheck = new Validator()
                .validate(
                        this.username,
                        this.password,
                        this.confirmPassword
        );

        if (!(validationCheck.equalsIgnoreCase(STATUS.VALIDATED.name()))) {
            System.out.println(STATUS.SIGN_UP_FAILED.name());
            helper.clearScreen();

            boolean next = Start.next();
            if (next == true) {
               SignUp signUp = new SignUp();
               signUp.signUp();
            }else {
                System.exit(0);
            }
            signUp();
        }

        String fushion = this.username + "," + this.password;
        accounts.add(fushion);
        System.out.println("---" + STATUS.SIGN_UP_SUCCESFULLY.name() +"---");
        new Login().signIn();
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUp signUp = (SignUp) o;
        return Objects.equals(username, signUp.username) &&
                Objects.equals(password, signUp.password) &&
                Objects.equals(confirmPassword, signUp.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, confirmPassword);
    }
}

class Login {

    private String username;
    private String password;

    void signIn() {

        Set<String> datas = Set.of(
                "aminuddin,aminuddin555",
                "sammidev,samidev",
                "adidtya,adidtya123");

        SignUp.accounts.addAll(datas);
        Helper cls = new Helper();
        cls.clearScreen();

        System.out.println("----------PLEASE SIGN IN----------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username : ");
        this.username = scanner.nextLine();

        System.out.print("Masukkan password : ");
        this.password = scanner.nextLine();

        this.username = username.trim();
        this.username = username.replaceAll("\\s+","");
        this.password = password.trim();
        this.password = password.replaceAll("\\s+","");
        String data = this.username + "," + this.password;
        SignUp.accounts.forEach(credential -> {
            if (data.equalsIgnoreCase(credential)) {
                System.out.println(STATUS.LOGIN_SUCCESSFULLY.name());
                new Start().start();
                new Start().header(this.username);
            }
        });

        boolean next = Start.next();
        if (next == true) {
           signIn();
        }else {
          SignUp signUp =  new SignUp();
          signUp.signUp();
        }
    }
}

class Start {

    private static String name;

    static void start() {

        System.out.println("WELCOME " + Start.name);

        Helper helper = new Helper();
        helper.clearScreen();
        int pilihan;

        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("1. OPERASI ARITMATIKA");
        System.out.println("2. PENGISIAN VARIABLE");
        System.out.println("3. KONVERSI SATUAN (JAM,MENIT,DETIK) KE SATUAN DETIK");
        System.out.println("4. KALKULASI KECEPATAN, JARAK, DAN WAKTU");
        System.out.println("5. EXIT");
        System.out.println("-----------------------------------------------------");

        System.out.print("Masukkan nomor pilihan anda : ");
        pilihan = scanner.nextInt();
        boolean isNext = true;

        while (isNext) {
            switch (pilihan) {
                case 1: new ArithmeticOperation().start();
                case 2: new Variable().start();
                case 3: new ConverterToSecond().start();
                case 4: new CalculationOfSpeedDistanceAndTime().start();
                case 5: End.end();
                default: new CommandNotFound("YANG ANDA MASUKKAN SALAH").commandNotFoundPilihan();
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

    void header(String name) {
        this.name = name;
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
            new CommandNotFound("YANG ANDA MASUKKAN SALAH").commandNotFoundPilihan();
            return next();
        }
    }
}

interface ClassInterfaces {
    // TODO : NOT INTERFACE IMPLEMENTED
}

class ArithmeticOperation {

    Helper helper= new Helper();

    static boolean next() {
        Scanner scanner = new Scanner(System.in);
        String status;
        System.out.print("Apakah anda ingin melanjutkan : (yes/no)");
        status = scanner.nextLine();
        if (status.equalsIgnoreCase("yes")) {
            return true;
        }else {
            return false;
        }
    }

    void start() {
        helper.clearScreen();
        System.out.println("----------ARITMATIKA----------");
        String message =
                        "1. Bilangan Bulat \n" +
                        "2. Bilangan Asli";
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
            boolean next = next();
            if (next == true) {
                start();
            }else {
               Start.start();
            }

        }else if (pilihanUser.equalsIgnoreCase("1")) {
            int[] temp = inputInt();
            adding(temp[0], temp[1]);
            substract(temp[0], temp[1]);
            multiply(temp[0], temp[1]);
            modulo(temp[0], temp[1]);
            divide(temp[0], temp[1]);
            boolean next = next();
            if (next == true) {
                start();
            }else {
                End.end();
            }
        }else {
            CommandNotFound commandNotFound = new CommandNotFound("YANG ANDA MASUKKAN SALAH");
            commandNotFound.commandNotFoundPilihan();
            new ArithmeticOperation().start();
        }
    }

    static int[] inputInt() {
        Scanner scanner = new Scanner(System.in);
        String i,j;
        System.out.print("Masukkan angka pertama : ");
        i = scanner.nextLine();

        System.out.print("Masukkan angka kedua   : ");
        j = scanner.nextLine();

        int ii = Integer.parseInt(i);
        int jj = Integer.parseInt(j);
        return new int[]{ii,jj};
    }
    static double[] inputDouble() {
        Scanner scanner = new Scanner(System.in);
        String i,j;
        System.out.print("Masukkan angka pertama : ");
        i = scanner.nextLine();

        System.out.print("Masukkan angka kedua   : ");
        j = scanner.nextLine();

        double ii = Double.parseDouble(i);
        double jj = Double.parseDouble(j);
        return new double[]{ii,jj};
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
            new CannotDividedByZero("PEMBAGI TIDAK BOLEH DENGAN ANGKA NOL YA");
        }else {
            System.out.println("HASIL PEMBAGIAN = " + (x / y));
        }
        footer();
    }
    static void divide(double x, double y) {
        header("DIVIDE");
        showNumber(x,y);
        if (y == 0) {
            new CannotDividedByZero("PEMBAGI TIDAK BOLEH DENGAN ANGKA NOL YA");
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
}

class Variable {

    private static int number      = 10;
    private static String letter   = "a";
    private static boolean result  = true;
    private static String str      = "hello";

    static void start() {
        Scanner scannerAngka = new Scanner(System.in);
        Scanner scannerChar = new Scanner(System.in);
        Scanner scannerBool = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka     : ");
            number = scannerAngka.nextInt();
        }catch (InputMismatchException ex) {
            System.out.println("bukan angka yang anda masukkan, DEFAULT");
        }

        try {
            System.out.print("Masukkan character     : ");
            letter = scannerChar.nextLine();
            if (letter.length() != 1) {
                System.out.println("bukan character yang anda masukkan, DEFAULT");
            }
        }catch (InputMismatchException ex) {
            System.out.println("bukan character yang anda masukkan, DEFAULT");
        }

        try {
            System.out.print("Masukkan boolean   : ");
            result = scannerBool.nextBoolean();
        }catch (InputMismatchException ex) {
            System.out.println("bukan boolean yang anda masukkan, DEFAULT");
        }

        try {
            System.out.print("Masukkan string    : ");
            str = scannerStr.nextLine();
        }catch (InputMismatchException ex) {
            System.out.println("bukan String yang anda masukkan, DEFAULT");
        }

        System.out.println();
        showTableAnswer(number,letter,result,str);
    }

    static void showTableAnswer(int number, String letter, boolean result, String str) {
        System.out.println("Number : " + number);
        System.out.println("Letter : " + letter);
        System.out.println("Result : " + result);
        System.out.println("Str    : " + str);
        boolean next = Start.next();
        if (next == true) {
            start();
        }else {
            Start.start();
        }

    }
}

class ConverterToSecond {

    static void start() {
        int jam,menit,detik,result;
        final int satuJamKeDetik = 3600;
        final int satuMenitKeDetik = 60;

        try {
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
        }catch (InputMismatchException ex) {
            Start.start();
        }

        boolean next = Start.next();
        if (next == true) {
            start();
        }else {
            Start.start();
        }
    }

}
class CalculationOfSpeedDistanceAndTime {
    static void start() {
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
            System.out.println("JARAK YG DITEMPUH = " + rumusJarak + "m");
            boolean next = Start.next();
            if (next == true) {
                start();
            }else {
                Start.start();
            }
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
            boolean next = Start.next();
            if (next == true) {
                start();
            }else {
                Start.start();
            }
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
            System.out.println("WAKTU = " + rumusWaktu + "s");
            boolean next = Start.next();
            if (next == true) {
                start();
            }else {
                Start.start();
            }
        }else  {
            System.out.println("COMMAND NOT FOUND");
          Start.start();
        }
    }
}

class Helper {
    void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex){
            System.err.println("tidak bisa clear screen");
        }
    }

}

class CannotDividedByZero {
    private String message;
    public CannotDividedByZero(String message) {
        this.message = message;
    }

    void showError() {
        System.out.println(this.message);

    }
}

class CommandNotFound {
    private String message;

    public CommandNotFound(String failedMessage) {
        this.message = failedMessage;
    }

    public void commandNotFoundPilihan() {
        System.out.println("PILIHAN " + this.message);
    }
}

class ValidatorErrorHandler{
    private String status;

    public ValidatorErrorHandler(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ValidatorErrorHandler{" +
                "status='" + status + '\'' +
                '}';
    }
}

class Validator {
    String validate(String username,String password,String confirmPassword) {

        String status;
        if (username.length() < 3) {
            status = STATUS.USERNAME_IS_TO_SHORT.name();
            ValidatorErrorHandler sendErrorMessage = new ValidatorErrorHandler(status);
            System.err.println(sendErrorMessage.toString());
            return sendErrorMessage.toString();
        }

        if (password.length() < 6) {
            status = STATUS.PASSWORD_AT_LEAST_6_CHARACTERS.name();
            ValidatorErrorHandler sendErrorMessage = new ValidatorErrorHandler(status);
            System.err.println(sendErrorMessage.toString());
            return sendErrorMessage.toString();
        }

        if (!(password.equalsIgnoreCase(confirmPassword))) {
            status = STATUS.PASSWORD_AND_CONFIRMPASSWORD_NOT_SAME.name();
            ValidatorErrorHandler sendErrorMessage = new ValidatorErrorHandler(status);
            System.err.println(sendErrorMessage.toString());
            return sendErrorMessage.toString();
        }

        username = username.trim();
        username = username.replaceAll("\\s+","");

        return STATUS.VALIDATED.name();
    }

    void stopProgram() {
        System.exit(0);
    }
}

class End {
    static void end() {
        System.out.println("BYE BYE");
        System.exit(0);
    }
}

enum STATUS {
    VALIDATED,
    USERNAME_IS_TO_SHORT,
    PASSWORD_AT_LEAST_6_CHARACTERS,
    PASSWORD_AND_CONFIRMPASSWORD_NOT_SAME,
    SIGN_UP_SUCCESFULLY,
    SIGN_UP_FAILED,
    LOGIN_SUCCESSFULLY,
    ACCOUNT_NOTFOUND,
}