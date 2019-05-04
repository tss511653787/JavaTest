package HuaWeiTest;

import java.util.ArrayList;
import java.util.HashMap;

public class findPathInMatrix {
	/**
	 * (a b c e) (s f c s) (a d e e)
	 */
	/*
	 * 请设计一个函数， 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。 路径可以从矩阵中的任意一个格子开始，
	 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。 如果一条路径经过了矩阵中的某一个格子， 则该路径不能再进入该格子。
	 */
	public static void main(String[] args) {
		String str = "a b c e s f c s a d e e";
		String[] arrS = str.split(" ");
		char[] charArr = new char[arrS.length];
		for (int i = 0; i < arrS.length; i++) {
			charArr[i] = arrS[i].charAt(0);
		}
		String s = "s e e";
		String[] arrS2 = s.split(" ");
		char[] charArr2 = new char[arrS2.length];
		for (int i = 0; i < arrS2.length; i++) {
			charArr2[i] = arrS2[i].charAt(0);
		}
		System.out.println(hasPath(charArr, 3, 4, charArr2));
	}

	// 深度优先遍历思想
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		// (rows,cols)
		char[][] matrixTo = toMatrix(matrix, rows, cols);
		// 标记矩阵
		int[][] flagMatrix = new int[matrixTo.length][matrixTo[0].length];
		char target = str[0];
		if (findTarget(target, matrixTo).size() != 0) {
			// int[] loc = findTarget(target, matrixTo);
			// int i = 0;
			// return runInMatrix(matrixTo, flagMatrix, str, i, loc[0], loc[1])
			ArrayList<int[]> res = findTarget(target, matrixTo);
			int size = res.size();
			boolean[] flag = new boolean[size];
			int j = 0;
			for (int i = 0; i < size; i++) {
				flag[i] = runInMatrix(matrixTo, flagMatrix, str, j,
						res.get(i)[0], res.get(i)[1]);
			}
			for (boolean f : flag) {
				if (f)
					return f;
			}
			return false;
		} else {
			return false;
		}
		// 向四个方向递归查看下一个是否包含

	}

	public static boolean runInMatrix(char[][] matrixTo, int[][] flagMatrix,
			char[] str, int i, int row, int col) {
		// TODO Auto-generated method stub
		int rowlen = matrixTo.length - 1;
		int colklen = matrixTo[0].length - 1;
		if (i == str.length)
			return true;
		if (row < 0 || row > rowlen || col < 0 || col > colklen
				|| flagMatrix[row][col] == 1 || str[i] != matrixTo[row][col])
			return false;

		flagMatrix[row][col] = 1;
		if (runInMatrix(matrixTo, flagMatrix, str, i + 1, row - 1, col)
				|| runInMatrix(matrixTo, flagMatrix, str, i + 1, row, col - 1)
				|| runInMatrix(matrixTo, flagMatrix, str, i + 1, row + 1, col)
				|| runInMatrix(matrixTo, flagMatrix, str, i + 1, row, col + 1)) {
			return true;
		}
		flagMatrix[row][col] = 0;
		return false;
	}

	public static ArrayList<int[]> findTarget(char target, char[][] matrixTo) {
		// TODO Auto-generated method stub
		ArrayList<int[]> answer = new ArrayList<>();
		for (int i = 0; i < matrixTo.length; i++) {
			for (int j = 0; j < matrixTo[0].length; j++) {
				if (matrixTo[i][j] == target) {
					int[] loc = new int[2];
					loc[0] = i;
					loc[1] = j;
					answer.add(loc);
				}
			}
		}
		return answer;
	}

	public static char[][] toMatrix(char[] matrix, int rows, int cols) {
		// TODO Auto-generated method stub
		char[][] answerMatrix = new char[rows][cols];
		int row = 0;
		int col = 0;
		int k = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				answerMatrix[i][j] = matrix[k++];
			}
		}
		return answerMatrix;
	}

}
