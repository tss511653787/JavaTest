package MeiTaun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InsertHui {
	static Set<String> outMaxLenSet = new HashSet<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		fuc1();
	}

	public static void fuc1() {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(scanner.nextLine());
		String[] numbers = scanner.nextLine().split("\\s+");
		List<String> list = new ArrayList<String>();
		for (String n : numbers) {
			list.add(n);
		}
		Collections.reverse(list);
		String[] reverse = new String[num];
		for (int j = 0; j < num; j++) {
			reverse[j] = list.get(j);
		}
		int[][] maxLen = findMaxLen(numbers, reverse);
		System.out.println(maxLen[num][num]);
		System.out.println();
		outPutMaxLen(maxLen, numbers, reverse, numbers.length, reverse.length,
				"");
		outMaxLenSet.forEach(res -> System.out.println(res));
		long sum = Sum(numbers);
		long max = findmax(outMaxLenSet);
		System.out.println(sum + " " + max);
		System.out.println(sum + (sum - max));

	}

	private static long findmax(Set<String> outMaxLenSet2) {
		// TODO Auto-generated method stub
		long res = 0;
		for (String line : outMaxLenSet2) {
			String[] in = line.split("\\,");
			long count = 0;
			for (int i = 0; i < in.length; i++) {
				count += Long.parseLong(in[i]);
			}
			res = res > count ? res : count;
		}
		return res;
	}

	public static long Sum(String[] numbers) {
		// TODO Auto-generated method stub
		long ans = 0;
		for (String n : numbers) {
			ans += Long.parseLong(n);
		}
		return ans;
	}

	public static int[][] findMaxLen(String[] numbers, String[] reverse) {
		// TODO Auto-generated method stub
		int lenA = numbers.length;
		int lenB = reverse.length;
		int[][] maxLen = new int[lenA + 1][lenB + 1];
		// initail
		for (int i = 0; i < lenA + 1; i++) {
			maxLen[i][0] = 0;
		}
		for (int j = 0; j < lenB + 1; j++) {
			maxLen[0][j] = 0;
		}
		for (int i = 1; i < lenA + 1; i++) {
			for (int j = 1; j < lenB + 1; j++) {
				if (numbers[i - 1].equals(reverse[j - 1])) {
					maxLen[i][j] = maxLen[i - 1][j - 1] + 1;
				} else {
					maxLen[i][j] = Max(maxLen[i - 1][j], maxLen[i][j - 1]);
				}
			}
		}
		return maxLen;
	}

	public static int Max(int i, int j) {
		// TODO Auto-generated method stub
		return i > j ? i : j;
	}

	public static void outPutMaxLen(int[][] maxLen, String[] arrA,
			String[] arrB, int len1, int len2, String res) {
		while (len1 > 0 && len2 > 0) {
			// 当前回溯的字符相等的情况 则向斜上方回溯
			if (arrA[len1 - 1].equals(arrB[len2 - 1])) {
				res += arrA[len1 - 1] + ",";
				len1--;
				len2--;
			} else {
				// 不相等情况
				if (maxLen[len1 - 1][len2] > maxLen[len1][len2 - 1]) {
					len1--;
				} else if (maxLen[len1 - 1][len2] < maxLen[len1][len2 - 1]) {
					len2--;
				} else {
					// 旁边两个状态都相等 说明有多个最长公共子序列 则都要回溯
					outPutMaxLen(maxLen, arrA, arrB, len1 - 1, len2, res);
					outPutMaxLen(maxLen, arrA, arrB, len1, len2 - 1, res);
					return;
				}
			}
		}
		// outMaxLenSet.add(new StringBuilder(res).reverse().toString());
		outMaxLenSet.add(res);
	}

}
