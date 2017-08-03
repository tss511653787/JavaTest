/**
 * 
 */
package Huawei_OnNiuKe;

import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class Bag_Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] in = scan.nextLine().split(" ");
		int m = Integer.parseInt(in[0]);
		int n = Integer.parseInt(in[1]);
		int[] w = new int[m];
		int[] p = new int[m];
		for (int i = 0; i < m; i++) {
			String[] input = scan.nextLine().split(" ");
			w[i] = Integer.parseInt(input[0]);
			p[i] = Integer.parseInt(input[1]);
		}
		MaxBag01(m, n, w, p);
	}

	public static void MaxBag01(int m, int n, int[] w, int[] p) {
		/*
		 * m是物品的个数 n是背包的最大容量 w数组是物品的重量数组 p数组是物品的价值数组 计算背包最大价值maxRes
		 */
		int maxRes;
		int[][] matrix = new int[m + 1][n + 1];
		// 初始化边缘值
		for (int i = 0; i < m + 1; i++) {
			matrix[i][0] = 0;
		}
		for (int i = 0; i < n + 1; i++) {
			matrix[0][i] = 0;
		}
		// 行数控制
		for (int i = 1; i < m + 1; i++) {
			// 列数控制
			for (int j = 1; j < n + 1; j++) {
				// 如果第i件物品的重量小于等于j 可以放入背包，因为i从1开始 所以i-1表示w中的第i个物品
				// 第i个物品放入总容积为j的背包
				if (w[i - 1] <= j) {
					// 放入第i个物体的价值大就放入 否则就不放入
					if (matrix[i - 1][j] < matrix[i - 1][j - w[i - 1]]
							+ p[i - 1]) {
						matrix[i][j] = matrix[i - 1][j - w[i - 1]] + p[i - 1];
					} else {
						matrix[i][j] = matrix[i - 1][j];
					}
				}
				// 第i个物品无法放入总容积为j的背包
				else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		// 输出查看结果
		int max = 0;
		for (int k = 1; k < m + 1; k++) {
			for (int q = 1; q < n + 1; q++) {
				if (matrix[k][q] > max) {
					max = matrix[k][q];
				}
				System.out.print(matrix[k][q] + " ");
			}
			System.out.println();
		}
		// 找到最大值
		System.out.println("The max :" + max);
	}
}
