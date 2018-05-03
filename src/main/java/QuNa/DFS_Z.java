package QuNa;

import java.util.Scanner;

public class DFS_Z {
	static Scanner scanner = new Scanner(System.in);
	static int p = 0;
	static int array[] = new int[100];

	public static void main(String[] args) {
		String[] in = scanner.nextLine().split("\\s+");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		if (Dfs(0, 0, n, k, arr)) {
			System.out.println("YES");
			for (int i = p - 1; i > 0; i--) {
				System.out.print(array[i] + " ");
			}
			System.out.println(array[0]);
		} else {
			System.out.println("NO");
		}
	}

	static boolean Dfs(int i, int sum, int n, int k, int num[]) {
		if (i == n) {
			if (sum == k) {
				return true;
			} else {
				return false;
			}
		} else if (sum > k) {
			return false;
		}
		if (Dfs(i + 1, sum, n, k, num)) {
			return true;
		}
		if (Dfs(i + 1, num[i] + sum, n, k, num)) {
			array[p++] = num[i];
			return true;
		}
		return false;
	}
}
