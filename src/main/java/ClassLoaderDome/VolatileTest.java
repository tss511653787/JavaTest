package ClassLoaderDome;

import java.util.concurrent.atomic.AtomicInteger;

import test1.findNum;

public class VolatileTest {
	public static volatile int race = 0;
	static AtomicInteger num = new AtomicInteger(0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threadArr = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			threadArr[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 10000; i++) {

						increase();
					}
				}
			});
			threadArr[i].start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(race);
		System.out.println(num);
	}

	public static void increase() {
		race++;
		num.incrementAndGet();
	}

	private static final int THREADS_COUNT = 20;

}
