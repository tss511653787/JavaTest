package Toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SameArray {
	public static void main(String[] args) {
		// 输入
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		if (m == 0)
			return;
		int[] arr1 = new int[m];
		for (int i = 0; i < m; i++) {
			arr1[i] = scan.nextInt();
		}
		int n = scan.nextInt();
		if (n == 0)
			return;
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = scan.nextInt();
		}
		// compare

		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr1[j] == arr2[i]) {
					answer.add(arr2[i]);
					break;
				}
			}
		}
		answer.forEach(x->System.out.print(x+" "));
		// out
		// for (int i = 0; i < answer.size(); i++) {
		// if (i != answer.size() - 1) {
		// System.out.print(answer.get(i) + " ");
		// } else {
		// System.out.print(answer.get(i));
		// }
		// }
	}

}
