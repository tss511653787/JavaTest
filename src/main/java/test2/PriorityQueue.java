package test2;

//实现一个优先队列ADT
public class PriorityQueue {
	int highest;// 队列具有的最高优先全 从0开始 0-highest
	IntQueue[] queue;

	public PriorityQueue(int highest) {
		this.highest = highest;
		this.queue = new IntQueue[highest + 1];
		// 实例化每个队列
		for (int i = 0; i < highest + 1; i++) {
			queue[i] = new IntQueue();
		}
	}

	public void offer(int target, int priority) {
		queue[priority].offer(target);
	}

	public int poll() {
		// 优先队列的出队列方法
		int answer = 0;
		for (int i = highest; i >= 0; i--) {
			if (!queue[i].isEmpty()) {
				answer = queue[i].poll();
				break;
			}
		}
		return answer;

	}

	public boolean isEmpty() {
		if (queue == null)
			return true;
		else {
			return false;
		}
	}
}
