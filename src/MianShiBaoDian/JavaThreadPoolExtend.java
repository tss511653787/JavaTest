package MianShiBaoDian;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JavaThreadPoolExtend {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// TODO Auto-generated method stub

		/*
		 * 控制任务组 任务就是提交一组Callable任务
		 */
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Callable<Integer> task = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				// 任务逻辑
				// 返回结果值int
				return 1;
			}

		};
		// 构建一个callable任务组
		List<Callable<Integer>> taskList = new ArrayList<>();
		taskList.add(task);
		taskList.add(task);
		taskList.add(task);
		taskList.add(task);
		// 传统的提交方法调用executor.invokeAll直接全部提交
		// 缺点是得到的一组Future无法知道那个是先完成的
		List<Future<Integer>> futureRes = executor.invokeAll(taskList);
		for (Future<Integer> f : futureRes) {
			System.out.println(f.get());
		}

		// ExecutorCompletionService 来封装执行器 这里就是线城池 会实按照任务执行的顺序排序
		ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(
				executor);
		// task->taskList逻辑
		// 执行任务逻辑
		for (Callable<Integer> t : taskList) {
			service.submit(t);
		}
		// 查看每个task返回结果 这样是task的执行顺序结果
		for (int i = 0; i < taskList.size(); i++) {
			int res = service.take().get();
		}
	}

}
