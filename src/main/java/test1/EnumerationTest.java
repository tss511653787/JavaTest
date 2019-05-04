package test1;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 定义一个枚举类型
		Enumeration days;
		Vector vec = new Vector(5);
		vec.add("a");
		vec.add("b");
		vec.add("c");
		vec.add("d");
		vec.add("e");
		days = vec.elements();
		while (days.hasMoreElements()) {
			System.out.println(days.nextElement());
		}
		

	}

}
