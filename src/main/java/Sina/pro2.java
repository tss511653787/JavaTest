package Sina;

import java.util.Scanner;

public class pro2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int x = sc.nextInt();
		long[] cell = new long[n];
		long msc = sc.nextInt();
		cell[0] = msc;
		for (int i = 1; i < n; i++) {
			cell[i] = sc.nextInt();
			msc = msc < cell[i] ? msc : cell[i];
		}
		sc.close();
		long sum = 0;
		long num = msc - 1;
		if (num > 0) {
			for (int i = 0; i < n; i++) {
				sum += num;
				cell[i] -= num;
			}
		}
		x = (x - 1) % n;
		while (cell[x] > 0) {
			cell[x]--;
			sum++;
			x = (x - 1 + n) % n;
		}
		cell[x] = sum;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(String.valueOf(cell[i]));
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

}
