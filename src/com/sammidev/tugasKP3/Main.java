package com.sammidev.tugasKP3;
import java.util.*;

public class Main {
	public static void main(String[] args) {
//		soal1();
//		soal2();
		soal3();
//		soal4();
//		soal4Gaya2();
//		soal5();
	}

	static void soal1() {
		System.out.println("----------------------------------");
		int n;
		int total = 0;
		double rataRata;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan angka : ");
		n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Angka ke-" + i);
			total += i;
		}

		rataRata = (double) total / n;
		System.out.println("Total : " + total);
		System.out.println("Rata-Rata : " + rataRata);
		System.out.println("----------------------------------\n\n");
	}


	static void soal2() {
		System.out.println("----------------------------------");
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan angka : ");
		n = scanner.nextInt();
		int hasil = factorial(n);
		int hasilGaya2 = factorialGaya2(n);
		System.out.println(hasil);
		System.out.println(hasilGaya2);
		System.out.println("----------------------------------\n\n");
	}

	static int factorial(int n) {
		if (n == 0) {
			return 1;
		}

		return n * factorial(n-1);
	}


	static int factorialGaya2(int n) {
		if (n == 0) {
			return 1;
		}

		int total = 1;
		for (int i = 1; i <= n; i++) {
			total *= i;
		}

		return total;
	}

	static void soal3() {
		System.out.println("----------------------------------");
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan angka : ");
		n = scanner.nextInt();

	List<Integer> oddList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				oddList.add(i);
			}
		}
		int limit = 10, j = 0;
		try {
			do  {
				for (int i = j; i < limit; i++) {
					if (oddList.get(i) < 10) {
						System.out.print("  " + oddList.get(i) + "  ");
					}else{
						System.out.print(" " + oddList.get(i) + "  ");
					}
				}
				System.out.println();
				j += 10;
				limit += 10;

			}while (true);
		}catch (IndexOutOfBoundsException ignored) {}
	}

	static void soal4() {
		System.out.println("----------------------------------");
		int n,p;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan angka : ");
		n = scanner.nextInt();
		System.out.print("Masukkan banyak pengulangan : ");
		p = scanner.nextInt();

		System.out.println(Math.pow(n,p));
		System.out.println("----------------------------------\n\n");
	}

	static void soal4Gaya2() {
		System.out.println("----------------------------------");
		int n,p,total = 1;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Masukkan angka : ");
		n = scanner.nextInt();
		System.out.print("Masukkan banyak pengulangan : ");
		p = scanner.nextInt();

		for(int i = 1; i <= p; i++) {
			total = total * n;
		}

		System.out.println(total);
		System.out.println("----------------------------------\n\n");
	}



	static void soal5(){
		System.out.println("----------------------------------");
		int jumlahBarang = 1;
		double hargaBarang;
		int totalHarga = 0;

		do {
			System.out.print("Masukkan jumlah barang : ");
			jumlahBarang = new Scanner(System.in).nextInt();
			if (jumlahBarang == 0) {
				show(totalHarga);
			}
			System.out.print("Masukkan harga barang  : ");
			hargaBarang = new Scanner(System.in).nextDouble();
			totalHarga += hargaBarang;
		}while(jumlahBarang != 0);
	}

	static void show(int totalHarga) {
		System.out.println("Total harga yg harus anda bayarkan : " + totalHarga);
		System.exit(0);
	}
}