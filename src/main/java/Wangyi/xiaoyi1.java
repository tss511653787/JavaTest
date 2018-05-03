package Wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 
 * 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果
 * ,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 * */
public class xiaoyi1 {
	/*
	 * 思路是取每个取所有坐标的中位数作为基准点 中位数：排序后中间的一个(奇数)/两个数(偶数)
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] Xin = scan.nextLine().split("\\ ");
		String[] Yin = scan.nextLine().split("\\ ");
		long[] Xarr = new long[num];
		long[] Yarr = new long[num];
		for (int i = 0; i < num; i++) {
			Xarr[i] = Long.parseLong(Xin[i]);
			Yarr[i] = Long.parseLong(Yin[i]);
		}
		// 坐标数组
		List<Node> list = new ArrayList<>();
		Node[] Nodearr = new Node[num];
		for (int i = 0; i < num; i++) {
			Nodearr[i] = new Node(Xarr[i], Yarr[i]);
			list.add(new Node(Xarr[i], Yarr[i]));
		}
		List<Integer> answer = new ArrayList<Integer>();
		// find same node
		int same = findSame(list);

		// 每次树立前i个坐标
		for (int i = 1; i <= num; i++) {
			if (i <= same + 1) {
				answer.add(0);
			} else {
				int count = findCount(Nodearr, i);
				answer.add(count);
			}
		}
		for (int m = 0; m < answer.size(); m++) {
			if (m != answer.size() - 1) {
				System.out.print(answer.get(m) + " ");
			} else {
				System.out.print(answer.get(m));
			}
		}
	}

	public static int findCount(Node[] nodearr, int i) {
		// TODO Auto-generated method stub
		// nodearr->list
		List<Node> subNodeList = new ArrayList<>();
		while (i > 0) {
			subNodeList.add(nodearr[i - 1]);
			i--;
		}

		List<Long> xList = new ArrayList<>();
		List<Long> yList = new ArrayList<>();
		for (Node n : subNodeList) {
			xList.add(n.x);
			yList.add(n.y);
		}
		Collections.sort(xList);
		Collections.sort(yList);
		int size = xList.size();
		long midX;
		long midY;
		if (size % 2 == 0) {
			midX = (xList.get(size / 2) + xList.get(size / 2 - 1)) / 2;
			midY = (yList.get(size / 2) + yList.get(size / 2 - 1)) / 2;
		} else {
			midX = xList.get(size / 2);
			midY = yList.get(size / 2);
		}
		Node midnode = new Node(midX, midY);
		int count = 0;
		for (Node node : subNodeList) {
			count = count
					+ (int) (Math.abs(midnode.x - node.x) + Math.abs(midnode.y
							- node.y));
		}
		return count;
	}

	public static int findSame(List<Node> subNodeList) {
		// TODO Auto-generated method stub
		int max = 0;
		for (int i = 0; i < subNodeList.size(); i++) {
			int count = 0;
			Node n = subNodeList.get(i);
			for (int j = i + 1; j < subNodeList.size(); j++) {
				if (subNodeList.get(j).equals(n)) {
					count++;
				}
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
	}
}

class Node {
	long x;
	long y;

	public Node(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Node node = (Node) obj;
		if (node.x == x && node.y == y) {
			return true;
		} else {
			return false;
		}
	}

}
