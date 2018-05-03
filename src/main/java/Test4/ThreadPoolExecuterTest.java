package Test4;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecuterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个j线程池
		ExecutorService cachePool = Executors.newCachedThreadPool();
		cachePool.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("???");
			}
		});
		cachePool.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 100000; i++) {
					new Thread().start();

				}
			}
		});
		if (true) {
			cachePool.shutdown();
			// 返回一个未执行的列表
			List<Runnable> tash = cachePool.shutdownNow();
			System.out.println(tash);
		}

	}

}
