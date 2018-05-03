package HuaWeiTest;

import java.util.ArrayList;
import java.util.Scanner;

public class WangyiBiShi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Method1();
		// System.out.println(pow3(3, 4));
		Method2();

	}

	public static void Method1() {
		// 魔力手环
		Scanner scan = new Scanner(System.in);
		String[] line1 = scan.nextLine().split(" ");
		String[] line2 = scan.nextLine().split(" ");
		int num = Integer.valueOf(line1[0]);
		int cishu = Integer.valueOf(line1[1]);
		int[] intArr = new int[num];
		int i = 0;
		for (String str : line2) {
			intArr[i++] = Integer.valueOf(str);
		}

		while (cishu != 0) {

			int first1 = intArr[0];
			for (int j = 0; j < intArr.length; j++) {
				if (j == intArr.length - 1) {
					intArr[j] = intArr[j] + first1;
					if (intArr[j] >= 100) {
						intArr[j] = (intArr[j] % 100);
					}
				} else {
					intArr[j] = intArr[j] + intArr[j + 1];
					if (intArr[j] >= 100) {
						intArr[j] = (intArr[j] % 100);
					}
				}
			}
			cishu--;
		}
		// 输出
		for (int m = 0; m < intArr.length; m++) {
			if (m == intArr.length - 1) {
				System.out.print(intArr[m]);
			} else {
				System.out.print(intArr[m] + " ");
			}
		}
	}

	// 使用矩阵快速幂思路
	public static int pow3(int a, int b) {
		int ans = 1;
		int base = a;
		while (b != 0) {
			if (b % 2 != 0) {
				// b为奇数的情况下
				ans = ans * base;
			}
			base = base * base;
			b = b / 2;
		}
		return ans;
	}

	public static int[][] NormalCal(int[][] a, int[][] b) {
		Integer lena1 = a.length;// 得到a的行数
		Integer lena2 = a[0].length;// 得到a的列数
		Integer lenb1 = b.length;// 这个值应该和a的列数一样
		Integer lenb2 = b[0].length;// 得到b的列数
		int[][] c = new int[a.length][b[0].length];// 结果矩阵
		for (Integer i = 0; i < lena1; i++) {
			for (Integer j = 0; j < lenb2; j++) {
				int sum = 0;
				for (Integer k = 0; k < lena2; k++) {
					sum += a[i][k] * b[k][j];
				}
				if (sum >= 100) {
					sum = sum % 100;
				}
				c[i][j] = sum;
			}
		}
		return c;
	}

	// 矩阵快速幂次算法
	public static int[][] powMatrix(int[][] a, int b) {
		int[][] ans = Ematrix(a.length);
		int[][] base = a;
		while (b != 0) {
			if (b % 2 == 1) {
				// 奇数
				ans = NormalCal(ans, base);
			}
			base = NormalCal(base, base);
			b = b / 2;
		}
		return ans;
	}

	public static int[][] Ematrix(int len) {
		int[][] answer = new int[len][len];
		for (int i = 0; i < len; i++) {
			answer[i][i] = 1;
		}
		return answer;
	}

	public static void Method2() {
		// 魔力手环
		Scanner in = new Scanner(System.in);
		String[] line1 = in.nextLine().split(" ");
		String[] line2 = in.nextLine().split(" ");
		int len = Integer.valueOf(line1[0]);
		int cishu = Integer.valueOf(line1[1]);
		// 构建运算矩阵
		int[][] col = new int[len][len];
		for (int i = 0; i < len; i++) {
			// i是列数控制
			if (i == len - 1) {
				col[i][i] = 1;
				col[0][i] = 1;

			} else {
				col[i][i] = 1;
				col[i + 1][i] = 1;
			}
		}
		// 将输出转化成矩阵
		int[][] intArr = new int[1][len];
		int i = 0;
		for (String str : line2) {
			intArr[0][i++] = Integer.valueOf(str);
		}
		// 使用快速幂方法
		int[][] answer = new int[1][len];
		answer = NormalCal(intArr, powMatrix(col, cishu));
		// 输出结果
		for (int k = 0; k < len; k++) {
			if (k == len - 1) {
				System.out.print(answer[0][k]);
			} else {
				System.out.print(answer[0][k] + " ");
			}
		}

	}
}
