package QuNai;

import java.util.Scanner;

public class Min2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		String[] str = scan.nextLine().split(" ");
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		int dis = calculateDis(str1, str1.length(), str2, str2.length(), dp);
		// display(dp, str1, str2);
		System.out.println(dis + 1);

	}

	public static int calculateDis(String str1, int index1, String str2,
			int index2, int[][] dp) {
		if (index1 == 0 && index2 == 0) {
			dp[index1][index2] = 0;
			return 0;
		}

		if (index1 == 0 && index2 > 0) {
			dp[index1][index2] = index2;
			return index2;
		}

		if (index1 > 0 && index2 == 0) {
			dp[index1][index2] = index1;
			return index1;
		}

		int t1 = calculateDis(str1, index1 - 1, str2, index2, dp) + 1;
		int t2 = calculateDis(str1, index1, str2, index2 - 1, dp) + 1;
		int t3 = calculateDis(str1, index1 - 1, str2, index2 - 1, dp);
		if (str1.charAt(index1 - 1) != str2.charAt(index2 - 1)) {
			t3 = t3 + 1;
		}
		int result = min(t1, t2, t3);
		dp[index1][index2] = result;
		return result;

	}

	private static int min(int a, int b, int c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c);
	}
}
