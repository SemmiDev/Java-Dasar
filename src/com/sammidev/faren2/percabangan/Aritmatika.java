package com.sammidev.faren2.percabangan;

public class Aritmatika  {
	public static void main(String[] args) {
		int a = 12;
		int b = 8;
		int c = 5;

		int hasil =  hasil1(a,b,c);
		int hasil2 = hasil2(a,b,c);
		int hasil3 = hasil3(a,b,c);
		int hasil4 = hasil4(a,b,c);
		int hasil5 = hasil5(a,b,c);
		int hasil6 = hasil6(a,b,c);

		System.out.println(hasil);
		System.out.println(hasil2);
		System.out.println(hasil3);
		System.out.println(hasil4);
		System.out.println(hasil5); 
		System.out.println(hasil6);

	}

	public static int hasil1(int x, int y, int z) {
		int hasil =  x + y - z;
		return hasil;
	}
	public static int hasil2(int x, int y, int z) {
		int hasil =  x * y / z;
		return hasil;
	}
	public static int hasil3(int x, int y, int z) {
		int hasil =  x + y * z;
		return hasil;
	}
	public static int hasil4(int x, int y, int z) {
		int hasil =  x + y / z;
		return hasil;
	}
	public static int hasil5(int x, int y, int z) {
		int hasil =  (x + y) * z;
		return hasil;
	}
	public static int hasil6(int x, int y, int z) {
		int hasil =  (x - y) * z;
		return hasil;
	}

}