package MianShiBaoDian;

import java.util.ArrayList;

public class J {
	static int num = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = findprime(100);
		for (int a : n) {
			if (a != 0)
				System.out.print(a + " ");
		}
		System.out.println();
		int[] m = findprimeNomal(100);
		for (int x : m) {
			System.out.print(x + " ");
		}
		System.gc();
		

	}

	// 使用筛选法求100以内 含100的素数
	// 将是2 3 4 5倍数进行标记方法
	public static int[] findprime(int n) {
		int[] num = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		for (int j = 2; j <= 50; j++) {
			int m = 2;
			while (m * j <= 100) {
				// 标记
				num[m * j - 1] = 0;
				m = m + 1;
			}
		}
		return num;
	}

	// 一般遍历的方法找1质数
	public static int[] findprimeNomal(int n) {
		ArrayList<Integer> ansewer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int j = 2;
			for (; j < Math.sqrt(i); j++) {
				if (i % j == 0)
					break;
			}
			// 这个地方必须是大于
			if (j > Math.sqrt(i)) {
				ansewer.add(i);
			}
		}
		int[] arr = new int[ansewer.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ansewer.get(i);
		}
		return arr;
	}
}
