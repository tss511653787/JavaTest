package HuaWeiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class NiuKe4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseSentence(""));
		System.out.println(Sum_Solution(3));
	}

	// 找出所有和为S的连续正数序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		return null;

	}

	/*
	 * 输入一个递增排序的数组和一个数字S， 在数组中查找两个数，是的他们的和正好是S， 如果有多对数字的和等于S，输出两个数的乘积最小的。
	 */
	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<int[]> answerList = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int[] arr = new int[3];
			int a = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int b = array[j];
				if (a + b == sum) {
					arr[0] = a;
					arr[1] = b;
					arr[2] = a * b;
					answerList.add(arr);
				}
			}
			if (answerList.size() != 0) {
				Collections.sort(answerList, new Comparator<int[]>() {
					@Override
					public int compare(int[] arr1, int[] arr2) {
						// TODO Auto-generated method stub
						// 将乘积作为排序标准
						return arr1[2] - arr2[2];
					}
				});
				int[] an = answerList.get(0);
				Integer[] and = new Integer[2];
				and[0] = an[0];
				and[1] = an[1];
				Arrays.sort(and);
				ArrayList<Integer> res = new ArrayList<>(Arrays.asList(and));
				return res;
			}
		}
		return new ArrayList<Integer>();
	}

	/*
	 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
	 */
	public static String LeftRotateString(String str, int n) {
		// 如果单独只是得到字符串结果会很简单
		if (n > str.length())
			return "";
		String subleft = str.substring(0, n);
		String subright = str.substring(n);
		return subright + subleft;
	}

	/*
	 * 翻转这些单词
	 */
	public static String ReverseSentence(String str) {
		// str.trim():去掉字符串首位的空格
		if (str == null || str.trim().equals(""))
			return str;
		String[] in = str.split("\\s");
		// ArrayList<String> list = new ArrayList<>(Arrays.asList(in));
		ArrayList<String> list = new ArrayList<>();
		for (String ss : in) {
			list.add(ss);
		}
		Collections.reverse(list);
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1)
				buf.append(list.get(i));
			else
				buf.append(list.get(i) + " ");
		}
		// list.forEach(c -> buf.append(c));
		return buf.toString();
	}

	// 小朋友们报数
	public int LastRemaining_Solution(int n, int m) {
		// 实质是一个约瑟环问题
		if (m == 0 || n == 0)
			return -1;
		int[] chidren = new int[n];
		for (int i = 0; i < n; i++) {
			chidren[i] = 1;
		}
		ArrayList<Integer> list = new ArrayList<>();
		int len = n;
		int count = -1;
		int i = 0;// 从第0个小盆友开始
		while (n > 0) {
			if (chidren[i] != 0) {
				count++;// 报数
			}
			if ((count == m - 1) && (chidren[i] != 0)) {
				// 出圈
				list.add(i);
				chidren[i] = 0;
				count = -1;
				n--;
			}
			i++;
			if (i == len)
				i = 0;
		}
		return list.get(len - 1);
	}

	// 求1+2+3+...+n 的递归求解
	public static int Sum_Solution(int n) {
		int sum = 0;
		sum = Plus(sum, n);
		return sum;
	}

	private static int Plus(int sum, int n) {
		// TODO Auto-generated method stub
		boolean isend = true;
		sum = sum + n;
		isend = (n > 0) && ((sum = Plus(sum, n - 1)) > 0);
		return sum;
	}
}
