package test1;

import java.util.Scanner;

public class MatCC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入维度
		int length = 0;
		System.out.print("请输入方阵维度：");
		Scanner in = new Scanner(System.in);
		length = in.nextInt();
	
		// 创建一个二维数组
		Double array[][] = new Double[length][length];
		// Double array[][] = { { 1.0, 0.333 }, { 3.0, 1.0 } };
		// 矩阵的初始化
		for (int i = 0; i < length; i++) {
			int n = i + 1;
			System.out.print("请输入矩阵的第" + n + "行:");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			for (int j = 0; j < length; j++) {
				Double d = Double.valueOf(str.split(" ")[j]).doubleValue();
				array[i][j] = d;
			}

		}
		// 列个数
		int colCount = array[0].length;
		// 行数
		int lineCount = array.length;
		System.out.println("矩阵A输出:");
		print(array);

		// 归一化处理
		Double arrayGY[][] = new Double[lineCount][colCount];
		for (int i = 0; i < lineCount; i++)
			for (int j = 0; j < colCount; j++) {
				// 统计该元素所处列和
				Double colsum = 0.0;
				for (int m = 0; m < lineCount; m++) {
					colsum += array[m][j];
				}
				arrayGY[i][j] = array[i][j] / colsum;
			}
		System.out.println("列向量归一化:");
		print(arrayGY);
		// 每行求和
		Double arrayLineSum[][] = new Double[lineCount][1];
		for (int i = 0; i < lineCount; i++) {
			Double colSum = 0.0;
			for (int m = 0; m < colCount; m++) {
				colSum += arrayGY[i][m];
			}
			arrayLineSum[i][0] = colSum;
		}
		System.out.println("每行求和:");
		print(arrayLineSum);
		// 再一次归一化
		Double arrayNextGY[][] = new Double[lineCount][1];
		for (int i = 0; i < lineCount; i++) {
			Double colSum = 0.0;
			for (int m = 0; m < colCount; m++) {
				colSum += arrayLineSum[m][0];
			}
			arrayNextGY[i][0] = arrayLineSum[i][0] / colSum;
		}
		System.out.println("再次归一化W:");
		print(arrayNextGY);
		// 计算AW
		Double MatAW[][];
		MatAW = NormalCal(array, arrayNextGY);
		System.out.println("AW:");
		print(MatAW);
		// 最大特征值
		int n = lineCount;
		Double lamda = 0.0;
		Double sumLamda = 0.0;
		for (int i = 0; i < n; i++) {
			sumLamda += MatAW[i][0] / arrayNextGY[i][0];
		}
		lamda = sumLamda / n;
		System.out.println("最大特征值lamda=" + lamda);
		// 一致性指标
		Double ci = 0.0;
		ci = (lamda - n) / (n - 1);
		System.out.println("一致性指标CI=" + ci);
		System.out.print("请按任意键退出:");
		Scanner exit = new Scanner(System.in);
		System.exit(0);

	}

	public static void print(Double array[][]) {
		// 列个数
		int ccolCount = array[0].length;
		// 行数
		int llineCount = array.length;
		for (int i = 0; i < llineCount; i++) {
			for (int j = 0; j < ccolCount; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 矩阵乘法常规编写
	public static Double[][] NormalCal(Double[][] a, Double[][] b) {
		Integer lena1 = a.length;// 得到a的行数
		Integer lena2 = a[0].length;// 得到a的列数
		Integer lenb1 = b.length;// 这个值应该和a的列数一样
		Integer lenb2 = b[0].length;// 得到b的列数
		Double[][] c = new Double[a.length][b[0].length];
		for (Integer i = 0; i < lena1; i++) {
			for (Integer j = 0; j < lenb2; j++) {
				Double sum = 0.0;
				for (Integer k = 0; k < lena2; k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return c;
	}
}
