package test3;

import java.util.Stack;

//完成一个二叉树的ADT实现

public class BTNode {
	// 私有属性
	// 数据 左孩子 右孩子
	private Object data;
	private BTNode left;
	private BTNode right;
	private boolean isFirst = true;

	// 构造器
	public BTNode(Object data, BTNode left, BTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// 默认的空节点构造器
	public BTNode() {
		super();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	// 判断是否是叶子节点
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	// 获取最左或最右数据
	public Object getLeftMostData() {
		if (left == null) {
			return data;
		} else {
			return left.getLeftMostData();
		}
	}

	// 返回最右面元素
	public Object getRightMostData() {
		if (right == null) {
			return data;
		} else {
			return right.getRightMostData();
		}
	}

	// 删除当前树最左面的节点
	public BTNode removeLeftMost() {
		// 返回值是一个比原来小的新树
		if (left == null)
			return right;
		else {
			left = left.removeLeftMost();
			return this;
		}
	}

	// 删除当前树最右面的节点
	public BTNode removeRightMost() {
		// 返回值是一个比原来小的新树
		if (right == null)
			return left;
		else {
			right = right.removeRightMost();
			return this;
		}
	}

	public static BTNode copyTree(BTNode root) {
		if (root == null)
			return null;
		else {
			BTNode leftcopy = copyTree(root.getLeft());
			BTNode rightcopy = copyTree(root.getRight());
			return new BTNode(root.getData(), leftcopy, rightcopy);
		}
	}

	public int deep(BTNode head) {
		if (head == null)
			return 0;
		else {
			int l = deep(head.getLeft());
			int r = deep(head.getRight());
			if (l > r)
				return l + 1;
			else {
				return r + 1;
			}
		}
	}

	// 统计二叉数中节点的个数
	public static int Treesize(BTNode root) {
		if (root == null)
			return 0;
		else {
			return 1 + Treesize(root.getLeft()) + Treesize(root.getRight());
		}
	}

	// 二叉树的三种编列
	public void preorderprint() {
		System.out.print(data + " ");
		if (left != null) {
			left.preorderprint();
		}
		if (right != null) {
			right.preorderprint();
		}
	}

	public void inorderprint() {
		if (left != null) {
			left.inorderprint();
		}
		System.out.println(data);
		if (right != null) {
			right.inorderprint();
		}
	}

	public void lastorderprint() {
		if (left != null) {
			left.lastorderprint();
		}
		if (right != null) {
			right.lastorderprint();
		}
		System.out.println(data);
	}

	// 可显示节点位置的中序遍历
	// 可以手动画出树
	public void AnewPreorderprint() {
		// 根绝深度进行空格
		for (int i = 0; i < deep(this); i++) {
			System.out.print(" ");
		}
		System.out.println(data);
		if (left != null) {
			left.AnewPreorderprint();
		}
		if (right != null) {
			right.AnewPreorderprint();
		}
	}

	// 树三种编列的非递归实现
	public static void preOrderNoDiGui(BTNode root) {
		if (root != null) {
			BTNode p = root;
			Stack<BTNode> stk = new Stack<>();
			while (p != null || !stk.isEmpty()) {
				while (p != null) {
					System.out.print(p.getData());
					stk.push(p);
					p = p.getLeft();
				}
				if (!stk.isEmpty()) {
					BTNode out = stk.pop();
					p = out.getRight();
				}
			}
		}
	}

	public static void inOrderNoDiGui(BTNode root) {
		if (root != null) {
			BTNode p = root;
			Stack<BTNode> stk = new Stack<>();
			while (p != null || !stk.isEmpty()) {
				while (p != null) {
					stk.push(p);
					p = p.getLeft();
				}
				if (!stk.isEmpty()) {
					BTNode out = stk.pop();
					System.out.print(out.getData());
					p = out.getRight();
				}
			}
		}
	}

	public static void lastorderNoDiGui(BTNode root) {
		if (root != null) {
			Stack<BTNode> stk = new Stack<>();
			BTNode p = root;
			while (p != null || !stk.isEmpty()) {
				while (p != null) {
					p.isFirst = true;
					stk.push(p);
					p = p.getLeft();
				}
				if (!stk.isEmpty()) {
					BTNode out = stk.pop();
					if (out.isFirst) {
						// 发现是第一次出栈
						out.isFirst = false;
						stk.push(out);
						p = out.getRight();
					} else {
						// 不是第一次出栈
						System.out.print(out.getData());
						p = null;
					}
				}
			}
		}
	}
}
