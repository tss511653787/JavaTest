package ReView2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MakeBst {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int num = Integer.parseInt(scanner.nextLine());
		maketree(num);
	}

	private static void maketree(int num) {
		// TODO Auto-generated method stub
		int len = (int) (Math.pow(2, num) - 1);
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = i + 1;
		}
		Node root = null;
		root = make(root, 0, len - 1, arr);
		inorder(root);
		System.out.println();
		PathPrint(root);
	}

	public static void inorder(Node root) {
		// TODO Auto-generated method stub
		Node p = root;
		Stack<Node> stk = new Stack<>();
		while (p != null || !stk.isEmpty()) {
			while (p != null) {
				stk.push(p);
				p = p.left;
			}
			if (!stk.isEmpty()) {
				Node out = stk.pop();
				System.out.print(out.data + " ");
				p = out.right;
			}
		}
	}

	public static Node make(Node p, int low, int high, int[] arr) {
		// TODO Auto-generated method stub
		if (low <= high) {
			int mid = (low + high) / 2;
			p = new Node(arr[mid], null, null);
			p.left = make(p.left, low, mid - 1, arr);
			p.right = make(p.right, mid + 1, high, arr);
		}
		return p;
	}

	public static void PathPrint(Node root) {
		Node p = root;
		List<Node> list = new ArrayList<Node>();
		Path(p, list);
	}

	public static void Path(Node p, List<Node> list) {
		// TODO Auto-generated method stub
		if (p == null)
			return;
		list.add(p);
		if (p.left == null && p.right == null) {
			// out
			list.forEach(x -> System.out.print(x.data + " "));
			System.out.println();
		}
		Path(p.left, list);
		Path(p.right, list);
		list.remove(list.size() - 1);
	}

}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
