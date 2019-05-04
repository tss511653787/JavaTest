package QuNai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
	public static void main(String[] args) {
		// int[] pre = { 1, 2, 4, 5, 3 };
		// int[] in = { 4, 2, 5, 1, 3 };
		Scanner scan = new Scanner(System.in);
		String line1 = scan.nextLine();
		int n = Integer.valueOf(line1);
		String[] line2 = scan.nextLine().split(" ");
		String[] line3 = scan.nextLine().split(" ");
		int[] pre = new int[n];
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = Integer.valueOf(line2[i]);
			in[i] = Integer.valueOf(line3[i]);
		}
		TreeNode newTree = reConstructTree(pre, in);
		ArrayList<Integer> res = PrintFromTopToBottom(newTree);
		// 使用lambda表达式输出
		res.forEach(x -> System.out.print(x + " "));
	}

	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		// 二叉树的广度优先遍历 思路和图的广度优先遍历相似 利用队列实现
		if (root == null)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode out = queue.poll();
			list.add(out.val);
			if (out.left != null)
				queue.offer(out.left);
			if (out.right != null)
				queue.offer(out.right);
		}
		return list;
	}

	//
	public static TreeNode reConstructTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		// 递归实现建树
		TreeNode aNewTree = reConstructBinaryTree(preorder, inorder, 0,
				preorder.length - 1, 0, inorder.length - 1);
		return aNewTree;
	}

	// 递归建树发方法
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in,
			int prestart, int preend, int instart, int inend) {
		TreeNode tree = new TreeNode(pre[prestart]);
		tree.left = null;
		tree.right = null;
		if (prestart == preend && instart == inend) {
			return tree;
		}
		int root = 0;
		for (root = instart; root < inend; root++) {
			if (pre[prestart] == in[root]) {
				break;
			}
		}
		int leifLength = root - instart;
		int rightLength = inend - root;
		if (leifLength > 0) {
			tree.left = reConstructBinaryTree(pre, in, prestart + 1, prestart
					+ leifLength, instart, root - 1);
		}
		if (rightLength > 0) {
			tree.right = reConstructBinaryTree(pre, in, prestart + 1
					+ leifLength, preend, root + 1, inend);
		}
		return tree;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		super();
		this.val = val;
	}

}
