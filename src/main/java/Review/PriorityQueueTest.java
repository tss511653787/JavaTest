package Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 使用集合框架中的优先级队列对插入的对象进行排序
 * 堆实现
 * */
public class PriorityQueueTest {
	public static void main(String[] args) {
		// 使用默认构造器
		PriorityQueue<AObject> priQueue = new PriorityQueue<>();
		priQueue.add(new AObject(1, "tss"));
		priQueue.add(new AObject(5, "zzz"));
		priQueue.add(new AObject(2, "kkk"));
		priQueue.add(new AObject(10, "ppp"));
		// 常规去遍历队列
		for (AObject out : priQueue) {
			System.out.println(out);
		}
		System.out.println("-----------");
		// 出队列遍历队列
		while (!priQueue.isEmpty()) {
			if (priQueue.peek() != null) {
				AObject out = priQueue.poll();
				System.out.println(out);
			}
		}
		// Map遍历方法
		Map<Integer, String> map = new HashMap<>();
		// 1
		Iterator<Entry<Integer, String>> map_it = map.entrySet().iterator();
		while (map_it.hasNext()) {
			// code
		}
		// 2
		Set<Entry<Integer, String>> map_set = map.entrySet();
		for (Entry<Integer, String> en : map_set) {
			// code
		}
		// 3
		Set<Integer> key_set = map.keySet();
		for (Integer in : key_set) {
			String value = map.get(in);
		}
		// 4
		Collection<String> values = map.values();
		// 5 推荐
		map.forEach((k, v) -> System.out.println(k + " " + v));
		// 不可修改的视图
		Set<String> rowSet = new HashSet<>();
		// 包装
		Set<String> unModifySet = Collections.unmodifiableSet(rowSet);
	}
}

class AObject implements Comparable<AObject> {
	private int id;
	private String name;

	public AObject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + name;
	}

	@Override
	public int compareTo(AObject o) {
		// TODO Auto-generated method stub
		return (this.getId() - o.getId());
	}

}
