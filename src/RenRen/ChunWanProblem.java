package RenRen;

import java.util.Scanner;

public class ChunWanProblem {
	public static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {

			int num = Integer.parseInt(scan.nextLine());
			int[] arr = new int[num];
			String[] str = scan.nextLine().split(" ");
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			if (num != 1) {// 计算第一个划分的值
				int pre = arr[0];
				int last = 0;
				for (int k = 1; k < num; k++) {
					last = last + arr[k];
				}
				// 递归
				caculate(arr, 0, pre, last);
			} else {
				answer = 0;
			}
			System.out.println(answer);
		}
	}

	public static void caculate(int[] arr, int cur, int pre, int last) {
		// TODO Auto-generated method stub
		if (cur == arr.length - 1) {
			return;
		} else {
			if (pre == last) {
				answer++;
			}
			int n = arr[cur + 1];
			caculate(arr, cur + 1, pre + n, last - n);
		}
	}
}
