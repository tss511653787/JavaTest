package test1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 新实例化一个包含10个线程的线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// 放入线程
		// for (int i = 0; i < 10; i++) {
		// // pool.execute 丢入线程池 无返回值
		// pool.execute(new Runnable() {
		//
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// System.out.println(Thread.currentThread().getName());
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// });
		// }
		// pool.submit(...) 有返回值
		Future<Integer> recall = pool.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName()
						+ "sleep...");
				return 5;
			}
		});
		boolean flag = true;
		while (flag) {
			if (recall.isDone()) {
				System.out.println("Finish");
				flag = false;
			} else {
				try {
					System.out.println(Thread.currentThread().getName()
							+ " wait");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		pool.shutdown();
	}
}
