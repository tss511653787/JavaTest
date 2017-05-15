package test2;

//使用test2.IntDataNode 链表ADT实现队列
//offer poll isEmpty size 构造器

public class IntQueue {
	int manyNodes;
	IntDataNode head;
	IntDataNode rear;

	public IntQueue() {
		head = null;
		rear = head;
		manyNodes = 0;
	}

	public boolean isEmpty() {
		if (manyNodes == 0)
			return true;
		else
			return false;
	}

	public int size() {
		return manyNodes;
	}

	// 入队列方法
	public void offer(int target) {
		if (rear == null) {
			// 是一个空队列
			head = new IntDataNode(target, null);
			rear = head;
			manyNodes++;
		} else {
			IntDataNode newdata = new IntDataNode(target, null);
			rear.setLink(newdata);
			rear = rear.getLink();
			manyNodes++;
		}
	}

	// 出队列方法
	public int poll() {
		int answer;
		if (manyNodes <= 0) {
			System.out.println("这是一个空队列");
			return 0;
		} else {
			answer = head.getData();
			head = head.DeleteInHead(head);// 后移
			manyNodes--;
			return answer;
		}
	}
}
