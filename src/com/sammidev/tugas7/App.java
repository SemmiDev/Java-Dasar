import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		// soal1();
		// soal2();
		// soal3();

		int angka1, angka2,angka3;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan angka 1 : ");
		angka1 = scanner.nextInt();	

		System.out.print("Masukkan angka 2 : ");
		angka2 = scanner.nextInt();

		System.out.print("Masukkan angka 3 : ");
		angka3 = scanner.nextInt();


		soal4(angka1, angka2, angka3);

	}

	static void soal1() {	
		int jam;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan total jam anda bekerja : ");
		jam = scanner.nextInt();

		final int upahPerJam = 2000;
		final int upahPerJamLembur = 3000;
		int limit = 48;
		int jamLembur = 0;
		int gaji = 0;
		int gajiLembur = 0;

		if (jam <= limit) {
			gaji = jam * upahPerJam;
		}else {
			jamLembur = jam - limit;
			gajiLembur = jamLembur * upahPerJamLembur; // 6000
			gaji = gajiLembur +   (jam - jamLembur) * upahPerJam; // 6000 + 96000 = 102000
		}

		System.out.println("Jam kerja lembur anda  : " + jamLembur);
		System.out.println("Bonus           : Rp." + gajiLembur);
		System.out.println("Total Gaji anda : Rp." + gaji);
	}

	static void soal2() {
		int suhu;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan suhu : ");
		suhu = scanner.nextInt();
		String status;

		switch(suhu) {
			case 30 : 
				status = "Panas";
				break;
			case 24 :
				status = "Normal";
				break;
			case 20 :
				status = "Dingin";
				break;
			default : 
				status = "STATUS SUHU TIDAK DIKETAHUI";
		}

		System.out.println(status);
	}


	static void soal3() {
		String name,golongan; // A B C
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan nama : ");
		name = scanner.nextLine();

		System.out.print("Masukkan golongan : ");
		golongan = scanner.next();
		
		final double golonganA = 400;
		final double golonganB = 500;
		final double golonganC = 750;
		final double golonganD = 900;
		double gajiBersih = 0,pajak,tunjangan;

		if (golongan.equalsIgnoreCase("A")) {
			tunjangan = 0.05 * golonganA;
			gajiBersih = golonganA + ((0.3 * golonganA)  + tunjangan) + tunjangan;
		}else if(golongan.equalsIgnoreCase("B")) {
			tunjangan = 0.05 * golonganB;
			gajiBersih = golonganB + ((0.3 * golonganB)  + tunjangan) + tunjangan;
		}else if(golongan.equalsIgnoreCase("C")) {
			tunjangan = 0.05 * golonganC;
			gajiBersih = golonganC + ((0.3 * golonganC)  + tunjangan) + tunjangan;
		}else if(golongan.equalsIgnoreCase("D")) {
			tunjangan = 0.05 * golonganD;
			gajiBersih = golonganD + ((0.3 * golonganD)  + tunjangan) + tunjangan;
		}else {
			System.out.println("Golongan anda tidak benar");
			System.exit(0);
		}

		System.out.println("Nama : " + name);
		System.out.println("Golongan : " + golongan);
		System.out.println("Gaji Bersih : " + gajiBersih);
	}




	static void soal4(int angka1, int angka2) {
		int besar = (angka1 > angka2) ? angka1 : angka2;
		System.out.println("angka 1 : " + angka1);
		System.out.println("angka2  : " + angka2);
		System.out.println("angka terbesar : " + besar);
	}

	static void soal4(int angka1, int angka2, int angka3) {
		int angkaTerbesar = angka1;
		int angkaTerkecil = angka1;

		// terkecil
		if(angka2 < angkaTerkecil) {
			angkaTerkecil = angka2;
		}

		if(angka3 < angkaTerkecil) {
			angkaTerkecil = angka3;
		}
		
		// terbesar
		if(angka2 > angkaTerbesar) {
			angkaTerbesar = angka2;
		}

		if (angka3 > angkaTerbesar){
			angkaTerbesar = angka3;
		}

		System.out.println("terkecil : " + angkaTerkecil);
		System.out.println("terbesar : " + angkaTerbesar);
	}
}