package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

//实现Callable接口 实现call()方法
public class CallableFutureThreadTest implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		// /call方法实现
		int count = 0;
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 100; i++) {
			Callable<Integer> ca = new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName());
					return 1;
				}
			};
			FutureTask<Integer> fu = new FutureTask<>(ca);
			Thread t = new Thread(fu);
			list.add(fu);
			t.start();
		}
		for (Future<Integer> f : list) {
			count += f.get();
		}
		return count;
	}

}
