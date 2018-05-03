package ReView2;

import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class _58 {
	// test
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		TreeNode root = new TreeNode("1", null, null);
		root.left = new TreeNode("2", null, null);
		root.right = new TreeNode("3", null, null);
		root.left.left = new TreeNode("4", null, null);
		root.left.right = new TreeNode("5", null, null);
		preOrder(root);
		System.out.println();
		System.out.println(TreeServial(root));
		preOrder(TreeReServial(TreeServial(root)));
		String abc = new String("abc");
		System.out.println();
		Test1();
	}

	// 二叉树序列化
	public static String TreeServial(TreeNode root) {
		TreeNode p = root;
		StringBuilder temp = new StringBuilder();
		if (p == null) {
			return "# ";
		} else {
			temp.append(p.data + " ");
			temp.append(TreeServial(p.left));
			temp.append(TreeServial(p.right));
			return temp.toString();
		}
	}

	// index标识
	static int count = -1;

	// 反序列化
	public static TreeNode TreeReServial(String str) {
		count++;
		int len = str.length();
		if (count >= len) {
			return null;
		} else {
			TreeNode node = null;
			String[] in = str.split("\\s+");
			if (!in[count].equals("#")) {
				node = new TreeNode(in[count], null, null);
				node.left = TreeReServial(str);
				node.right = TreeReServial(str);
			}
			return node;
		}
	}

	// preOrder
	public static void preOrder(TreeNode root) {
		TreeNode p = root;
		Stack<TreeNode> stk = new Stack<>();
		while (p != null || !stk.isEmpty()) {
			while (p != null) {
				System.out.print(p.data + " ");
				stk.push(p);
				p = p.left;
			}
			if (!stk.isEmpty()) {
				TreeNode out = stk.pop();
				p = out.right;
			}
		}
	}

	public static void Test1() throws InterruptedException, ExecutionException {
		Callable<Integer> call = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
					return 1;
				} catch (Exception e) {
					// TODO: handle exception
					return 0;
				}
			}
		};
		FutureTask<Integer> task = new FutureTask<>(call);
		Thread t = new Thread(task);
		t.start();
		//t.interrupt();
		System.out.println(task.get());
	}
}

class TreeNode {
	String data;
	TreeNode left;
	TreeNode right;

	public TreeNode(String data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
