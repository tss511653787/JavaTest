package HuaWeiTest;

import java.util.LinkedList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListTransducedAccessorImpl;

public class MicroSoft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int P = Integer.valueOf(input[0]);
		int Q = Integer.valueOf(input[1]);
		int N = Integer.valueOf(input[2]);
		int n = 0;
		PTree r = makeTree(P, Q, N, n);
		// 先序遍历检验结果
		PreOrderPrint(r);
		double answer = 0.0;
		answer = caculate(r);
		System.out.println();
		System.out.println(answer);

	}

	public static double caculate(PTree r) {
		// TODO Auto-generated method stub
		LinkedList<PTree> list = new LinkedList<>();
		LinkedList<LinkedList<PTree>> listT = new LinkedList<>();
		getpathcore(r, listT, list);
		double answer = 0.0;
		for (int i = 0; i < listT.size(); i++) {
			double p = 1.0;
			for (int j = 0; j < listT.get(i).size(); j++) {
				PTree out = listT.get(i).get(j);
				if (out.flag) {
					p = p * out.sucP * 0.01;
				} else {
					//上一个值
					PTree lastp = listT.get(i).get(j-1);
					p = p * (100 - lastp.sucP) * 0.01;
				}
			}
			answer = answer + p * listT.get(i).size();
		}
		return answer;
	}

	private static void getpathcore(PTree r,
			LinkedList<LinkedList<PTree>> listT, LinkedList<PTree> list) {
		// TODO Auto-generated method stub
		// 树的路径判断
		if (r == null)
			return;
		// 是叶子节点
		if (r.leftchild == null && r.rightchild == null) {
			// 到叶子就把这个除了叶子之外的双亲list加入到listT中
			@SuppressWarnings("unchecked")
			LinkedList<PTree> copy = (LinkedList<PTree>) list.clone();
			listT.add(copy);
			return;
		}
		// 不是叶子节点
		list.add(r);
		getpathcore(r.leftchild, listT, list);
		getpathcore(r.rightchild, listT, list);
		// 回溯
		list.removeLast();
	}

	public static void PreOrderPrint(PTree root) {
		if (root != null) {
			System.out.print(root.sucP + "(" + root.sucCount + ")" + " ");
			PreOrderPrint(root.leftchild);
			PreOrderPrint(root.rightchild);
		}
	}

	public static PTree makeTree(int p, int q, int n, int num) {
		// TODO Auto-generated method stub
		// 根节点
		PTree root = new PTree(num, p, null, null);
		root.flag = true;
		bulidTree(root, n, p, q);
		return root;
	}

	public static void bulidTree(PTree root, int N, int P, int Q) {
		if (root.sucCount < N) {
			// 建树
			if (root.sucP == 100) {
				// 只创建做孩子
				int leftchildcount = root.sucCount + 1;
				int leftchildP = (int) (P / (int) (Math
						.pow(2.0, leftchildcount)));
				root.leftchild = new PTree(leftchildcount, leftchildP, null,
						null);
				root.leftchild.flag = true;
				bulidTree(root.leftchild, N, P, Q);
			} else {
				// 左右孩子都创建
				// 创建左孩子
				int leftchildcount = root.sucCount + 1;
				int leftchildP = (int) (P / (Math.pow(2.0, leftchildcount)));
				root.leftchild = new PTree(leftchildcount, leftchildP, null,
						null);
				root.leftchild.flag = true;
				bulidTree(root.leftchild, N, P, Q);
				// 创建右孩子
				int rightchildcount = root.sucCount;
				int rightchildP = root.sucP + Q;
				if (rightchildP >= 100)
					rightchildP = 100;
				root.rightchild = new PTree(rightchildcount, rightchildP, null,
						null);
				root.rightchild.flag = false;
				bulidTree(root.rightchild, N, P, Q);
			}
		}
	}
}

class PTree {
	int sucCount;
	int sucP;
	PTree leftchild;
	PTree rightchild;
	boolean flag;

	// 构造器
	public PTree(int sucCount, int sucP, PTree leftchild, PTree rightchild) {
		this.sucCount = sucCount;
		this.sucP = sucP;
		this.leftchild = leftchild;
		this.rightchild = rightchild;
	}

}
