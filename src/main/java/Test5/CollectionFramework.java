package Test5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.stream.Stream;

public class CollectionFramework {
	public static void main(String[] args) throws CloneNotSupportedException,
			InterruptedException {
		String[] arrStr = { "abc", "ccc", "sss" };
		List<String> listStr = Arrays.asList(arrStr);
		List<String> subList = listStr.subList(0, 1);
		List<String> schList = Collections.synchronizedList(listStr);
		listStr.sort(Comparator.reverseOrder());
		// collection->Array
		String[] res = listStr.toArray(new String[0]);
		// clone
		CollectionFramework sc = new CollectionFramework();
		Manager m1 = sc.new Manager("tss", 10, "fff", "5000");
		Manager m2 = m1.clone();
		System.out.println(m1);
		Thread.sleep(5000);
		System.out.println(m2);

	}

	public static <T extends Comparable> T max(Collection<T> c) {
		// find max
		T max;
		if (c == null) {
			return null;
		}
		Iterator<T> iter = c.iterator();
		max = iter.next();
		while (iter.hasNext()) {
			if (iter.next().compareTo(max) > 0) {
				max = iter.next();
			}
		}
		return max;
	}

	// 接口的类练习
	// clone
	class Employee {
		String name;
		int age;
		String id;

		public Employee(String name) {
			this.name = name;
		}

		public Employee(String name, int age, String id) {
			this.name = name;
			this.age = age;
			this.id = id;
		}
	}

	// 必须有标记接口才能调用clone方法
	class Manager extends Employee implements Cloneable {
		String salary;
		Date data;
		String time;

		public Manager(String name, int age, String id, String salary) {
			super(name, age, id);
			this.salary = salary;
			data = new Date();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd,HH:mm:ss");
			time = format.format(data);
		}

		// 现在想重写继承的clone方法
		@Override
		protected Manager clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			Manager cloneManager = (Manager) super.clone();
			// 深度克隆使得副本的时间戳是当前时间而不是和对象一样
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd,HH:mm:ss");
			cloneManager.time = format.format(new Date());
			return cloneManager;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + " " + age + " " + id + " " + salary + " " + time;
		}
	}

}
