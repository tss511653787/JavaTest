package test1;

public class RunnableDemo implements Runnable {
	// 通过继承Runnable接口来实现多线程
	private String ThreadName;

	// 构造方法s
	RunnableDemo(String threadName) {
		super();
		ThreadName = threadName;
		System.out.println("创建了:" + ThreadName);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 执行本身
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

	public void start() {
		Thread th = new Thread(this, ThreadName);
		System.out.println("开始启动");
		th.start();
	}

}
