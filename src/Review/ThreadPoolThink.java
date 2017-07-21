package Review;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 四种提交方式
 * */
public class ThreadPoolThink {
	private static ExecutorService threadPool = Executors
			.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// 方法一 直接提交runnable对象
		Future<?> res = threadPool.submit(new RunImpl());
		// cancel task
		res.cancel(true);
		if (res.isCancelled()) {
			//
		}
		//
		Integer back = 0;
		Future<Integer> res2 = threadPool.submit(new RunImpl(), back);
		//
		Future<Integer> res3 = threadPool.submit(new CallImpl());
		int call = res3.get();
		// 无返回值
		threadPool.execute(new RunImpl());

	}
}

class CallImpl implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 执行代码
		 */
		return 1;
	}
}

class RunImpl implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		 * run code
		 */
	}

}
