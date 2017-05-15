package RenRen;

import java.util.Scanner;

public class littleB {

	// 对每组测试数据，在单独的行中输出不同撕法的总数，
	// 使得两边纸带中的数值之和相等。将纸带撕成两半时，只能沿方格的边缘撕开。

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
			int answer = 0;
			for (int i = 0; i < num - 1; i++) {
				// 数组前半部分的总和
				int pre = 0;
				int last = 0;
				for (int j = 0; j <= i; j++) {
					pre = pre + arr[j];
				}
				int k = i + 1;
				for (; k < num; k++) {
					last = last + arr[k];
				}
				// if (k > num) {
				// break;
				// }
				if (pre == last) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
