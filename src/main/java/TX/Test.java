package TX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// TreeNode r = makeTree();
		// TreeNode.preOrder(r);
		FindSmallRoot();
	}

	// 给定排序二叉树层数 建立满二叉树
	public static TreeNode makeTree() {
		Scanner scan = new Scanner(System.in);
		int deep = scan.nextInt();
		// 递归建立一个满二叉树
		// 满二叉树节点个数2^k-1
		int[] num = new int[(int) (Math.pow(2, deep) - 1)];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		TreeNode root = null;
		int low = 0;
		int high = num.length - 1;
		// 递归建树
		return make(root, low, high, num);
	}

	private static TreeNode make(TreeNode p, int low, int high, int[] num) {
		// TODO Auto-generated method stub
		if (low > high) {
			return null;
		} else {
			int mid = (low + high) / 2;
			p = new TreeNode(num[mid]);
			p.left = make(p.left, low, mid - 1, num);
			p.right = make(p.right, mid + 1, high, num);
			return p;
		}
	}

	// 给定三个满二叉排序树的值 返回最小子树的根
	// 不使用建树的方法递归判断
	public static void FindSmallRoot() {
		Scanner scan = new Scanner(System.in);
		int deep = scan.nextInt();
		// 满二叉树节点个数2^k-1
		int[] num = new int[(int) (Math.pow(2, deep) - 1)];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		int answer = 0;
		int smallRoot = findSmall((int) Math.pow(2, deep) / 2 + answer, n1, n2,
				n3, deep);
		System.out.print(smallRoot);
	}

	private static int findSmall(int answer, int n1, int n2, int n3, int deep) {
		// TODO Auto-generated method stub

		if (deep == 0) {
			return 0;
		}
		// find min and max value in n1 n2 n3
		int min = n1;
		if (n2 < min)
			min = n2;
		if (n3 < min)
			min = n3;
		int max = n1;
		if (n2 > max)
			max = n2;
		if (n3 > max)
			max = n3;

		if (answer > min && answer < max) {
			return answer;
		} else if (answer >= max) {
			// 向左子树移动
			return findSmall(answer - (int) Math.pow(2, deep - 1) / 2, n1, n2,
					n3, deep - 1);
		} else {
			// answer<min
			// 向右子树移动
			return findSmall(answer + (int) Math.pow(2, deep - 1) / 2, n1, n2,
					n3, deep - 1);
		}
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
