package test1;

import java.util.concurrent.Callable;

//实现Callable接口 实现call()方法
public class CallableFutureThreadTest implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		// /call方法实现
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
}
