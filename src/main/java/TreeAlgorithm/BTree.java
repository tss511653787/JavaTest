package TreeAlgorithm;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 *回顾一下树算法
 * */
public class BTree {
	/*
	 * 求完全二叉树节点个数 思路：每次判断一下子树是否是左右平衡的 如果平衡 说明下面是一棵满二叉树 直接使用特性返回 如果不平衡则按常规递归
	 */
	public static int countNodeInBtree(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (isfull(root) != 0) {
			return isfull(root);
		} else {
			return 1 + countNodeInBtree(root.left)
					+ countNodeInBtree(root.right);
		}
	}

	private static int isfull(TreeNode root) {
		// TODO Auto-generated method stub
		// 判断子树是否是一个满二叉树
		int left = deep(root.left);
		int right = deep(root.right);
		if (left == right) {
			return (int) (Math.pow(2, left + 1) - 1);
		} else {
			return 0;
		}
	}

	private static int deep(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		} else {
			int left = deep(root.left);
			int right = deep(root.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}

	// 队列实现求二叉树宽度
	public static int widthBTree(TreeNode root) {
		/*
		 * 思路 队列实现 节点如队列 统计当前宽度 和之前宽度比较如果大则替换
		 */
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		int witdth = 0;
		while (!queue.isEmpty()) {
			witdth = queue.size();
			int num = witdth;
			while (num > 0) {
				TreeNode out = queue.poll();
				if (out.left != null) {
					queue.offer(out.left);
				}
				if (out.right != null) {
					queue.offer(out.right);
				}
				num--;
			}
			witdth = witdth > queue.size() ? witdth : queue.size();
		}
		return witdth;
	}
	
	
	
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

	public static void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.val + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
}
