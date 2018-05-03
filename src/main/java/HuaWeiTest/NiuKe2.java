package HuaWeiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NiuKe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		// System.out.println(MoreThanHalfNum_Solution(arr));
		// GetLeastNumbers_Solution(arr, 4)
		// .forEach(x -> System.out.print(x + " "));
		// System.out.println(NumberOf1Between1AndN_Solution(55));
		// System.out.println(GetUglyNumber_Solution(6));
		// FindMaxNumOf1Between1AndN();
		System.out.print(GetUglyNumber_Solution(7));
	}

	// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
	public static int MoreThanHalfNum_Solution(int[] array) {
		// 初步想法是用set做 然后在新建一个数组统计每个元素的个数
		Set<Integer> intSet = new HashSet<Integer>();
		for (Integer num : array) {
			intSet.add(num);
		}
		// int[] countNum = new int[intSet.size()];
		// 对set进行遍历
		for (int num : intSet) {
			int count = findcishu(array, num);
			if (count > array.length / 2)
				return num;
		}
		return 0;
	}

	public static int findcishu(int[] array, int num) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int x : array) {
			if (x == num)
				count++;
		}
		return count;
	}

	// 输入n个整数，找出其中最小的K个数
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		// int数组最好手动转化
		List<Integer> list = new LinkedList<Integer>();
		for (int num : input) {
			list.add(num);
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if (k <= 0 || k > input.length)
			return answer;
		for (int i = 0; i < k; i++) {
			int min = Collections.min(list);
			int index = list.indexOf(min);
			answer.add(min);
			list.remove(index);
		}
		return answer;
	}

	// 连续子向量的最大和
	public static int FindGreatestSumOfSubArray(int[] array) {
		// 大神代码
		int sum = array[0];
		int tempsum = array[0];
		for (int i = 1; i < array.length; i++) {
			tempsum = (tempsum < 0) ? array[i] : tempsum + array[i];
			sum = (tempsum > sum) ? tempsum : sum;
		}
		return sum;
	}

	// 1-n中1出现的次数
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			// System.out.print(i + " ");
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1') {
					count++;
				}
			}
		}
		return count;
	}

	// 上面求1题的一个扩展
	// 求f(13)=6 1-13有6个1 然后现在想求出最大的f(n)=n的n值
	public static void FindMaxNumOf1Between1AndN() {
		long n = 2;
		long res = 1;
		while ((getonly(n) + res) != n) {
			res += getonly(n);
			n++;
		}
		System.out.println(n);
	}

	private static long getonly(long n) {
		// TODO Auto-generated method stub
		// 计算值n中出现1的次数
		String str = String.valueOf(n);
		long count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				count++;
		}
		return count;
	}

	// 二叉树节点路径
	// 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,
			int target) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		ArrayList<TreeNode> treelist = new ArrayList<TreeNode>();
		findPathInTree(root, target, treelist, answer);
		return answer;
	}

	private static void findPathInTree(TreeNode p, int target,
			ArrayList<TreeNode> treelist, ArrayList<ArrayList<Integer>> answer) {
		// TODO Auto-generated method stub
		if (p == null)
			return;
		treelist.add(p);
		if (p.left == null && p.right == null) {
			// p是叶子
			// 判断是否满足之和等于target的条件
			int tempCoun = 0;
			for (TreeNode a : treelist) {
				tempCoun += a.value;
			}
			if (tempCoun == target) {
				ArrayList<Integer> to = new ArrayList<Integer>();
				for (TreeNode b : treelist) {
					to.add(b.value);
				}
				answer.add(to);
			}
			// 回溯
			// treelist.remove(treelist.size() - 1);
		}
		findPathInTree(p.left, target, treelist, answer);
		findPathInTree(p.right, target, treelist, answer);
		// 回溯
		treelist.remove(treelist.size() - 1);
	}

	// 丑数把只包含因子2、3和5的数称作丑数（Ugly Number）。
	public static int GetUglyNumber_Solution(int index) {
		if (index < 7)
			return index;
		int[] k = new int[index];
		k[0] = 1;
		int t2 = 0;
		int t3 = 0;
		int t5 = 0;
		for (int i = 1; i < index; i++) {
			k[i] = findmin(k[t2] * 2, findmin(k[t3] * 3, k[t5] * 5));
			if (k[i] == k[t2] * 2)
				t2++;
			if (k[i] == k[t3] * 3)
				t3++;
			if (k[i] == k[t5] * 5)
				t5++;
		}
		return k[index - 1];
	}

	private static int findmin(int a, int b) {
		// TODO Auto-generated method stub
		return (a < b) ? a : b;
	}
}
