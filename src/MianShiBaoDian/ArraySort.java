package MianShiBaoDian;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySort {
	public static void main(String[] args) {
		A[] arrayA = new A[10];
		int i = 0;
		for (int j = 0; j < 10; j++) {
			arrayA[j] = new A(++i);
		}
		List<A> listA = Arrays.asList(arrayA);
		listA.forEach(x -> System.out.print(x.getId() + " "));
		// ***sort里面可以传lambda表达式 这个很方便 就不用实现接口而写一个内部类了
		listA.sort((x, y) -> y.id - x.id);
		Collections.sort(listA, (x, y) -> y.id - x.id);
		listA.forEach(x -> System.out.print(x.getId() + " "));
	}

}

class A {
	int id;

	public int getId() {
		return id;
	}

	public A(int id) {
		super();
		this.id = id;
	}

}
