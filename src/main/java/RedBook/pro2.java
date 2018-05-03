package RedBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pro2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int x = sc.nextInt();
		int[] arr = new int[x];
		for (int i = 0; i < x; i++) {
			arr[i] = sc.nextInt();
		}
		int m = findMaxLength(arr);
		System.out.print(m);

	}

	public static int findMaxLength(int[] nums) {
		int sum = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] == 0 ? -1 : 1;
			if (map.containsKey(sum)) {
				max = max > i - map.get(sum) ? max : i - map.get(sum);
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}

}
