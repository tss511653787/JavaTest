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

	@SuppressWarnings("unchecked")
	public void setFirst(Object object) {
		// this.first = (T) object;
		// 使用桥方法解决
		this.setFirst((T) object);
	}

	public T getSecond() {
		return second;
	}

	@SuppressWarnings("unchecked")
	public void setSecond(Object temp) {
		this.setSecond((T) temp);
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
	// 泛型方法中存在数组的时候会惊醒检查
	// 使用忽略检查可以解决异常
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Comparable> T findmin(T[] arr) {
		T min = arr[0];
		for (T c : arr) {
			if (c.compareTo(min) > 0) {
				min = c;
			}
		}
		return min;
	}

	// 编写一个swap交换first和second值
	public static void swap(genericTest<?, ?> t) {
		swapHelper(t);
	}

	public static <T> void swapHelper(genericTest<?, ?> t) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T temp = (T) t.getFirst();
		t.setFirst(t.getSecond());
		t.setSecond(temp);
	}

	public static void main(String[] args) {

	}
}
