package MianShiBaoDian;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		// Hashtable<String, Integer> table = new Hashtable<>();
		// go(new Mybase());
		/*
		 * 
		 * */
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("bbb");
		list.add("abc");
		list.add(1, "ddd");
		// 使用listiterato在中间插入
		// ListIterator<String> it = list.listIterator();
		// while (it.hasNext()) {
		// String value = it.next();
		// if (value.equals("bbb")) {
		// it.previous();
		// break;
		// }
		// }
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> synMap = Collections.synchronizedMap(map);
		list.sort(Comparator.reverseOrder());
		// 还有这种操作？
		String[] res = list.toArray(new String[0]);
		for (String str : res) {
			System.out.print(str + " ");
		}
		//
		ThreadLocal<SimpleDateFormat> dataformat = ThreadLocal
				.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
		String nowTime = dataformat.get().format(new Date());
		System.out.println(nowTime);
		// 阻塞队列
		Queue<String> linkblkqu = new LinkedBlockingQueue<>();
		Queue<Object> arrayblqu = new ArrayBlockingQueue<>(10);
		Queue<Object> problqu = new PriorityBlockingQueue<>();
		Map<String, Long> concurrMap = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Long> conmap = new ConcurrentHashMap<>();
		conmap.mappingCount();


	}

	static void go(Base b) {
		// TODO Auto-generated method stub
		b.add(8);
	}
}

// 这个有点意思哦
class Base {
	int i;

	Base() {
		add(1);
		System.out.println(i);
	}

	void add(int v) {
		// TODO Auto-generated method stub
		i += v;
		System.out.println(i);
	}

	public void print() {
		System.out.println(i);
	}
}

class Mybase extends Base {
	Mybase() {
		add(2);
	}

	void add(int v) {
		i = v * 2;
		System.out.println(i);
	}
}