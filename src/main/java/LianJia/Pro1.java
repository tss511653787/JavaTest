package LianJia;

import java.util.Scanner;

public class Pro1 {
	static Scanner scanner = new Scanner(System.in);
	static long arr[][] = new long[101][101];
	static int n, m, p;
	static int mod = 1000000007;

	public static long dfs(int i, int j) {
		if (arr[i][j] != -1)
			return arr[i][j];
		if (i == p) {
			if (j == n) {
				arr[i][j] = 1;
				return 1;
			} else {
				arr[i][j] = 0;
				return 0;
			}
		}
		arr[i][j] = 0;
		if (j > m)
			arr[i][j] = dfs(i + 1, j) * (j - m);
		if (j < n)
			arr[i][j] += dfs(i + 1, j + 1) * (n - j);
		if (arr[i][j] >= mod)
			arr[i][j] %= mod;

		return arr[i][j];
	}

	public static void main(String[] args) {
		String next = scanner.nextLine();
		String[] split = next.split(" ");

		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);


		for (int i = 0; i <= p; i++)
			for (int j = 0; j <= n; j++)
				arr[i][j] = -1;
		System.out.println(dfs(0, 0));

	}
}
