package HuaWeiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.sun.org.apache.regexp.internal.recompile;

public class NiuKe3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 0, 0 };
		// String str = "google";
		// System.out.println(FirstNotRepeatingChar(str));
		// System.out.println(InversePairs(a));
		// System.out.println(GetNumberOfK(a, 0));

	}

	// 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。
	public static int FirstNotRepeatingChar(String str) {
		int index;
		if (str.length() == 0)
			return -1;
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			int j = 0;
			for (; j < str.length(); j++) {
				if ((str.charAt(j) == str.charAt(i)) && (i != j)) {
					break;
				}
			}
			if (j == str.length()) {
				return i;
			}
		}
		return -1;
	}

	// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
	// 时间复杂度过大
	public static int BadInversePairs(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j])
					count++;
			}
		}
		return (count % 1000000007);
	}

	// 采用归并排序的思想解决
	public static int InversePairs(int[] array) {
		int len = array.length;
		int p = mergeMethodPairs(array, 0, len - 1);
		return p;
	}

	private static int mergeMethodPairs(int[] array, int first, int end) {
		// TODO Auto-generated method stub
		if (first == end) {
			return 0;
		}
		int mid = (end - first) / 2;
		int[] copy = new int[array.length];
		// 递归
		int firstcount = mergeMethodPairs(array, first, first + mid);
		int lastcount = mergeMethodPairs(array, first + mid + 1, end);
		// 实现
		// 这里需要初始使刚开始都指向末尾 便于统计逆序个数
		int count = 0;
		int i = first + mid;
		int j = end;
		int copyed = end;
		while ((i >= first) && (j >= first + mid + 1)) {
			if (array[i] > array[j]) {
				copy[copyed--] = array[i--];
				count += j - (first + mid);
				if (count > 1000000007) {
					count = count % 1000000007;
				}
			} else {
				copy[copyed--] = array[j--];
			}
		}
		while (i >= first) {
			copy[copyed--] = array[i--];
		}
		while (j >= first + mid + 1) {
			copy[copyed--] = array[j--];
		}
		// 复制到元数组
		for (int m = 0; m < array.length; m++) {
			array[m] = copy[m];
		}
		return (firstcount + lastcount + count) % 1000000007;
	}

	// 输入两个链表，找出它们的第一个公共结点。
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode t1 = pHead1;
		ListNode t2 = pHead2;

		while (t1 != t2) {
			if (t1 != null)
				t1 = t1.next;
			else {
				t1 = pHead2;
			}
			if (t2 != null)
				t2 = t2.next;
			else {
				t2 = pHead1;
			}
		}
		return t1;
	}

	// 先判断一下哪个链表长 让长的链表先走
	public ListNode FindFirstCommon1(ListNode pHead1, ListNode pHead2) {
		ListNode t1 = pHead1;
		ListNode t2 = pHead2;
		if (pHead1 == pHead2)
			return pHead1;
		if (pHead1 == null)
			return pHead1;
		if (pHead2 == null)
			return pHead2;
		while (true) {
			while (true) {
				if (t1 == t2) {
					return t1;
				}
				if (t2.next == null) {
					break;
				}
				if (t2.next != null)
					t2 = t2.next;
			}
			if (t2.next == null)
				t2 = pHead2;
			if (t1.next == null)
				break;
			else {
				t1 = t1.next;
			}
		}
		return null;
	}

	// 统计一个数字在排序数组中出现的次数。
	// 升序降序未知
	public static int GetNumberOfK(int[] array, int k) {
		int count = 0;
		int flag = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == k) {
				count = 1;
				flag = 1;
			}
			while ((i + 1 < array.length) && (array[++i] == k)) {
				count++;
			}
			if (flag == 1)
				break;
		}
		return count;
	}

	public static int TreeDepth(TreeNode root) {
		// 递归方法求二叉树的深度
		if (root == null)
			return 0;
		int leftdeep = TreeDepth(root.left);
		int rightdeep = TreeDepth(root.right);
		if (leftdeep > rightdeep)
			return 1 + leftdeep;
		else
			return 1 + rightdeep;
	}

	// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
	public static boolean IsBalanced_Solution(TreeNode root) {
		// AVL树
		// 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
		if (root == null || (root.left == null && root.right == null)) {
			// 叶子
			return true;
		}
		int p = Math.abs(TreeDepth(root.left) - TreeDepth(root.right));
		if (p > 1)
			return false;
		else {
			return IsBalanced_Solution(root.left)
					&& IsBalanced_Solution(root.right);
		}
	}

	// 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	// num1,num2分别为长度为1的数组。传出参数
	// 将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int len = array.length;
		int flag = 1;
		// 遍历数组
		for (int i = 0; i < len; i++) {
			int temp = array[i];
			int j = 0;
			for (; j < len; j++) {
				if (j == i)
					continue;
				if (array[j] == temp)
					break;
			}
			if ((j == len) && (flag == 1)) {
				num1[0] = array[i];
				flag++;
				continue;
			}
			if ((j == len) && (flag == 2)) {
				num2[0] = array[i];
				break;
			}
		}
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
