package HuaWeiTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class NiuKe {

	public static void reOrderArra(int[] array) {
		// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
		// 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
		// 位置改变了
		// 和快排思想非常相似
		int len = array.length;
		int findJ = len - 1;
		int findO = 0;
		int temp;
		while (findO < findJ) {
			while ((findO < findJ) && (isOushu(array[findJ]))) {
				findJ--;
			}
			while ((findO < findJ) && (isJishu(array[findO]))) {
				findO++;
			}
			temp = array[findO];
			array[findO] = array[findJ];
			array[findJ] = temp;
			findO++;
			findJ--;
		}

	}

	public static boolean isOushu(int num) {
		if (num % 2 == 0)
			return true;
		else {
			return false;
		}
	}

	public static boolean isJishu(int num) {
		if (num % 2 == 0)
			return false;
		else {
			return true;
		}
	}

	public static void reOrderArray(int[] array) {
		// 保证位置不会改变
		int len = array.length;
		int i = 0;
		int j;
		int temp;
		int m;
		while (i < len - 1) {
			// i找到第一个偶数
			while ((i < len - 1) && isJishu(array[i])) {
				i++;
			}
			j = i + 1;
			// j找到第一个基数
			while ((j <= len - 1) && isOushu(array[j])) {
				j++;
			}
			if (j == len)
				break;
			temp = array[j];
			m = j;
			while (m > i) {
				// 后移
				array[m] = array[m - 1];
				m--;
			}
			array[i] = temp;
		}

	}

	public static void PrintArr(int[] arr) {
		int[] out = arr;
		for (int i : out) {
			System.out.print(i + " ");
		}
	}

	// 输入一个矩阵 顺时针输出
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		// (start,start) (endX,endY)
		int row = matrix.length;
		int col = matrix[0].length;
		int start = 0;
		List<Integer> outList = new ArrayList<Integer>();
		// 进入下一圈的条件
		while (col > start * 2 && row > start * 2) {
			// 分4种情况打印矩阵
			int endX = row - start - 1;
			int endY = col - start - 1;
			// 从左到右
			for (int i = start; i <= endY; i++) {
				outList.add(matrix[start][i]);
			}
			// 从上到下
			if (start <= endY) {
				for (int i = start + 1; i <= endX; i++) {
					outList.add(matrix[i][endY]);
				}
			}
			// 从右到左
			if (start < endX && start < endY) {
				for (int i = endY - 1; i >= start; i--) {
					outList.add(matrix[endX][i]);
				}
			}
			// 从下到上
			if (start < endX && start < endY) {
				for (int i = endX - 1; i > start; i--) {
					outList.add(matrix[i][start]);
				}
			}
			start++;// 向内部跳一行
		}
		return (ArrayList<Integer>) outList;

	}

	// 输入两个整数序列，第一个序列表示栈的压入顺序，
	// 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等
	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		// 定义一个辅助栈来模拟pushA的压栈和弹栈
		if (popA.length == 0 || pushA.length == 0)
			return false;
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0, j = 0; i < pushA.length; i++) {
			stk.push(pushA[i]);
			while ((!stk.isEmpty()) && stk.peek() == popA[j]) {
				stk.pop();
				j++;
			}
		}
		if (!stk.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
	// 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
	// 则打印出这三个数字能排成的最小数字为321323。
	public static String PrintMinNumber(int[] numbers) {
		// 思路选择排序思路或任何排序思路
		// 比较方法比较特殊 组合比较然后返回值
		// 大神代码
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int in : numbers) {
			list.add(in);
		}
		// sort底层是用合并排序实现
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				// 这个写法有点6
				String str1 = o1 + "" + o2;
				String str2 = o2 + "" + o1;
				return str1.compareTo(str2);
			}

		});
		String res = "";
		for (Integer out : list) {
			res += out;
		}
		return res;
	}

	// 手动实现一个选择排序
	public static String PrintMinNumberOnHand(int[] arr) {
		// 升序思路
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (compare(arr[i], arr[j])) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		String res = "";
		for (int i : arr) {
			res += i;
		}
		return res;
	}

	private static boolean compare(int i, int j) {
		// TODO Auto-generated method stub
		String str1 = i + "" + j;
		String str2 = j + "" + i;
		if (Integer.compare(Integer.valueOf(str1), Integer.valueOf(str2)) > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		return VerfySquence(sequence, 0, sequence.length - 1);
	}

	private static boolean VerfySquence(int[] sequence, int start, int end) {
		// TODO Auto-generated method stub
		if (start >= end) {
			return true;
		}
		int i = end;
		while (i > 1 && sequence[i - 1] > sequence[end]) {
			i--;
		}
		for (int j = i - 1; j >= start; j--) {
			if (sequence[j] > sequence[end])
				return false;
		}
		return VerfySquence(sequence, start, i - 1)
				&& (VerfySquence(sequence, i, end - 1));
	}

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 4, 4, 6, 7, 9, 0 };
		// reOrderArray(arr);
		// PrintArr(arr);
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 4, 5, 3, 2, 1 };
		int[] c = { 5, 4, 3, 2, 1 };
		System.out.println(IsPopOrder(a, b));
		int[] arr = { 3, 23, 321 };
		System.out.println(PrintMinNumber(arr));
		System.out.println(PrintMinNumberOnHand(arr));
		System.out.println(VerifySquenceOfBST(c));

	}

}
