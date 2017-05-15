package MianShiBaoDian;

public class SynchronizedSell {
	// 简单写一个互斥锁的卖票程序
	// 主要是关注在变量加锁和方法加锁的区别
	// 三个实例卖票
	public static void main(String[] args) throws InterruptedException {
		SellTicket sell = new SellTicket();
		Thread s1 = new Thread(sell, "p1");
		Thread s2 = new Thread(sell, "p2");
		Thread s3 = new Thread(sell, "p3");
		s1.start();
		s2.start();
		s3.start();
		s1.join();
		s2.join();
		s3.join();

	}

}

class SellTicket implements Runnable {
	private int SumTicket = 20;
	String flag = "begin";

	// 卖票
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while (true) {
			// 对标记加锁
			if (SumTicket > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 卖票
				System.out.println(Thread.currentThread().getName() + "sell"
						+ SumTicket--);
			} else {
				break;
			}
		}
	}

}
