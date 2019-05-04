package HuaWeiTest;

import java.util.ArrayList;
import java.util.LinkedList;

import HuaWeiTest.NiuKe2;

public class TreePath {
	public static void getPath(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> list = new LinkedList<>();
		getpathcore(root, list);
	}

	private static void getpathcore(TreeNode root, LinkedList<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		if (root.left == null && root.right == null) {
			// 到叶子节点就打印
			for (TreeNode temp : list) {
				System.out.print(temp.value + " ");
			}
			System.out.println();
			// 回溯
			list.removeLast();
			return;
		}
		getpathcore(root.left, list);
		getpathcore(root.right, list);
		// 回溯
		list.removeLast();// 清除最后一个元素
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// getPath(root);
		ArrayList<ArrayList<Integer>> res = NiuKe2.FindPath(root, 8);
		for (ArrayList<Integer> a : res) {
			for (Integer n : a) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.value = value;
	}

}
