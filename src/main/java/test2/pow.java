package test2;

public class pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(Power(2, -2));
		// test INTqueue
		IntQueue queue = new IntQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(4);
		queue.offer(4);
		// while (!queue.isEmpty()) {
		// System.out.println(queue.poll());
		// }
		// test priQueue
		PriorityQueue prique = new PriorityQueue(3);
		prique.offer(2, 2);

		while (!prique.isEmpty()) {
			System.out.print(prique.poll() + " ");
		}

	}

	public static double Power(double base, int exponent) {
		// exponent可以是负数
		Double res = 1.0;
		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				res = res * base;
			}
			return res;
		} else if (exponent < 0) {
			for (int i = 0; i < -exponent; i++) {
				res = res * base;
			}
			return 1.0 / res;
		} else
			return res;

	}

}
