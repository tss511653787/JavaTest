package Review;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * HashMap由于扩容导致的并发问题
 * */
public class CurrentInHashMap {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			doget();
			Thread.sleep(1000);
		}
	}

	private static void doget() throws InterruptedException {
		// TODO Auto-generated method stub
		final Map<String, String> map = new HashMap<String, String>();
		final AtomicInteger checkNum = new AtomicInteger(0);
		map.put("0", "neu.edu.cn");
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			executorService.submit(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					map.put((int) System.nanoTime() + new Random().nextInt()+" ",
							"neu.edu.cn");
					String out = map.get("0");
					if (out == null) {
						checkNum.incrementAndGet();
					}
				}
			});
		}
		executorService.awaitTermination(1, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println(checkNum);
	}
}
