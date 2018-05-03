package Toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuJian {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		quJian();
	}

	public static void quJian() {
		int num = Integer.parseInt(scanner.nextLine());
		String[] in = scanner.nextLine().split("\\s+");
		int[] numbers = new int[num];
		for (int i = 0; i < num; i++) {
			numbers[i] = Integer.parseInt(in[i]);
		}
		List<Integer> res = new ArrayList<>();
		for (int m = 1; m <= num; m++) {
			for (int i = 0; i <= num - m; i++) {
				List<Integer> list = new ArrayList<Integer>();
				for (int k = i; k < i + m; k++) {
					list.add(numbers[k]);
				}
				int sum = JiSuan(list);
				res.add(sum);
			}
		}
		System.out.print(Collections.max(res));
	}

	public static int JiSuan(List<Integer> list) {
		int min = Collections.min(list);
		int sum = 0;
		for (Integer n : list) {
			sum += n;
		}
		return sum * min;
	}
	/*
	 * Kangs思路
	 */
	
}
