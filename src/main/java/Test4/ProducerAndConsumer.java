package Test4;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Production {
	private int value;

	public void increase() {
		++value;
	}

	public void decrease() {
		--value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value + " ";
	}

}

public class ProducerAndConsumer {
	private static final Production product = new Production();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerAndConsumer pac = new ProducerAndConsumer();
		ExecutorService exe = Executors.newCachedThreadPool();
		//
		exe.submit(pac.new Producer());
		exe.submit(pac.new Consumer());
		try {
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e) {
			// TODO: handle exception
		}
		exe.shutdown();

	}

	protected static String thread() {
		return Thread.currentThread().getName() + " ";
	}

	class Producer implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (!Thread.interrupted()) {
					synchronized (product) {
						if (product.getValue() > 0) {
							product.notifyAll();
							product.wait();
						}
						product.increase();
						System.out.println(thread()
								+ "product count plus 1 becomes" + product);
					}
					TimeUnit.MILLISECONDS.sleep(200);

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	class Consumer implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (!Thread.interrupted()) {
					synchronized (product) {
						if (product.getValue() < 1) {
							product.notifyAll();
							product.wait();
						}
						product.decrease();
						System.out.println(thread()
								+ "product count minus 1 becomes" + product);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
