package HuaWeiTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CollableFutureThread {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// TODO Auto-generated method stub
		int number = 0;
		FutureTask<Integer> future = new FutureTask<>(new CallableTest(number));
		Thread t = new Thread(future);
		t.start();
		int res = future.get();
		System.out.println(res);

	}

}

class CallableTest implements Callable<Integer> {
	int num;

	public CallableTest(int num) {
		super();
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			num++;
		}
		if (num == 100) {
			return 1;
		} else {
			return 0;
		}
	}
	// 执行的返回值是一个integer类型

}
