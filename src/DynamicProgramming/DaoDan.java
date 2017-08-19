package DynamicProgramming;

import java.util.Scanner;

/*
 * 动态规划练习
 * */
public class DaoDan {
	public static void main(String[] args) {
		findMaxLenTest();
	}

	public static void findArrTest() {
		Scanner scan = new Scanner(System.in);
		String[] in = scan.nextLine().split("\\ ");
		int[] intarr = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			intarr[i] = Integer.parseInt(in[i]);
		}
		int maxDown = findArr(intarr);
		System.out.println("给定输入的最大上升(含等)序列长度:" + maxDown);
	}

	/*
	 * 求给定数列的最大上升序列 a<=b
	 */
	public static int findArr(int[] in) {
		int len = in.length;
		int[] res = new int[len];
		// 赋初始值
		for (int i = 0; i < len; i++) {
			res[i] = 1;
		}
		int max = 0;
		for (int i = 1; i < len; i++) {
			// for(int j=i-1;j>=0;j--) 效果一样 都是遍历i之前看满足情况
			for (int j = 0; j < i; j++) {
				if (in[j] <= in[i]) {
					if (res[j] + 1 > res[i]) {
						res[i] = res[j] + 1;
					}
					if (res[i] > max) {
						max = res[i];
					}
				}
			}
		}
		return max;
	}

	public static void findMaxLenTest() {
		Scanner scanner = new Scanner(System.in);
		String[] in = scanner.nextLine().split("\\s+");
		char[] arrA = in[0].toCharArray();
		char[] arrB = in[1].toCharArray();
		System.out.println(findMaxLen(arrA, arrB));
		scanner.close();
	}

	/*
	 * 进阶：求A B 两个数组的最长公共子序列 要求：给出两个字符串，求出这样的一个最长的公共子序列的长度： 子序列中的每个字符都能在两个原串中找到，
	 * 而且每个字符的先后顺序和原串中的先后顺序一致 子序列不一定连续
	 */
	public static int findMaxLen(char[] arrA, char[] arrB) {
		int lenA = arrA.length;
		int lenB = arrB.length;
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
				if (arrA[i - 1] == arrB[j - 1]) {
					maxLen[i][j] = maxLen[i - 1][j - 1] + 1;
				} else {
					maxLen[i][j] = Max(maxLen[i - 1][j], maxLen[i][j - 1]);
				}
			}
		}
		return maxLen[lenA][lenB];
	}

	public static int Max(int i, int j) {
		// TODO Auto-generated method stub
		return i > j ? i : j;
	}

}
