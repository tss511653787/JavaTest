package ZTE;

import java.util.Scanner;

public class BulbMin {
	/*
	 * 求灯泡的最小距离
	 */
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		minLength();
	}

	public static void minLength() {
		// TODO Auto-generated method stub
		// System.out.println("输入灯泡初始状态");
		String[] in1 = scanner.nextLine().split("\\s+");
		// System.out.println("输入灯泡距离门口位置");
		String[] in2 = scanner.nextLine().split("\\s+");
		int len = in1.length;
		int[] states = new int[len];
		int[] distance = new int[len];
		// inital
		for (int i = 0; i < len; i++) {
			states[i] = Integer.parseInt(in1[i]);
			distance[i] = Integer.parseInt(in2[i]);
		}
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int dis = 0;
			if (states[i] == 0) {
				if (i == 0) {
					// 在最左情况
					int j = i + 1;
					// 找到最近亮灯位置
					while (states[j] == 0) {
						if (j + 1 <= len - 1)
							j++;
						else
							break;
					}
					dis = distance[j] - distance[i];
					ans += dis;
					// 点亮之间所有灯
					for (int k = i; k < j; k++) {
						if (states[k] == 0) {
							states[k] = 1;
						}
					}
				} else if (i == len - 1) {
					// 在最右面情况
					int j = i - 1;
					while (states[j] == 0) {
						if (j - 1 >= 0)
							j--;
						else
							break;
					}
					dis = distance[i] - distance[j];
					ans += dis;
					// 点亮之间所有灯
					for (int k = i; k > j; k--) {
						if (states[k] == 0) {
							states[k] = 1;
						}
					}
				} else {
					// 非两端情况
					// 向左
					int j = i - 1;
					// 向右
					int p = i + 1;
					while (states[j] == 0) {
						if (j - 1 >= 0)
							j--;
						else {
							break;
						}
					}
					while (states[p] == 0) {
						if (p + 1 <= len - 1)
							p++;
						else {
							break;
						}
					}
					// 向左点亮
					if ((states[p] == 0)
							|| (distance[i] - distance[j]) < (distance[p] - distance[i])) {
						dis = distance[i] - distance[j];
						ans += dis;
						// 点亮之间所有灯
						for (int k = i; k > j; k--) {
							if (states[k] == 0) {
								states[k] = 1;
							}
						}
					}
					// 向右
					else {
						dis = distance[p] - distance[i];
						ans += dis;
						// 点亮之间所有灯
						for (int k = i; k < p; k++) {
							if (states[k] == 0) {
								states[k] = 1;
							}
						}
					}
				}
			}
		}
		System.out.print(ans);
	}
}
