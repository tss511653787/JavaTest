package QuNa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class dfs {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] line1 = scanner.nextLine().split("\\s+");
		int num = Integer.parseInt(line1[0]);
		int k = Integer.parseInt(line1[1]);
		int[] array = new int[num];
		String[] line2 = scanner.nextLine().split("\\s+");
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(line2[i]);
		}
		// opt
		int[] b = new int[num];
		List<Integer> ans = new ArrayList<Integer>();
		if (DFS(0, num, k, 0, array, b)) {
			System.out.println("YES");
			for (int j = 0; j < num; j++) {
				if (b[j] == 1) {
					ans.add(array[j]);
				}
			}
			Collections.sort(ans);
			for (int m = 0; m < ans.size(); m++) {
				if (m == ans.size() - 1) {
					System.out.print(ans.get(m));
				} else {
					System.out.print(ans.get(m) + " ");
				}
			}
		} else {
			System.out.print("NO");
		}
	}

	public static boolean DFS(int i, int n, int k, int sum, int[] a, int[] b) {
		if (i == n) {
			return sum == k;
		}
		b[i] = 0;
		if (DFS(i + 1, n, k, sum, a, b))
			return true;
		b[i] = 1;
		if (DFS(i + 1, n, k, sum + a[i], a, b)) {
			return true;
		}
		return false;
	}
}
