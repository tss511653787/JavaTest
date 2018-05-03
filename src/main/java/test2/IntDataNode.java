package test2;

public class IntDataNode {
	// 编写一个自定义链表类
	private int data;
	private IntDataNode link;

	// 构造器
	public IntDataNode(int data, IntDataNode link) {
		// super();
		this.data = data;
		this.link = link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public IntDataNode getLink() {
		return link;
	}

	public void setLink(IntDataNode link) {
		this.link = link;
	}

	// *给链表尾部插入节点
	public void InsetBeforeHead(int data) {
		IntDataNode find = this;
		// 后移寻找插入位置
		while (find.getLink() != null) {
			find = find.getLink();
		}
		find.setLink(new IntDataNode(data, null));
	}

	// 头部删除节点
	public IntDataNode DeleteInHead(IntDataNode head) {
		head = head.getLink();
		return head;
	}

	// 非链表头部插入节点
	public void InsetAfterNode(int data) {
		// selection 是插入位置前一个节点的link
		link = new IntDataNode(data, link);
	}

	// 删除非头部节点
	public void DeleteAfterNode() {
		// 删除该节点的下一个节点
		link = link.getLink();
	}

	// 静态的listlength方法
	// 递归实现
	public static int listlength(IntDataNode head) {
		// 递归方法
		if (head == null) {
			return 0;
		} else {
			if (head.getLink() == null)
				return 1;
			else {
				return 1 + listlength(head.getLink());
			}
		}
	}

	// listlength方法的非递归实现(遍历链表)
	public static int listLengthAll(IntDataNode head) {
		IntDataNode cursor = head;
		int answer = 0;
		if (head == null)
			return answer;
		else {
			// 非空链表
			for (; cursor != null; cursor = cursor.getLink()) {
				answer++;
			}
			return answer;
		}
	}

	// 打印链表的静态方法
	public static void PrintIntNode(IntDataNode node) {
		while (node != null) {
			System.out.print(node.getData() + "--");
			node = node.getLink();
		}
	}

	// 查找链表中的值
	public static IntDataNode SearchNode(IntDataNode node, int target) {
		if (node != null) {
			if (node.getData() == target) {
				return node;
			} else {
				node = node.getLink();
				return SearchNode(node, target);
			}

		} else {
			return null;
		}
		// return node;
	}

	// 非递归方法
	public static IntDataNode SearchNodeAll(IntDataNode head, int target) {
		if (head == null) {
			return null;
		}
		IntDataNode cursor = head;
		for (; cursor != null; cursor = cursor.getLink()) {
			if (cursor.getData() == target) {
				return cursor;
			}
		}
		return null;

	}

	public static IntDataNode listPosition(IntDataNode head, int positon) {
		// 和上面方法相似
		if (head == null) {
			return null;
		}
		IntDataNode cursor = head;
		for (int i = 1; i < positon && cursor != null; i++) {
			cursor = cursor.getLink();
		}
		return cursor;
	}

	// 复制到一个新链表
	public static IntDataNode listCopy(IntDataNode head) {
		if (head == null)
			return null;
		IntDataNode copyhead = new IntDataNode(head.getData(), null);// 复制list的head
		IntDataNode copytail = copyhead;
		while (head.getLink() != null) {
			head = head.getLink();
			copytail.InsetAfterNode(head.getData());
			copytail = copytail.getLink();
		}
		return copyhead;
	}

	// copy后同时返回copyhead和copytail指针
	public static IntDataNode[] listCopyAll(IntDataNode head) {
		if (head == null) {
			return null;
		} else {
			IntDataNode copyhead = new IntDataNode(head.getData(), null);
			IntDataNode copytail = copyhead;
			while (head.getLink() != null) {
				head = head.getLink();
				copytail.InsetAfterNode(head.getData());
				copytail = copytail.getLink();
			}
			IntDataNode[] resNode = new IntDataNode[2];
			resNode[0] = copyhead;
			resNode[1] = copytail;
			return resNode;
		}

	}

	// 从start 到 end 截取复制到新数组
	public static IntDataNode[] listPartCopy(IntDataNode start, IntDataNode end) {
		if (start == null || end == null)
			return null;
		else {
			IntDataNode copyhead = new IntDataNode(start.getData(), null);
			IntDataNode copytail = copyhead;
			while (start.getLink() != null && start != end) {
				start = start.getLink();
				copytail.InsetAfterNode(start.getData());
				copytail = copytail.getLink();
			}
			IntDataNode[] resNode = new IntDataNode[2];
			resNode[0] = copyhead;
			resNode[1] = copytail;
			return resNode;
		}
	}

	// 删除一个节点中一个target的静态方法
	// 返回值是头结点指针
	public static IntDataNode deleteInList(IntDataNode head, int target) {
		if (head == null)
			return null;
		else {
			IntDataNode ser = head;
			if (head.getData() == target) {
				// 头节点就是所要删除的数据
				return head.getLink();
			}

			while (ser.getLink() != null && ser.getLink().getData() != target) {
				ser = ser.getLink();
			}
			if (ser.getLink() == null) {
				// 没有这个target值
				return head;
			} else {
				ser.DeleteAfterNode();
				return head;
			}

		}
	}

	public static IntDataNode deleteSearch(IntDataNode head, int target) {
		if (head == null)
			return null;
		else {
			IntDataNode cursor = head;
			if (cursor.getData() == target)
				return head.getLink();
			while (cursor.getLink() != null
					&& cursor.getLink().getData() != target) {
				cursor = cursor.getLink();
			}
			if (cursor.getLink() == null)
				return null;
			else {
				return cursor;
			}
		}
	}

	// 删除list中的一个节点用头节点代替(高效率)
	public static IntDataNode deleteWithHead(IntDataNode head, int target) {
		if (head == null)
			return null;
		else {
			IntDataNode ser = IntDataNode.SearchNode(head, target);
			if (ser == null) {
				// 未找到
				return null;
			} else {
				ser.setData(head.getData());
				// 返回头结点下一个节点
				return head.getLink();
			}
		}
	}

	// grab方法 从linkedlist中随机取一个元素
	public int grab() {
		// 产生一个随机数
		int i = (int) Math.random() * (listlength(link)) + 1;
		return listPosition(link, i).getData();
	}

	// 首尾连接两个链表返回连接后的head
	public static IntDataNode addAll(IntDataNode a, IntDataNode b) {
		// 复制a的副本copyA 返回副本的首节点
		IntDataNode[] copyA = listCopyAll(a);
		IntDataNode[] copyB = listCopyAll(b);
		copyA[1].setLink(copyB[0]);
		return copyA[0];
	}
}
