package Toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SamaArr2 {
	public static void main(String[] args) {
		// 输入
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		ArrayList<Integer> arr1 = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			arr1.add(scan.nextInt());
		}
		int n = scan.nextInt();
		ArrayList<Integer> arr2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr2.add(scan.nextInt());
		}
		// compare
		arr2.retainAll(arr1);
		// arr2.forEach(x -> System.out.print(x + " "));

		for (int i = 0; i < arr2.size(); i++) {
			if (i != arr2.size() - 1) {
				System.out.print(arr2.get(i) + " ");
			} else {
				System.out.print(arr2.get(i));
			}
		}

	}
}
