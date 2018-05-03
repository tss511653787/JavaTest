/**
 * 
 */
package HuaWeiTest;

import java.util.Collections;

/**
 * @author Administrator
 *
 */
public class RobotInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(movingCount(3, 3, 3));
	}

	/*
	 * 
	 * 地上有一个m行和n列的方格。 一个机器人从坐标0,0的格子开始移动， 每一次只能向左，右，上，下四个方向移动一格
	 * ，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37）， 因为3+5+3+7 =
	 * 18。但是，它不能进入方格（35,38）， 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
	 */
	public static int movingCount(int threshold, int rows, int cols) {
		int[][] intMatrix = new int[rows][cols];
		int count = 1;
		int sum = runInMatrix(threshold, intMatrix, 0, 0);
		return sum;
	}

	public static int runInMatrix(int threshold, int[][] intMatrix, int i, int j) {
		// TODO Auto-generated method stub
		int matrixRow = intMatrix.length - 1;
		int matrixCol = intMatrix[0].length - 1;
		if (i > matrixRow || i < 0 || j > matrixCol || j < 0
				|| !sum(i, j, threshold) || intMatrix[i][j] == 1) {
			return 0;
		} else {
			intMatrix[i][j] = 1;
			return 1 + runInMatrix(threshold, intMatrix, i, j + 1)
					+ runInMatrix(threshold, intMatrix, i + 1, j)
					+ runInMatrix(threshold, intMatrix, i - 1, j)
					+ runInMatrix(threshold, intMatrix, i, j - 1);
		}
	}

	public static boolean sum(int i, int j, int threshold) {
		// TODO Auto-generated method stub
		String numStr = i + "" + j;
		int[] arrC = new int[numStr.length()];
		for (int k = 0; k < numStr.length(); k++) {
			arrC[k] = Integer.parseInt(String.valueOf(numStr.charAt(k)));
		}
		int sum = 0;
		for (int m : arrC) {
			sum += m;
		}
		if (sum > threshold) {
			return false;
		} else {
			return true;
		}
	}
}
