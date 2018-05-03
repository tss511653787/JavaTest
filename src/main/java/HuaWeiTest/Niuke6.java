package HuaWeiTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Niuke6 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		// root.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(2);
		// root.left.right = new TreeNode(7);
		// root.right.left = new TreeNode(9);
		// root.right.right = new TreeNode(10);
		Niuke6 n = new Niuke6();
		String str = n.Serialize(root);
		System.out.println(n.Serialize(n.Deserialize(str)));
	}

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		TreeLinkNode cursor = pNode;
		// 判空
		if (pNode == null) {
			return null;
		}
		// 有右孩子
		if (pNode.right != null) {
			// 指向父节点
			cursor = pNode.right;
			while (cursor.left != null) {
				cursor = cursor.left;
			}
			return cursor;
		}
		// 不是根节点情况
		while (pNode.next != null) {
			cursor = pNode.next;
			// 其父节点的左子树是该节点返回父节点
			if (cursor.left == pNode) {
				return cursor;
			}
			// 继续向上寻找
			pNode = pNode.next;
		}
		return null;
	}

	/*
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印， 第二层按照从右至左的顺序打印，
	 * 第三行按照从左到右的顺序打印，其他行以此类推。
	 */
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		// 使用两个栈实现
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		if (pRoot == null)
			return answer;
		Stack<TreeNode> stk1 = new Stack<>();
		Stack<TreeNode> stk2 = new Stack<>();
		stk1.push(pRoot);
		while (!stk1.isEmpty() || !stk2.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (!stk1.isEmpty()) {
				while (!stk1.isEmpty()) {
					TreeNode out = stk1.pop();
					temp.add(out.value);
					if (out.left != null) {
						stk2.push(out.left);
					}
					if (out.right != null) {
						stk2.push(out.right);
					}
				}
				answer.add(temp);
			} else {
				// !stk2.isEmpty
				while (!stk2.isEmpty()) {
					TreeNode out = stk2.pop();
					temp.add(out.value);
					if (out.right != null) {
						stk1.push(out.right);
					}
					if (out.left != null) {
						stk1.push(out.left);
					}
				}
				answer.add(temp);
			}
		}
		return answer;
	}

	public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		if (pRoot == null)
			return answer;
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		queue.offer(pRoot);
		boolean flag = true;
		int start = 0;
		int end = 1;
		while (!queue.isEmpty()) {
			TreeNode out = queue.poll();
			temp.add(out.value);
			start++;
			if (out.left != null)
				queue.offer(out.left);
			if (out.right != null)
				queue.offer(out.right);
			if (start == end) {
				end = queue.size();
				start = 0;
				if (flag) {
					// 正序
					ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
					answer.add(copy);
					// 这个地方向answer中添加的是引用所以不能直接clear
					flag = false;
					temp.clear();
				} else {
					// 倒序
					Collections.reverse(temp);
					ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
					answer.add(copy);
					flag = true;
					temp.clear();
				}
			}
		}
		return answer;
	}

	// 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
	ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {

		// 二叉树的层次遍历
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		if (pRoot == null)
			return answer;
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		queue.offer(pRoot);
		int start = 0;
		int end = 1;
		while (!queue.isEmpty()) {
			TreeNode out = queue.poll();
			temp.add(out.value);
			start++;
			if (out.left != null)
				queue.offer(out.left);
			if (out.right != null) {
				queue.offer(out.right);
			}
			if (start == end) {
				ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
				answer.add(copy);
				start = 0;
				end = queue.size();
				temp.clear();
			}
		}
		return answer;
	}

	// 请实现两个函数，分别用来序列化和反序列化二叉树
	// 序列化只能用递归的思想
	static int index = -1;

	String Serialize(TreeNode root) {
		// 序列化二叉树
		// 层次遍历思想
		StringBuilder strTemp = new StringBuilder();
		if (root == null) {
			return "# ";
		}
		strTemp.append(root.value + " ");
		strTemp.append(Serialize(root.left));
		strTemp.append(Serialize(root.right));
		return strTemp.toString();
	}

	// 递归思想
	TreeNode Deserialize(String str) {
		index++;
		int len = str.length();
		if (index >= len) {
			return null;
		}
		TreeNode node = null;
		String[] arr = str.split(" ");
		if (!arr[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(arr[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}

	// 给定一颗二叉搜索树，请找出其中的第k大的结点。
	public static TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null)
			return null;
		Stack<TreeNode> stk = new Stack<>();
		TreeNode p = pRoot;
		int count = 0;
		while (p != null || !stk.isEmpty()) {
			while (p != null) {
				stk.push(p);
				p = p.left;
			}
			if (!stk.isEmpty()) {
				TreeNode out = stk.pop();
				count++;
				if (count == k) {
					return out;
				}
				p = out.right;
			}
		}
		return null;
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}
