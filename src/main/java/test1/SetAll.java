package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SetAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 变长数组ArrayList(链表格式)遍历
		List<String> list = new ArrayList<String>();
		ArrayList li = new ArrayList();

		list.add("abc");
		list.add("fff");
		list.add("eee");
		list.add("ggg");

		String[] str = new String[list.size()];
		list.toArray(str);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String st = (String) iter.next();
			System.out.print(st + " ");

		}
		System.out.println();
		// 遍历Map
		// map中key可以是空值
		// key值唯一
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "abc");
		map.put(2, "ddd");
		map.put(3, "reee");
		//map.put(null, "gg0");

		// 编列Map
		Set<Integer> mapSet = map.keySet();
		for (int key : mapSet) {
			System.out.print(key + " " + map.get(key));
		}
		System.out.println();
		// 方法2
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, String> entry = it.next();
			System.out.print(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
		// 方法3
		for (Map.Entry<Integer, String> mapIt : map.entrySet()) {
			System.out.print(mapIt.getKey() + " " + mapIt.getValue());
		}
		// 只遍历value
		for (String str1 : map.values()) {
			// 输出
		}
		System.out.println();
		map.forEach((k, v) -> System.out.print(k + " " + v));

	}
}
