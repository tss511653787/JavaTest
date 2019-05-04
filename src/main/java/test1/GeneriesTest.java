/**
 * 
 */
package test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dell
 *
 */
public class GeneriesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> box1 = new Box<Integer>(50);
		Box<String> box2 = new Box<String>("BC");
		System.out.println(box1.get());
		System.out.println(box2.get());
		List<String> list = new ArrayList<String>();
		list.add("abc");
		List<Integer> intlist = new LinkedList<Integer>();
		intlist.add(50);
		// getdata(list);
		getData(intlist);

	}

	// 泛型作为输入
	public static <E> void PrintArray(E[] input) {
		for (E e : input) {
			System.out.print(e + " ");
		}
	}

	// 限定泛型范围
	public static <T extends Comparable<T>> T maxium(T x, T y, T z) {
		// 比价三者大小 返回max值
		T max = x;
		if (y.compareTo(max) > 0)
			max = y;
		if (z.compareTo(max) > 0)
			max = z;
		return max;
	}

	// 调用: maxium(3,4,5); maxium(0.23,0.3,50.5);
	public static void getData(List<? extends Number> data) {
		System.out.println(data.get(0));
	}

}

// 定义一个泛型类Box<T>
class Box<T> {
	// T作为泛型参数可以传值
	private T tip;

	public Box(T ta) {
		// TODO Auto-generated constructor stub
		tip = ta;
	}

	public T get() {
		return tip;
	}

}
