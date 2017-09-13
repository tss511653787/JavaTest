package AiQiyi;

import java.math.BigInteger;
import java.util.Scanner;

public class BigInt {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] in = scanner.nextLine().split("\\s+");
		String x1 = in[0];
		int k1 = Integer.parseInt(in[1]);
		String x2 = in[2];
		int k2 = Integer.parseInt(in[3]);
		StringBuilder res1 = new StringBuilder();
		for (int i = 0; i < k1; i++) {
			res1.append(x1);
		}
		StringBuilder res2 = new StringBuilder();
		for (int i = 0; i < k2; i++) {
			res2.append(x2);
		}
		System.out.print(Compare(res1, res2));
	}

	public static String Compare(StringBuilder res1, StringBuilder res2) {
		// TODO Auto-generated method stub
		BigInteger x1 = new BigInteger(res1.toString());
		BigInteger x2 = new BigInteger(res2.toString());
		if (x1.compareTo(x2) > 0) {
			return "Greater";
		} else if (x1.compareTo(x2) == 0) {
			return "Equal";
		} else {
			return "Less";
		}
	}
}
