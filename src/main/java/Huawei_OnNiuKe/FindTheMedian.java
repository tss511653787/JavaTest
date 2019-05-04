package Huawei_OnNiuKe;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * */

public class FindTheMedian {
	/*
	 * 思路：总数值是偶数 则进入小顶堆(先经过大顶对筛选) 总数值是奇数则进入大顶堆(先经过小顶堆筛选)
	 */
	private int count = 0;

	/*
	 * 定义大顶堆和小顶堆
	 */
	// ***默认的优先级队列是小顶堆***
	private Queue<Integer> minHeap = new PriorityQueue<Integer>();
	private Queue<Integer> maxHeap = new PriorityQueue<>(
			new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}

			});

	public void Insert(Integer num) {

		if (count % 2 == 0) {
			// 进入小顶堆
			maxHeap.offer(num);
			Integer out = maxHeap.poll();
			minHeap.offer(out);
		} else {
			// 进入大顶堆
			minHeap.offer(num);
			Integer out = minHeap.poll();
			maxHeap.offer(out);
		}
		count++;
	}

	// 中位数获取:排序后中间的两个数平均值
	public Double GetMedian() {
		if (count != 0) {
			if (count % 2 == 0) {
				return new Double(minHeap.poll() + maxHeap.poll())/2;
			} else {
				return new Double(minHeap.poll());
			}
		} else {
			return 0.0;
		}

	}

	public static void main(String[] args) {
		/*
		 * Test Main
		 */
		FindTheMedian t = new FindTheMedian();
		t.Insert(10);
		t.Insert(2);
		t.Insert(4);
		t.Insert(7);
		System.out.println(t.GetMedian());
	}
}
