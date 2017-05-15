package test1;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vec = new Vector(3, 2);
		System.out.println(vec.size());
		System.out.println(vec.capacity());
		vec.addElement(1);
		vec.addElement(2);
		vec.addElement(3);
		vec.addElement(4);
		System.out.println(vec.capacity());
		vec.addElement("abc");
		System.out.println(vec);
		Enumeration enu = vec.elements();
		while (enu.hasMoreElements()) {
			System.out.print(enu.nextElement() + " ");
			// java Stack

		}
		Stack stack = new Stack();
		// 压栈
		stack.push("abc");
		stack.push(1);
		stack.push(0.25);
		stack.push('a');
		if (!stack.empty()) {
			System.out.println("非空栈");
		}
		System.out.println("栈顶为:" + stack.peek());
		// 出栈
		System.out.println("出:" + stack.pop());
		System.out.println("出:" + stack.pop());
		System.out.println("栈顶为:" + stack.peek());
		// 不保证顺序HashMaps
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("tss", 1);
		map.put("zmh", 2);
		map.put("lp", 3);
		// 构造键值key的迭代器
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str + " " + map.get(str));
		}

		// 保证顺序TreeMap,保证了key值的从小到大 key值如果是String类型则按字母排序
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] str = input.split(" ");
		int[] arrNum = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arrNum[i] = Integer.valueOf(str[i]).intValue();
		}
		Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < arrNum.length; i++) {
			treemap.put(arrNum[i], i);
		}
		Iterator<Integer> treeIter = treemap.keySet().iterator();
		while (treeIter.hasNext()) {
			int i = (int) treeIter.next();
			System.out.print(i + " ");

		}

	}
}
