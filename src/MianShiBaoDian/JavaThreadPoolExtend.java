package MianShiBaoDian;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaThreadPoolExtend {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// TODO Auto-generated method stub

		/*
		 * 控制任务组
		 */
		Callable<Integer> task = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				// 任务逻辑
				// 返回结果值int
				return 1;
			}

		};
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(
				executor);
		List<Callable<Integer>> taskList = new ArrayList<Callable<Integer>>();
		// task->taskList逻辑
		// 执行任务逻辑
		for (Callable<Integer> t : taskList) {
			service.submit(t);
		}
		// 查看每个task返回结果
		for (int i = 0; i < taskList.size(); i++) {
			int res = service.take().get();
		}
	}

}
