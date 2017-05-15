package Test4;

import java.util.Arrays;

//银行存钱的同步例子
//使用synchronized关键字实现lock unlock
public class SynchronizedBank {
	public static void main(String[] args) {
		int NUM = 10;
		Bank bank = new Bank(NUM, 1000.0);
		for (int i = 0; i < NUM; i++) {
			int fromAccount = i;
			Runnable r = () -> {
				try {
					while (true) {
						int toAccount = (int) (bank.size() * Math.random());
						double amount = 1000 * Math.random();
						bank.transfer(fromAccount, toAccount, amount);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
	}
}

class Bank {
	// 银行中有n个账户
	private final double[] accounts;

	public Bank(int n, double intitalBalance) {
		// intitalBalance 每个账户中的初始存款
		this.accounts = new double[n];
		Arrays.fill(accounts, intitalBalance);
	}

	public synchronized void transfer(int from, int to, double amount)
			throws InterruptedException {
		while (accounts[from] < amount) {
			wait();
		}
		System.out.println("当前线程" + Thread.currentThread());
		accounts[from] -= amount;
		System.out.println(amount + " from " + from + " to " + to);
		accounts[to] += amount;
		System.out.println("总共钱数:" + getTotalBlance());
		notifyAll();
	}

	private synchronized String getTotalBlance() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (double a : accounts) {
			sum += a;
		}
		return String.valueOf(sum);
	}

	public int size() {
		return accounts.length;
	}
}
