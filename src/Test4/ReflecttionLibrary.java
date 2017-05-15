package Test4;

import java.io.EOFException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
import Test5.InnerClassTest;

import test3.BTNode;

//程序设计 使用静态反射类输出一个类的全部信息

public class ReflecttionLibrary {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, EOFException {
		// TODO Auto-generated method stub
		// int[] arr = { 1, 2, 3, 4, 5, 6 };
		// int[] newarr = (int[]) goodCopy(arr, arr.length);
		// for (int i : newarr) {
		// System.out.print(i + " ");
		// }
		DiscribeAClass();

	}

	public static void DiscribeAClass() throws ClassNotFoundException {
		System.out.println("Please in put a ClassNama:");
		Scanner scan = new Scanner(System.in);
		String className = "";
		if (scan.hasNextLine()) {
			className = scan.nextLine();
		}
		Class cl = Class.forName(className);
		System.out.println(cl.getName());
		System.err.println("{");
		System.out.println();
		// 首先输出这个类的全部对象实例
		Field[] f = cl.getDeclaredFields();
		for (Field field : f) {
			System.out.println(field.toString());
		}
		// 输出这个类的全部构造方法
		Constructor[] con1 = cl.getConstructors();
		for (Constructor constructor : con1) {
			System.out.println(constructor.toString());
		}
		System.out.println();
		// 最后输出这个类的方法和继承来的方法
		Method[] m1 = cl.getMethods();
		for (Method method : m1) {
			System.out.println(method.toString());
		}
		System.out.println("}");
	}

	// 编写一个复制泛型数组的类
	public static Object goodCopy(Object arr, int length) {
		Class c = arr.getClass();
		if (!c.isArray()) {
			return null;
		}
		Class componentype = c.getComponentType();
		Object newArr = Array.newInstance(componentype, length);
		// 复制元素到新的数组
		System.arraycopy(arr, 0, newArr, 0, length);
		return newArr;
	}

}
