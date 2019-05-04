package Huawei_OnNiuKe;

import java.util.Scanner;

public class ShoppingListBagProblem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] in = scan.nextLine().split(" ");
		// m：背包最大价值 n:物品个数
		int m = Integer.parseInt(in[0]);
		int n = Integer.parseInt(in[1]);
		int[] weight = new int[n];
		int[] values = new int[n];
		int[] mainOrSub = new int[n];
		for (int i = 0; i < n; i++) {
			String[] intput = scan.nextLine().split(" ");
			weight[i] = Integer.parseInt(intput[0]);
			values[i] = Integer.parseInt(intput[1]) * weight[i];
			mainOrSub[i] = Integer.parseInt(intput[2]);
		}
		int res = BagMaxValue(m, n, weight, values, mainOrSub);
		System.out.print(res);
	}

	public static int BagMaxValue(int m, int n, int[] weight, int[] values,
			int[] mainOrSub) {
		int[][] matrix = new int[n + 1][m + 1];
		// 初始为0
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// 判断是主件还是辅件
				if (mainOrSub[i - 1] == 0) {
					// 是主件
					if (weight[i - 1] < j) {
						if (matrix[i - 1][j] < matrix[i - 1][j - weight[i - 1]]
								+ values[i - 1]) {
							matrix[i][j] = matrix[i - 1][j - weight[i - 1]]
									+ values[i - 1];
						} else {
							matrix[i][j] = matrix[i - 1][j];
						}
					} else {
						matrix[i][j] = matrix[i - 1][j];
					}
				} else {
					// 不是主件
					if (weight[i - 1] + weight[mainOrSub[i - 1]] < j) {
						if (matrix[i - 1][j] < matrix[i - 1][j - weight[i - 1]]
								+ values[i - 1]) {
							matrix[i][j] = matrix[i - 1][j - weight[i - 1]]
									+ values[i - 1];
						} else {
							matrix[i][j] = matrix[i - 1][j];
						}
					} else {
						matrix[i][j] = matrix[i - 1][j];
					}
				}
			}

		}
		int max = 0;
		for (int k = 1; k < n + 1; k++) {
			for (int q = 1; q < m + 1; q++) {
				if (matrix[k][q] > max) {
					max = matrix[k][q];
				}
			}
		}
		return max;
	}

}
