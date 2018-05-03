package ReView2;

public class LinkedList {
	// main
	public static void main(String[] args) {
		ListNode head = makeAlist();
		out(head);
		System.out.println();
		ListNode r = reverse2(head);
		out(r);
		System.out.println();
		XiPai();

	}

	public static void out(ListNode head) {
		// TODO Auto-generated method stub
		ListNode p = head;
		while (p != null) {
			if (p.next == null) {
				System.out.print(p.data);
			} else {
				System.out.print(p.data + "->");
			}
			p = p.next;
		}
	}

	public static ListNode reverse(ListNode head) {
		// TODO Auto-generated method stub
		ListNode h = head;
		if (h.next == null) {
			return h;
		}
		ListNode p = head.next;
		if (p.next == null) {
			h.next = null;
			p.next = h;
			return p;
		}
		ListNode q = p.next;
		h.next = null;
		while (q != null) {
			p.next = h;
			h = p;
			p = q;
			q = q.next;
		}
		p.next = h;
		return p;
	}

	public static ListNode reverse2(ListNode head) {
		ListNode res = new ListNode(0, null);
		ListNode p = head;
		while (p != null) {
			res.next = new ListNode(p.data, res.next);
			p = p.next;
		}
		return res.next;
	}

	public static ListNode makeAlist() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(8, null);
		head.next = new ListNode(3, null);
		head.next.next = new ListNode(2, null);
		head.next.next.next = new ListNode(1, null);
		return head;
	}

	/*
	 * 给定一个降序排列的数组 输出一种排列为：最小值，最大值，次小值，次大值 这样的数组排列 思路：奇数位置是原来数组的[i/2]
	 * 偶数位置是原来数组的[n-1-i/2] 时间复杂度O(n) 空间复杂度O(1)
	 */
	public static void XiPai() {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int len = arr.length;
		int temp;
		// 输出模式
		int k = 0;
		int p = len - 1;
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				System.out.print(arr[p--] + " ");
			} else {
				System.out.print(arr[k++] + " ");
			}
		}
		// for (int i = 0; i < len; i++) {
		// if (i % 2 != 0) {
		// temp = arr[i];
		// arr[i] = arr[i / 2];
		// arr[i / 2] = temp;
		// } else {
		// temp = arr[i];
		// arr[i] = arr[len - 1 - i / 2];
		// arr[len - 1 - i / 2] = temp;
		// }
		// }
		// for (int j = 0; j < len; j++) {
		// System.out.print(arr[j] + " ");
		// }
	}

}

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data, ListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

}
