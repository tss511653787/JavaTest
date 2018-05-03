package offer;

import java.util.ArrayList;
import java.util.Stack;

import com.sun.org.apache.regexp.internal.recompile;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Find {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 二维数组查找
	public static boolean Find(int target, int[][] array) {
		boolean answer = true;
		int len = array.length;// 行数
		int width = array[0].length;// 列数
		int i = len - 1;
		int j = 0;
		for (; i > -1 && j < width;) {
			if (target > array[i][j]) {
				j++;
			} else if (target < array[i][j]) {
				i--;
			} else {
				break;
			}
		}
		if (i >= 0 && i <= len - 1 && j >= 0 && j <= width - 1)
			return true;
		else {
			return false;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		// 从尾到头打印链表的值
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Stack<Integer> stk = new Stack<Integer>();
		while (listNode != null) {
			stk.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stk.isEmpty()) {
			answer.add(stk.pop());
		}
		return answer;
	}

	// 已知二叉树的先序和中序遍历重建二叉树
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinary(pre, 0, pre.length - 1, in, 0,
				in.length - 1);
		return root;

	}

	public TreeNode reConstructBinary(int[] pre, int startpre, int endpre,
			int[] in, int startin, int endin) {
		if (startpre > endpre || startin > endin) {
			return null;
		}
		// 跟节点是先序的第一个
		TreeNode root = new TreeNode(pre[startpre]);
		// 对中序编列分割二叉树
		for (int i = startin; i <= endin; i++) {
			if (in[i] == pre[startpre]) {
				// 找到
				root.left = reConstructBinary(pre, startpre + 1, startpre + i
						- startin, in, startin, i - 1);
				root.right = reConstructBinary(pre, startpre + 1 + i - startin,
						endpre, in, i + 1, endin);
			}
		}
		return root;
	}
}
