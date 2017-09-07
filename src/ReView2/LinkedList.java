package ReView2;

public class LinkedList {
	// main
	public static void main(String[] args) {
		ListNode head = makeAlist();
		out(head);
		System.out.println();
		ListNode r = reverse2(head);
		out(r);
		
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
