package JD_9;

import java.util.Scanner;

public class pro2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int num = scanner.nextInt();
		long count = 0;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				for (int k = 1; k <= num; k++) {
					for (int p = 1; p <= num; p++) {
						if (Pan(i, j, k, p)) {
							if (count > 1000000007)
								count = count % 1000000007;
							count++;
						}
					}
				}
			}
		}
		System.out.print(count);
	}

	public static boolean Pan(int a1, int a2, int a3, int a4) {
		if ((int) Math.pow(a1, a2) == Math.pow(a3, a4)) {
			return true;
		} else {
			return false;
		}
	}

}
