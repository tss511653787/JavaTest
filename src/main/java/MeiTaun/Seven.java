package MeiTaun;

import java.util.Scanner;

public class Seven {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int num = Integer.parseInt(scanner.nextLine());
		String[] in = scanner.nextLine().split("\\s+");
		long[] array = new long[num];
		for (int i = 0; i < num; i++) {
			array[i] = Long.parseLong(in[i]);
		}
		long count = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (j != i) {
					long yu = array[i] % 7;
					// 不拼接
					if (yu == 0) {
						if (array[j] % 7 == 0) {
							count++;
						}
					} else {
						// 拼接
						int len = Length(array[j]);
						long big = (long) Math.pow(10, len);
						long newNum = big + array[j];
						if (newNum % 7 == 0) {
							count++;
						}
					}
				}
			}
		}
		System.out.print(count);
	}

	private static int Length(long l) {
		// TODO Auto-generated method stub
		String s = String.valueOf(l);
		return s.length();
	}
}
