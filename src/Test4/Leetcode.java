package Test4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import test2.IntDataNode;
import test3.BTNode;

public class Leetcode {
	private String let;

	public Leetcode(String let) {
		super();
		this.let = let;
	}

	// 求完全二叉树的节点个数
	// 深度n 叶子最多是2^(n-1)个 节点数最多是(2^n)-1个

	public static int countCompleteTreeNode(BTNode root) {
		if (root == null)
			return 0;
		if (nodeofMain(root) != 0) {
			return nodeofMain(root);
		} else {
			return countCompleteTreeNode(root.getLeft())
					+ countCompleteTreeNode(root.getRight()) + 1;
		}
	}

	private static int nodeofMain(BTNode root) {
		// TODO Auto-generated method stub
		int leftdeep = root.deep(root.getLeft());
		int rightdeep = root.deep(root.getRight());
		if (leftdeep == rightdeep) {
			// 该根下面的树是完全二叉树
			return (int) (Math.pow(2, (int) (leftdeep + 1)) - 1);
		} else {
			return 0;
		}

	}

	// 一般情况下统计二叉树节点个数
	public static int countNode(BTNode root) {
		if (root == null)
			return 0;
		else {
			return 1 + countNode(root.getLeft()) + countNode(root.getRight());

		}
	}

	// 二叉搜索树值第k个节点，特点:二叉搜索树的中序遍历是由小到大
	public static int kOfBtTree(BTNode root, int k) {
		int answer;
		ArrayList<Object> arr = new ArrayList<Object>();
		inOrderToBtTree(root, arr);
		return (int) arr.toArray()[k];
	}

	public static void inOrderToBtTree(BTNode root, ArrayList<Object> arr) {
		if (root == null) {

		} else {
			inOrderToBtTree(root.getLeft(), arr);
			arr.add(root.getData());
			inOrderToBtTree(root.getRight(), arr);
		}
	}

	// 求链表的倒数第k个节点
	// 最快速的方式使用2个指针跑 第一个到k第二个开始跑 知道第一个到末尾 第二个就是第n-k个
	public static ListNode FindIntDataNodeLastK(ListNode head, int k) {
		if (head == null || k > listLength(head) || k == 0) {
			return null;
		}
		ListNode i = head;
		ListNode j;
		// 这个必须k-1
		int num = k - 1;
		for (int m = 0; m < num; m++) {
			// i先后移到第k个
			i = i.next;
		}
		j = head;
		while (i.next != null) {
			// t同时后移
			i = i.next;
			j = j.next;
		}
		return j;
	}

	public static int listLength(ListNode head) {
		ListNode tail = head;
		int count = 1;
		if (tail == null)
			return 0;
		while (tail.next != null) {
			count++;
			tail = tail.next;
		}
		return count;
	}

	// 求二叉树的宽度
	// 使用队列实现
	public static int BtTreeWidth(BTNode root) {
		if (root == null)
			return 0;
		else {
			int lastWidth;
			int num;
			int currWidth;
			int width = 1;
			Queue<BTNode> queue = new LinkedList<BTNode>();
			queue.offer(root);
			lastWidth = 1;
			while (!queue.isEmpty()) {
				num = lastWidth;
				while (num != 0) {
					BTNode out = queue.poll();
					if (out.getLeft() != null)
						queue.offer(out.getLeft());
					if (out.getRight() != null)
						queue.offer(out.getRight());
					num--;
				}
				currWidth = queue.size();
				if (currWidth > width)
					width = currWidth;
				lastWidth = currWidth;
			}
			return width;
		}

	}

	// 反转链表
	// 返回值是新链表的head
	// 思路1使用栈
	public static ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;
		Stack<Integer> stk = new Stack<Integer>();
		while (head != null) {
			stk.push(head.val);
			head = head.next;
		}
		ListNode newhead = new ListNode(stk.pop());
		ListNode res = newhead;
		while (!stk.isEmpty()) {
			newhead.next = new ListNode(stk.pop());
			newhead = newhead.next;
		}
		return res;
	}

	// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode first;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		// 第一个
		if (list1.val <= list2.val) {
			first = list1;
			list1 = list1.next;
		} else {
			first = list2;
			list2 = list2.next;
		}
		ListNode newhead = first;
		while (true) {
			if (list1 != null && list2 != null) {
				if (list1.val <= list2.val) {
					first.next = list1;
					list1 = list1.next;
					first = first.next;
				} else {
					first.next = list2;
					list2 = list2.next;
					first = first.next;
				}
			} else {
				break;
			}
		}
		if (list1 == null) {
			first.next = list2;
		}
		if (list2 == null) {
			first.next = list1;
		}
		return newhead;
	}

	// 判断A树是不是B树的子树
	// 递归思路
	// 空null树不是任何树的子树
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		return is_subTree(root1, root2) || HasSubtree(root1.left, root2)
				|| HasSubtree(root1.right, root2);

	}

	private boolean is_subTree(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		if (root2 == null)
			return true;
		else if (root1 == null && root2 != null)
			return false;
		if (root1.val == root2.val) {
			return is_subTree(root1.left, root2.left)
					&& is_subTree(root1.right, root2.right);
		} else {
			return false;
		}

	}

	// 给定二叉树求他的镜像
	// 实质是将二叉树左右孩子交换
	public static void Mirror(TreeNode root) {
		if (root != null) {
			reTurnChild(root);
			Mirror(root.left);
			Mirror(root.right);
		}

	}

	// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
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

	public static void reTurnChild(TreeNode t) {
		// 交换孩子
		if (t != null) {
			TreeNode temp;
			temp = t.right;
			t.right = t.left;
			t.left = temp;
		}
	}

	// 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		return null;

	}

	public static TreeNode findInTree(TreeNode root, int target) {
		if (root == null)
			return null;
		TreeNode res = null;
		TreeNode leftres = null;
		TreeNode rightres = null;
		if (root.val == target)
			return root;
		else {
			if (root.left != null)
				leftres = findInTree(root.left, target);
			if (root.right != null)
				rightres = findInTree(root.right, target);
			if (leftres != null)
				res = leftres;
			else {
				res = rightres;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// BTNode root = new BTNode(1, null, null);
		// root.setLeft(new BTNode(2, null, null));
		// root.setRight(new BTNode(3, null, null));
		// root.getLeft().setLeft(new BTNode(4, null, null));
		// root.getLeft().setRight(new BTNode(5, null, null));
		// root.getRight().setLeft(new BTNode(6, null, null));
		// // System.out.println(kOfBtTree(root, 0));
		// IntDataNode head = new IntDataNode(1, null);
		// head.InsetBeforeHead(2);
		// head.InsetBeforeHead(3);
		// head.InsetBeforeHead(4);
		// head.InsetBeforeHead(5);
		// head.InsetBeforeHead(6);
		// // IntDataNode.PrintIntNode(head);
		// // System.out.println();
		// // System.out.println(BtTreeWidth(root));
		// ListNode ahead = new ListNode(1);
		// ahead.next = new ListNode(2);
		// ahead.next.next = new ListNode(3);
		// ahead.next.next.next = new ListNode(4);
		// ListNode a = ReverseList(ahead);
		// ListNode.PrintListNode(a);
		TreeNode ro = new TreeNode(1);
		ro.left = new TreeNode(2);
		ro.right = new TreeNode(3);
		ro.left.left = new TreeNode(4);
		ro.left.right = new TreeNode(5);
		ro.right.left = new TreeNode(6);
		TreeNode res = findInTree(ro, 6);
		System.out.println(res.val);

	}
}

// 题目中的节点类
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	public static void PrintListNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val + " ");
			head = head.next;
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
