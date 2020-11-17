package com.sammidev.unknownTask;

import java.util.*;
public class App {
	public static void main(String[] args) {
		
		String teks;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan teks : ");
		teks = scanner.nextLine();
		
		Character[] chr = new Character[teks.length()];
		Integer[] intg = new Integer[chr.length];
		String[] temp = new String[intg.length];

		for (int i = 0; i < teks.length(); i++) {
			 	chr[i] = teks.charAt(i);
			 	switch(chr[i].toString().toUpperCase()) {
			 		case "A":
			 			intg[i] = 4;
			 			break;
					case "B":
						intg[i] = 3;
						break;
					case "C":
						intg[i] = 2;
						break;
					case "D":
						intg[i] = 1;
						break;
					case "E":
			 			intg[i] = 0;
			 			break;
					default:
						intg[i] = -1;
			 	}
		}

		for (int i = 0; i < intg.length; i++) {
			if (intg[i] != -1) {
				temp[i] = intg[i].toString();
			}else {
				temp[i] = chr[i].toString();
			}
		}

		for (String a : temp) {
			System.out.print(a + "");
		}
	}
}