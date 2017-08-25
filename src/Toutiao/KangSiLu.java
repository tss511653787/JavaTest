package Toutiao;

import java.util.Arrays;
import java.util.Scanner;

public class KangSiLu {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = cin.nextInt();
			}
			Arrays.sort(arr);
			int[] result = new int[n];
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = n - 1; j >= i; j--) {
					sum += arr[j];
				}
				sum *= arr[i];
				result[i] = sum;
			}
			int max = 0;
			max = result[0];
			for (int i = 1; i < n; i++) {
				if (result[i] > max)
					max = result[i];
			}
			// for (Integer i : result)
			// System.out.print(i + " ");
			System.out.println("\n" + max);
		}
		cin.close();
	}
}