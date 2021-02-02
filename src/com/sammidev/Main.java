// uas jihan
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String kodeBarang,namaBarang;
        int jumlahBeli, total = 0;

        String[] listOfKodeBarang = {"KD001","KD002","KD003","KD004","KD005"};
        String[] listOfNamaBarang= {"Mie Goreng","Teh Celup","Susu Sachet","Kecap Botol","Sauch Cabe Botol"};
        int[] listOfHargaSatuan = {13000,14000,15500,16000,16500};
        int[] listOfPotongan= {2500,3500,3000,4500,1500};
        int[] listOfSubTotal= new int[5];

        for (int i = 0; i < listOfHargaSatuan.length; i++) {
            listOfSubTotal[i] = listOfHargaSatuan[i] - listOfPotongan[i];
        }

        System.out.println("TOKO REMEDIAL MART");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("NO\t\tKODE\t\tNAMA BARANG\t\t\tHARGA SATUAN\t\tPOTONGAN\t\tSUB TOTAL");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < listOfHargaSatuan.length-1; i++) {
            System.out.print(i+1 + "\t\t");
            System.out.print(listOfKodeBarang[i] + "\t\t");
            System.out.print(listOfNamaBarang[i] + "\t\t\t");
            System.out.print(listOfHargaSatuan[i] + "\t\t\t\t");
            System.out.print(listOfPotongan[i] + "\t\t\t");
            System.out.print(listOfSubTotal[i] + "\n");
        }
        System.out.print("5.\t\t");
        System.out.print(listOfKodeBarang[listOfHargaSatuan.length-1] + "\t\t");
        System.out.print(listOfNamaBarang[listOfHargaSatuan.length-1] + "\t");
        System.out.print(listOfHargaSatuan[listOfHargaSatuan.length-1] + "\t\t\t\t");
        System.out.print(listOfPotongan[listOfHargaSatuan.length-1] + "\t\t\t");
        System.out.print(listOfSubTotal[listOfHargaSatuan.length-1] + "\n");

        System.out.print("Masukkan kode barang : ");
        kodeBarang = scanner.next();
        System.out.print("Masukkan nama barang  : ");
        namaBarang = scanner1.nextLine();
        System.out.print("Masukkan jumlah beli : ");
        jumlahBeli = scanner2.nextInt();

        for (int i = 0; i < listOfHargaSatuan.length; i++) {
            if (kodeBarang.equalsIgnoreCase(listOfKodeBarang[i]) &&
                    namaBarang.equalsIgnoreCase(listOfNamaBarang[i])) {

                total = (jumlahBeli * listOfHargaSatuan[i]) - listOfPotongan[i];

                System.out.println("PURCHASE DETAILS");
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("KODE\t\tNAMA BARANG\t\t\tHARGA SATUAN\t\tPOTONGAN\t\tSUB TOTAL");
                System.out.println("-------------------------------------------------------------------------------------");

                System.out.print(listOfKodeBarang[i] + "\t\t");
                System.out.print(listOfNamaBarang[i] + "\t\t\t");
                System.out.print(listOfHargaSatuan[i] + "\t\t\t\t");
                System.out.print(listOfPotongan[i] + "\t\t\t");
                System.out.print(total + "\n");
                System.exit(0);
            }
        }
    }
}