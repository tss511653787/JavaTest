package Review;

import java.util.Stack;

public class BSTmake {
	public static void main(String[] args) {
		TreeNode res = makeBST(3);
		res.printorder();
	}

	/*
	 * 给定深度建立一颗满二叉排序树
	 */
	public static TreeNode makeBST(int deep) {
		int[] data = new int[(int) Math.pow(2, deep) - 1];
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1;
		}
		TreeNode answer = makeTree(null, 0, data.length - 1, data);
		return answer;
	}

	public static TreeNode makeTree(TreeNode p, int low, int high, int[] data) {
		if (low > high) {
			return null;
		} else {
			int mid = (low + high) / 2;
			p = new TreeNode(null, null, data[mid]);
			p.left = makeTree(p.left, low, mid - 1, data);
			p.right = makeTree(p.right, mid + 1, high, data);
			return p;
		}
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int data;

	public TreeNode(TreeNode left, TreeNode right, int data) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

	@SuppressWarnings("unused")
	public void printorder() {
		TreeNode p = this;
		Stack<TreeNode> stk = new Stack<>();
		while (p != null || !stk.isEmpty()) {
			while (p != null) {
				System.out.print(p.data + " ");
				stk.push(p);
				p = p.left;
			}
			if (!stk.isEmpty()) {
				TreeNode ouTreeNode = stk.pop();
				p = ouTreeNode.right;
			}
		}
	}
}
