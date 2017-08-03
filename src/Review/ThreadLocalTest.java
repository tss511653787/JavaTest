package Review;

/*
 * 写一个本地线程练习
 * 不同的线程对与一个共享变量保存不同的副本
 * */
public class ThreadLocalTest {

	ThreadLocal<Integer> intlocal = new ThreadLocal<>();
	ThreadLocal<String> strLocal = new ThreadLocal<>();

	public void set() {
		intlocal.set((int) Thread.currentThread().getId());
		strLocal.set(Thread.currentThread().getName());
	}

	public Integer getIntlocal() {
		return intlocal.get();
	}

	public String getStrLocal() {
		return strLocal.get();
	}

	/*
	 * test code
	 */
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 线程共享对象
		 */
		ThreadLocalTest threadLocalTest = new ThreadLocalTest();
		/*
		 * main Thread code
		 */
		threadLocalTest.set();
		System.out.println(threadLocalTest.getIntlocal() + " "
				+ threadLocalTest.getStrLocal());
		/*
		 * thead1
		 */
		Runnable run = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// 使用这个共享变量
				threadLocalTest.set();
				System.out.println(threadLocalTest.getIntlocal() + " "
						+ threadLocalTest.getStrLocal());
			}
		};
		Thread t = new Thread(run);
		t.start();
		t.join();
		System.out.println(threadLocalTest.getIntlocal() + " "
				+ threadLocalTest.getStrLocal());
	}
}
