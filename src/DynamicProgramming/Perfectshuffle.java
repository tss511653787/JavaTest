package DynamicProgramming;

import java.util.Arrays;

public class Perfectshuffle {
	public static void main(String[] args) {
		int num = 10;
		int[] arr2 = new int[num];
		for (int i = 0; i < num; i++) {
			arr2[i] = (int) (Math.random() * 100);
		}
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Arrays.parallelSort(arr);
		out(arr);
		System.out.println();
		ChangeLocation(arr);
		System.out.println();
		cycleChange(arr, 0, arr.length / 2);
		System.out.println();

	}

	public static void out(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	/*
	 * 位置置换算法 空间复杂度O(N) 需要一个额外数组 到原来位置的(2i)%(2*n+1) n=len/2 且位置从1开始
	 */
	public static void ChangeLocation(int[] arr) {
		int len = arr.length;
		int n = arr.length / 2;
		int[] copy = new int[len];
		// 移动带新数组中
		for (int i = 0; i < len; i++) {
			copy[2 * (i + 1) % (2 * n + 1) - 1] = arr[i];
		}
		out(copy);
	}

	/*
	 * 走圈算法 解决空间复杂度
	 */
	public static void cycleChange(int[] arr, int start, int n) {
		int end = start;
		int last = -1;
		int temp1 = arr[start];
		int temp2;
		do {
			last = 2 * (start + 1) % (2 * n + 1) - 1;
			temp2 = arr[last];
			arr[last] = temp1;
			temp1 = temp2;
			start = last;
		} while (start != end);
		out(arr);
	}

	/*
	 * 完美洗牌算法
	 */
	public static void Perfectshufle(int[] arr) {
		int len = arr.length;
		int mm = len;
		while (mm % 2 != 0) {
			mm--;
		}
		int dm = Panduan(mm + 1) - 1;
		// 数组中个数小于等于3个
		if (dm == 0) {
			if (len != 0) {
				int temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			} else {
				return;
			}
		} else {
		}
	}

	/*
	 * 找一个小于n的3的最小幂次数
	 */
	public static int Panduan(int n) {
		int temp = 3;
		int ans = 0;
		while (temp < n) {
			ans = temp;
			temp = temp * 3;
		}
		return ans;
	}

}
