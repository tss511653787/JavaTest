package XieCheng;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class pro3 {
	static Scanner scanner = new Scanner(System.in);

	/*
	 * 题目：合并两个数组 求合并以后数组的中位数 尽量减少时间复杂度
	 */
	public static void main(String[] args) {
		badMethod();
		goodmethod();
	}

	private static void goodmethod() {
		// TODO Auto-generated method stub

	}

	public static void badMethod() {
		// input
		int num1 = Integer.parseInt(scanner.nextLine());
		int[] arr1 = new int[num1];
		String[] in1 = scanner.nextLine().split("\\s+");
		for (int i = 0; i < num1; i++) {
			arr1[i] = Integer.parseInt(in1[i]);
		}
		int num2 = Integer.parseInt(scanner.nextLine());
		int[] arr2 = new int[num2];
		String[] in2 = scanner.nextLine().split("\\s+");
		for (int i = 0; i < num2; i++) {
			arr2[i] = Integer.parseInt(in2[i]);
		}
		// process
		Set<Integer> set = new LinkedHashSet<>();
		for (int n : arr1) {
			set.add(n);
		}
		for (int n : arr2) {
			set.add(n);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (Integer a : set) {
			list.add(a);
		}
		Collections.sort(list);
		int len = list.size();
		DecimalFormat df = new DecimalFormat("#.0");
		if (len % 2 == 0) {
			System.out.print(df.format((double) (list.get(len / 2) + list
					.get(len / 2 - 1)) / 2));
		} else {
			System.out.print(list.get(len / 2));
		}
	}

}
