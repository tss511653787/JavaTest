package Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ReflectReviw {
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			FileNotFoundException {
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		int[] newArr = (int[]) ArrcopyOfTest(arr, 5);
		ReflectReviw a = new ReflectReviw();
		System.out.println((int) invokeMethod(a, "testMethod", 1));

		WC("C:\\Users\\Administrator\\Desktop\\a.txt");

	}

	// 待调用方法
	public static int testMethod(int a) {
		return a + 1;
	}

	// 利用反射对数组进行扩展的GoodCopy方法F
	// 加入数组(任何对象)已满 扩充到newLength长度
	public static Object ArrcopyOfTest(Object a, int newLength) {
		Class c = a.getClass();
		if (!c.isArray()) {
			return null;
		}
		Class contextType = c.getComponentType();
		int length = Array.getLength(a);
		Object newArr = Array.newInstance(contextType, newLength);
		System.arraycopy(a, 0, newArr, 0, Math.min(length, newLength));
		return newArr;
	}

	/*
	 * 使用反射实现调用任意方法 Java中没有指针的概念 所以想获得方法的指针 类是获得方法的Method引用
	 */
	public static Object invokeMethod(Object object, String methodName,
			Object args) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Method m = object.getClass().getMethod(methodName, int.class);
		return m.invoke(null, args);
	}

	public static void WC(String filepath) throws FileNotFoundException {
		File file = new File(filepath);
		Scanner scan = new Scanner(file);
		Map<String, Integer> map = new HashMap<>();
		while (scan.hasNext()) {
			String in = scan.next();
			map.put(in, map.getOrDefault(in, 0) + 1);
		}
		List<Entry<String, Integer>> entrylist = new ArrayList<>(map.entrySet());
		Collections.sort(entrylist, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return -(o1.getValue() - o2.getValue());
			}

		});
		entrylist.forEach(entry -> System.out.println(entry.getKey() + " "
				+ entry.getValue()));
	}
}
