package MianShiBaoDian;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

public class Fork_Join {
	/*
	 * java7中引入的多线程fork-join计算框架 将一个大任务(超过一定线程执行)就将其分解成多个小模块多个线程计算 然后最后合并计算结果
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 100000000;
		double[] numbers = new double[SIZE];
		// 构建一个随机double数组
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = Math.random();
		}
		// 在fork-join框架中执行
		Counter count = new Counter(numbers, 0, SIZE, x -> x > 0.5);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(count);
		System.out.println(count.join());
	}
}

class Counter extends RecursiveTask<Integer> {
	public static final int THRESHOLD = 1000;
	private double[] values;
	private int from;
	private int to;
	// 条件过滤器 接受拉姆达表达式
	private DoublePredicate filter;

	public Counter(double[] values, int from, int to, DoublePredicate filter) {
		super();
		this.values = values;
		this.from = from;
		this.to = to;
		this.filter = filter;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		if (to - from < THRESHOLD) {
			// 长小于阈值阈值 直接处理
			int count = 0;
			for (int i = from; i < to; i++) {
				if (filter.test(values[i]))
					count++;
			}
			return count;
		} else {
			int mid = (from + to) / 2;
			Counter first = new Counter(values, from, mid, filter);
			Counter second = new Counter(values, mid, to, filter);
			invokeAll(first, second);
			return first.join() + second.join();
		}
	}
}
