package HuaWei_8_30;

import java.util.Scanner;

public class Pro_2 {
	public static long hexToDecimal(String hex) {
		long decimalValue = 0;
		for (int i = 0; i < hex.length(); i++) {
			char hexChar = hex.charAt(i);
			decimalValue = decimalValue * 26 + hexCharToDecimal(hexChar);
		}
		return decimalValue;
	}

	public static int hexCharToDecimal(char ch) {
		if (ch >= 'a' && ch <= 'z')
			;
		return ch - 96;
	}

	public static boolean isLowString(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!(string.charAt(i) >= 'a' && string.charAt(i) <= 'z'))
				return false;
		}
		return true;
	}

	public static boolean isNum(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!(string.charAt(i) >= '0' && string.charAt(i) <= '9'))
				return false;
		}
		return true;
	}

	public static String numToString(String string) {
		int num = Integer.valueOf(string);
		String stri = "";
		while (num != 0) {
			int yu = num % 26;
			stri = numToChar(yu) + stri;
			num = num / 26;
		}
		return stri;
	}

	public static char numToChar(int num) {
		return (char) (num + 96);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			if (isLowString(string)) {
				System.out.println(hexToDecimal(string));
			} else if (isNum(string)) {
				System.out.println(numToString(string));
			} else
				System.out.println("ERROR");
		}
	}
}