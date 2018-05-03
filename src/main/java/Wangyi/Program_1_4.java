package Wangyi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 网易内推笔试前4题
 * */
public class Program_1_4 {
	public static Scanner scanner = new Scanner(System.in);

	// test
	public static void main(String[] args) {
		findMaxSubInArray();
	}

	/*
	 * 彩色砖块 ??一种颜色 1种 2种颜色就2种 大于2种颜色就0种？
	 */
	public static void ZhuanKuai() {
		String in = scanner.nextLine();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < in.length(); i++) {
			set.add(in.charAt(i));
		}
		if (set.size() == 1) {
			System.out.print(1);
		} else if (set.size() == 2) {
			System.out.print(2);
		} else {
			System.out.print(0);
		}
	}

	/*
	 * 判断数组是否是等差数列
	 */
	public static void DengChaArray() {
		int n = Integer.parseInt(scanner.nextLine());
		String[] in = scanner.nextLine().split("\\s+");
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(in[i]);
		}
		int sum = sum(array);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		int bigmin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (array[i] < bigmin) {
				if (array[i] != min) {
					bigmin = array[i];
				}
			}
		}
		if (bigmin == Integer.MAX_VALUE) {
			// d=0情况
			bigmin = min;
		}
		int d = bigmin - min;
		if (d == 0) {
			System.out.print("Possible");
			return;
		}
		// 首项
		int a = min;
		int left = (sum - n * a) / d;
		int right = n * (n - 1) / 2;
		if (left == right) {
			System.out.print("Possible");
		} else {
			System.out.print("Impossible");
		}
	}

	public static int sum(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	/*
	 * 01交错串 例如: "1","10101","0101010"都是交错01串。
	 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。 小易需要你帮帮忙求出最长的这样的子串的长度是多少
	 */
	public static void findMaxSubInArray() {
		// 正常编列求最大长度就可以
		String in = scanner.nextLine();
		char c = in.charAt(0);
		int max = 0;
		int len = 1;
		for (int i = 1; i < in.length(); i++) {
			if (in.charAt(i) != c) {
				// 不同
				len++;
			} else {
				// 相同
				len = 1;
			}
			c = in.charAt(i);
			max = len > max ? len : max;
		}
		System.out.print(max);
	}

	/*
	 * 扩展：求数组子串中 对小加到target的子串最长的长度
	 */
	public static void SubArrSum() {
		// initial
		int target = Integer.parseInt(scanner.nextLine());
		String[] in = scanner.nextLine().split("\\s+");
		int[] array = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			array[i] = Integer.parseInt(in[i]);
		}

		// <k,v> k:当前位置的总和 v当前位置
		Map<Integer, Integer> map = new HashMap<>();
		// 放置一个初始值
		map.put(0, -1);
		int sum = 0;
		int len = 0;
		for (int i = 0; i < in.length; i++) {
			sum += array[i];
			// put in map
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum - target)) {
				len = Math.max(len, i - map.get(sum - target));
			}
		}
		System.out.print(len);
	}

	/*
	 * 求数列子序列和最大值 (动态规划)O(n)
	 */
	public static void findArrMaxSum() {
		String[] in = scanner.nextLine().split("\\s+");
		int len = in.length;
		int[] arr = new int[len + 1];
		for (int i = 1; i < len; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		for (int i = 1; i <= len; i++) {
			if (arr[i - 1] > 0) {
				arr[i] = arr[i - 1] + arr[i];
			} else {
				arr[i] = arr[i];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int m : arr) {
			max = m > max ? m : max;
		}
		System.out.print(max);
	}

	/*
	 * 暴力法优化 O(n2)
	 */
	public static void findArrMaxSum2() {
		String[] in = scanner.nextLine().split("\\s+");
		int len = in.length;
		int[] arr = new int[len + 1];
		for (int i = 1; i < len; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		// sum数组存放前n项的和
		// 首位值为前0项和为0
		int[] sum = new int[len + 1];
		for (int i = 1; i <= len; i++) {
			if (i == 1) {
				sum[i] = arr[i - 1];
			} else {
				sum[i] = sum[i - 1] + arr[i - 1];
			}
		}
		int max = Integer.MIN_VALUE;
		// 再次暴求解
		for (int i = 1; i <= len; i++) {
			for (int j = i; j <= len; j++) {
				// 求以i开头以j结尾的子序列数子之和
				int sumIJ = sum[j] - sum[i - 1];
				max = sumIJ > max ? sumIJ : max;
			}
		}
		System.out.print(max);
	}
}
