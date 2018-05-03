package test1;

public class ThreadExtendDemo extends Thread {
	// 构造器
	public ThreadExtendDemo(String threadName) {
		super();
		ThreadName = threadName;
	}

	private String ThreadName;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("执行");

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(ThreadName + " " + i);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("线程执行异常");
		}

		System.out.println(ThreadName + "退出");
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("开始启动");
	}
	// 通过继承Thread类来实现多线程

}
