package HuaWeiTest;

import java.util.Scanner;
import java.util.Stack;

public class LittleBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please Input Matrix's row and column");
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int) (Math.random() * 100);
			}
		}
		System.out.println("=========The Matrix is=============");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%-4d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out
				.println("Please Input the current position of the ball, row<"
						+ matrix.length + ", column<" + matrix[0].length);
		while (scanner.hasNext()) {
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			System.out.println("The ball can roll out of the boundary? "
					+ isGun(matrix, row, column));
			System.out
					.println("Test again:Please Input the current position of the ball, row<"
							+ matrix.length + " column< " + matrix[0].length);
		}
	}

	public static boolean isGun(int[][] matrix, int row, int column) {
		if (row == 0 || row == matrix.length || column == 0
				|| column == matrix[0].length)
			return true;
		Stack<Node> stack = new Stack<>();
		Node node1 = new Node(row, column, matrix[row][column]);
		stack.push(node1);
		while (!stack.isEmpty()) {
			Node tem = stack.pop();
			if (tem.row + 1 < matrix.length) {
				if (tem.val >= matrix[tem.row + 1][column]) {
					if (tem.row + 1 == matrix.length)
						return true;
					else
						stack.push(new Node(tem.row + 1, column,
								matrix[tem.row + 1][column]));
				}
			}
			if (tem.row - 1 >= 0) {
				if (tem.val >= matrix[tem.row + 1][column]) {
					if (tem.row - 1 == 0)
						return true;
					else
						stack.push(new Node(tem.row - 1, column,
								matrix[tem.row - 1][column]));
				}
			}
			if (tem.colunm + 1 < matrix.length) {
				if (tem.val >= matrix[row][tem.colunm + 1]) {
					if (tem.colunm + 1 == matrix[0].length)
						return true;
					else
						stack.push(new Node(row, tem.colunm + 1,
								matrix[row][tem.colunm + 1]));
				}
			}
			if (tem.colunm - 1 >= 0) {
				if (tem.val >= matrix[row][tem.colunm - 1]) {
					if (tem.colunm - 1 == 0)
						return true;
					else
						stack.push(new Node(row, tem.colunm - 1,
								matrix[row][tem.colunm - 1]));
				}
			}
		}
		return false;
	}

}

class Node {
	public int row;
	public int colunm;
	public int val;

	public Node(int row, int colunm, int val) {
		this.row = row;
		this.colunm = colunm;
		this.val = val;
	}
}
