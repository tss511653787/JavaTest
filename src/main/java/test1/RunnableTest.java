package test1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class RunnableTest {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// TODO Auto-generated method stub
		// RunnableDemo demo1 = new RunnableDemo("Thread1");
		// RunnableDemo demo2 = new RunnableDemo("Threads");
		// demo1.start();
		// demo2.start();

		// ThreadExtendDemo th1 = new ThreadExtendDemo("th1");
		// ThreadExtendDemo th2 = new ThreadExtendDemo("th2");
		// th1.start();
		// th2.start();
		CallableFutureThreadTest test1 = new CallableFutureThreadTest();
		FutureTask<Integer> ft = new FutureTask<Integer>(test1);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 5) {
				// runnable
				Thread t = new Thread(ft, "CFT");
				t.start();
			}
		}
		// future
		Integer res = ft.get();
		System.out.println(res);
	}
}
