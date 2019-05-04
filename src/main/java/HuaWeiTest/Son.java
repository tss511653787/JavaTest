package HuaWeiTest;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Father {
	String name = "ty";

	// 父类找中没有显示的空参数构造方法
	public Father(String name) {
		this.name = name;
	}

}

public class Son extends Father {
	String Sonname = "sss";
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Son(String sonname) {
		super(sonname);
		Sonname = sonname;
	}

	public String getSonname() {
		return Sonname;
	}

	public static void main(String[] args) {
		Son son = new Son("tss");
		son.age = 10;
		Son son2 = new Son("fff");
		son2.age = 16;
		Son son3 = new Son("oldBR");
		son3.age = 40;
		System.out.println(son.Sonname);
		// arratdeque初始值是16
		Queue<Integer> qu = new ArrayDeque<>(500);
		qu.offer(1);
		qu.offer(2);
		qu.offer(3);
		Iterator<Integer> it = qu.iterator();
		it.forEachRemaining(num -> System.out.print(num + " "));
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		SonCom com = son.new SonCom();
		TreeSet<Son> sortSet = new TreeSet<Son>(com);
		sortSet.add(son);
		sortSet.add(son2);
		sortSet.add(son3);
		for (Son outson : sortSet) {
			System.out.print(outson.getSonname() + " " + outson.getAge());
		}
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("c", 1);
		map1.put("b", 2);
		map1.put("a", 3);
		Map<String, Integer> treemap = new TreeMap<>(map1);
		System.out.println();
		treemap.forEach((k, v) -> System.out.println(k + " " + v));
		Iterator<Entry<String, Integer>> mapit = treemap.entrySet().iterator();
		while (mapit.hasNext()) {
			Entry<String, Integer> out = mapit.next();
			System.out.println(out.getKey() + " " + out.getValue());
		}
		Set<String> a= map1.keySet();
	}

	class SonCom implements Comparator<Son> {

		@Override
		public int compare(Son o1, Son o2) {
			// 降序年龄排列
			// TODO Auto-generated method stub
			return o2.getAge() - o1.getAge();
		}
	}
}
