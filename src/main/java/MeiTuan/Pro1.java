package MeiTuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pro1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int num = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[num];
		int numbers_sum = 0;
		for (int i = 0; i < num; i++) {
			numbers[i] = scanner.nextInt();
			numbers_sum += numbers[i];
		}
		int chu = scanner.nextInt();
		// sum

		int k = numbers_sum / chu;
		// <k,v> k:当前位置的总和 v当前位置
		Map<Integer, Integer> map = new HashMap<>();
		// 放置一个初始值
		map.put(0, -1);
		int sum = 0;
		int len = 0;
		for (int i = 0; i < num; i++) {
			sum += numbers[i];
			// put in map
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			for (int q = 1; q <= k; q++) {
				int target = num * q;
				if (map.containsKey(sum - target)) {
					len = Math.max(len, i - map.get(sum - target));
				}
			}
		}
		System.out.print(len);
	}
}
