package DynamicProgramming;

import java.util.Scanner;

/*
 * 输入格式：
 5      //表示三角形的行数    接下来输入三角形
 7
 3   8
 8   1   0
 2   7   4   4
 4   5   2   6   5
 * 路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。 三角形的行数大于1小于等于100，数字为 0 - 99
 * */
public class SanJiaoXing {
	public static void main(String[] args) {
		badMethod();
	}

	/*
	 * 方法1 常规的递归方法
	 */
	public static void badMethod() {
		Scanner scanner = new Scanner(System.in);
		int len = Integer.parseInt(scanner.nextLine());
		// 0
		int[][] matrix = new int[len][len];
		// input
		for (int i = 0; i < len; i++) {
			String[] in = scanner.nextLine().split("\\ ");
			for (int j = 0; j < i + 1; j++) {
				matrix[i][j] = Integer.parseInt(in[j]);
			}
		}
		// maxDen(i,j)代表位于(i,j)处
		int maxres = maxDen(0, 0, len, matrix);
		System.out.println(maxres);
		// good method
		int[][] maxDen = new int[len][len];
		// 初始化
		inital(maxDen, len);
		int maxres2 = maxDen2(0, 0, len, matrix, maxDen);
		System.out.println(maxres2);
		// 动态规划程序
		int maxres3 = DynamicMaxDen(matrix, len);
		System.out.println(maxres3);
		// 改进空间
		int maxres4 = shortDynamicMaxDen(matrix, len);
		System.out.println(maxres4);
	}

	public static void inital(int[][] maxDen, int len) {
		// TODO Auto-generated method stub
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				maxDen[i][j] = -1;
			}
	}

	public static int maxDen(int i, int j, int len, int[][] matrix) {
		// TODO Auto-generated method stub
		if (i == len - 1) {
			// 到达最后一行
			return matrix[i][j];
		} else {
			int left = maxDen(i + 1, j, len, matrix);
			int right = maxDen(i + 1, j + 1, len, matrix);
			int max = left > right ? left : right;
			return max + matrix[i][j];
		}
	}

	// 将这个方法改写成一个可记忆型的递推 用一个maxDen矩阵来保存结果
	public static int maxDen2(int i, int j, int len, int[][] matrix,
			int[][] maxDen) {
		// TODO Auto-generated method stub
		if (maxDen[i][j] != -1) {
			return maxDen[i][j];
		}
		if (i == len - 1) {
			// 到达最后一行
			return matrix[i][j];
		} else {
			int left = maxDen(i + 1, j, len, matrix);
			int right = maxDen(i + 1, j + 1, len, matrix);
			int max = left > right ? left : right;
			maxDen[i][j] = max + matrix[i][j];
			return maxDen[i][j];
		}
	}

	/*
	 * 使用初级动态规划解决问题
	 */
	public static int DynamicMaxDen(int[][] matrix, int len) {
		// copy一下这个矩阵
		int[][] copy = new int[len][len];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < i + 1; j++)
				copy[i][j] = matrix[i][j];
		// 由下向上推倒
		for (int m = len - 1 - 1; m >= 0; m--) {
			for (int k = 0; k <= m; k++) {
				// 从倒数第二行开始
				int left = copy[m + 1][k];
				int right = copy[m + 1][k + 1];
				int max = left > right ? left : right;
				copy[m][k] += max;
			}
		}
		return copy[0][0];
	}

	/*
	 * 改进 使用一维数存放结果
	 */
	public static int shortDynamicMaxDen(int[][] matrix, int len) {
		int[] copy = new int[len];
		for (int i = 0; i < len; i++) {
			copy[i] = matrix[len - 1][i];
		}
		// 由下向上推倒
		for (int m = len - 1; m >= 0; m--) {
			for (int k = 0; k <= m; k++) {
				if (m == len - 1) {
					// do nothing
				} else {
					// 不是最后一行
					int left = copy[k];
					int right = copy[k + 1];
					int max = left > right ? left : right;
					copy[k] = max + matrix[m][k];
				}
			}
		}
		return copy[0];
	}

}
