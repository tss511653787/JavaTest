/**
 * 
 */
package MianShiBaoDian;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Administrator
 *
 */
// 定义一个泛型类
public class genericTest<T, U> {
	private T first;
	private T second;
	private U third;

	private genericTest(T first, T second, U third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}

	// getter setter
	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	public U getThird() {
		return third;
	}

	public void setThird(U third) {
		this.third = third;
	}

	// 定义一个泛型方法
	public static <T> T getMiddle(T[] array) {
		return array[array.length / 2];
	}

	// 对变量的限定
	@SuppressWarnings("unchecked")
	public static <T extends Comparable> T findmin(T[] arr) {
		T min = arr[0];
		for (T c : arr) {
			if (c.compareTo(min) > 0) {
				min = c;
			}
		}
		return min;
	}

	public static void main(String[] args) {

	}
}
