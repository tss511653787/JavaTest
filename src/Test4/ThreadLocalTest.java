package Test4;

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocalTest test = new ThreadLocalTest();
		Task t1 = test.new Task();
		new Thread(t1).start();
		new Thread(t1).start();
	}

	// 定义一个内部类
	class Task implements Runnable {
		private volatile Integer shareMember = 0;
		private ThreadLocal<Integer> privateMember = new ThreadLocal<Integer>() {
			protected Integer initialValue() {
				return 0;
			}
		};

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10000; i++) {
				shareMember++;
				privateMember.set(privateMember.get() + 1);
				if (privateMember.get() != shareMember) {
					break;
				}
			}
			System.out.println("shareMember:" + shareMember + "privateMember"
					+ privateMember.get());

		}
	}

}
