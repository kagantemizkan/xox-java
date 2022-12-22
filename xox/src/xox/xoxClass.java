package xox;

import java.util.*;

public class xoxClass {

	static String[] tahta;
	static String sira;



	static String kazananKontrol()
	{
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = tahta[0] + tahta[1] + tahta[2];
				break;
			case 1:
				line = tahta[3] + tahta[4] + tahta[5];
				break;
			case 2:
				line = tahta[6] + tahta[7] + tahta[8];
				break;
			case 3:
				line = tahta[0] + tahta[3] + tahta[6];
				break;
			case 4:
				line = tahta[1] + tahta[4] + tahta[7];
				break;
			case 5:
				line = tahta[2] + tahta[5] + tahta[8];
				break;
			case 6:
				line = tahta[0] + tahta[4] + tahta[8];
				break;
			case 7:
				line = tahta[2] + tahta[4] + tahta[6];
				break;
			}

			if (line.equals("XXX")) {
				return "X";
			}
			
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(tahta).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "berabere";
			}
		}


		System.out.println(sira + "'ın sırası");
		return null;
	}
	

	
	static void printtahta()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + tahta[0] + " | "
						+ tahta[1] + " | " + tahta[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + tahta[3] + " | "
						+ tahta[4] + " | " + tahta[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + tahta[6] + " | "
						+ tahta[7] + " | " + tahta[8]
						+ " |");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		tahta = new String[9];
		sira = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) {
			tahta[a] = String.valueOf(a + 1);
		}

		System.out.println("XOX");
		printtahta();

		System.out.println(
			"X önce başlıyor lütfen slot seçiniz.");

		while (winner == null) {
			int numInput;
		

			
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println(
						"Geçersiz giriş lütfen tekrar seçiniz.");
					continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(
					"Geçersiz giriş lütfen tekrar seçiniz.");
				continue;
			}
			

			
			if (tahta[numInput - 1].equals(
					String.valueOf(numInput))) {
				tahta[numInput - 1] = sira;

				if (sira.equals("X")) {
					sira = "O";
				}
				else {
					sira = "X";
				}

				printtahta();
				winner = kazananKontrol();
			}
			else {
				System.out.println(
					"Slot zaten girilmiş, Tekrar Giriniz");
			}
		}
	
		
		if (winner.equalsIgnoreCase("berabere")) {
			System.out.println(
				"Berabere");
		}
	
		
		else {
			System.out.println("Tebrikler! " + winner);
		}
	in.close();
	}
}
