package Review;

import java.util.Stack;

/*
 * 两个栈实现一个队列(FIFO)
 * */

public class TwoStackImlpQueue {
	public static Stack<Integer> stk1 = new Stack<>();
	public static Stack<Integer> stk2 = new Stack<>();

	/*
	 * test code
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TwoStackImlpQueue queue = new TwoStackImlpQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.poll());
		queue.offer(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

	}

	public static int offer(int i) {
		return stk1.push(i);
	}

	public static int poll() {
		if (stk2.isEmpty()) {
			// stk1的第n-1个值倒入到stk2
			int num = stk1.size();
			for (int i = 0; i < num - 1; i++) {
				stk2.push(stk1.pop());
			}
			// stk1的第n个值弹栈
			return stk1.pop();
		} else {
			// !stk2isEmpty
			return stk2.pop();
		}
	}
}
