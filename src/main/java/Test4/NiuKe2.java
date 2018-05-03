package Test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Stack;

import test3.BTNode;

public class NiuKe2 {
	private static int ssd = 12;
	private static String sss = "abc";
	private int id;

	
	public NiuKe2() {
		super();
	}

	public NiuKe2(int id) {
		super();
		this.id = id;
	}

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(1);
		// System.out.println(Convert(root).val);
		String str = "aba";
		String res = "";
		// permutation1(str, res, str.length(), null);
		NiuKe2 niu1 = new NiuKe2();
		NiuKe2 niu2 = new NiuKe2();
	}

	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		// 先把正常的next节点连接起来
		RandomListNode cursor = pHead;
		RandomListNode newhead = new RandomListNode(cursor.label);
		RandomListNode to = newhead;
		while (cursor.next != null) {
			cursor = cursor.next;
			to.next = new RandomListNode(cursor.label);
			to = to.next;
		}
		// 连接random指针
		cursor = pHead;
		to = newhead;
		while (cursor.next != null) {
			int where = whereIsTheNode(pHead, cursor.random);
			if (where >= 0)
				linkToNode(newhead, to, where);
			// 后移
			cursor = cursor.next;
			to = to.next;
		}
		return newhead;

	}

	public static int whereIsTheNode(RandomListNode head, RandomListNode node) {
		int answer = 0;
		if (node == null)
			return -1;
		if (head == node)
			return 0;
		while (head.next != null) {
			head = head.next;
			answer++;
			if (head == node)
				break;
		}
		return answer;
	}

	public static void linkToNode(RandomListNode head, RandomListNode node,
			int num) {
		if (num >= 0) {
			RandomListNode cusor = head;
			while (num > 0) {
				cusor = cusor.next;
				num--;
			}
			node.random = cusor;
		}
	}

	// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	public static TreeNode BadConvert(TreeNode pRootOfTree) {
		// 时间复杂度过大
		Stack<TreeNode> stk = new Stack<TreeNode>();
		ArrayList<TreeNode> arrList = new ArrayList<TreeNode>();
		// 中序遍历节点
		TreeNode p = pRootOfTree;
		if (p != null) { // 只有一个节点的情况
			if (p.left == null && p.right == null) {
				p.left = p;
				p.right = p;
				return p;
			}
			while (p != null || !stk.isEmpty()) {
				while (p != null) {
					stk.push(p);
					p = p.left;
				}
				if (!stk.isEmpty()) {
					TreeNode out = stk.pop();
					arrList.add(out);
					p = out.right;
				}
			}
			for (int i = 0; i < arrList.size(); i++) {
				TreeNode t = arrList.get(i);
				if (i == 0) {
					t.left = null;
					t.right = arrList.get(i + 1);
				} else if (i == arrList.size() - 1) {
					t.left = arrList.get(i - 1);
					t.right = null;
				} else {
					t.left = arrList.get(i - 1);
					t.right = arrList.get(i + 1);
				}
			}
			return arrList.get(0);
		} else {
			return null;
		}
	}

	public static TreeNode Convert(TreeNode pRootOfTree) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode p = pRootOfTree;
		TreeNode newroot = null;
		if (p == null)
			return null;
		TreeNode pre = null;
		boolean isFirst = true;
		while (p != null || !stk.isEmpty()) {
			while (p != null) {
				stk.push(p);
				p = p.left;
			}
			p = stk.pop();
			if (isFirst) {
				// 当前是第一个节点
				newroot = p;
				pre = newroot;
				isFirst = false;
			} else {
				// 不是第一个节点
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;
		}
		return newroot;
	}

	// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str.length() == 0)
			return list;
		String res = "";
		permutation1(str, res, str.length(), list);
		return list;

	}

	public static void permutation1(String str, String result, int len,
			ArrayList<String> list) {
		/*
		 * 全排列 递归实现 递归树： str: a b c ab ac ba bc ca cb result: abc acb bac bca
		 * cab cba
		 */
		// 结果 开始传入"" 空字符进入 len 是这个数的长度
		if (result.length() == len) { // 表示遍历完了一个全排列结果
			list.add(result);
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (result.indexOf(str.charAt(i)) < 0) { // 返回指定字符在此字符串中第一次出现处的索引。
					// System.out.println("字母："+str.charAt(i));
					permutation1(str, result + str.charAt(i), len, list);
				}
			}
		}
	}
}
