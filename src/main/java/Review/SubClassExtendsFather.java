package Review;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SubClassExtendsFather {
	/*
	 * 使用反射查看子类继承的情况
	 */
	public static void main(String[] args) {
		Class sonclass = FatherClass.class;
		System.out.println("子类继承的成员：");
		Field[] sonFields = sonclass.getDeclaredFields();
		for (Field field : sonFields) {
			//System.out.println(field.getModifiers() + " " + field.getName());
			System.out.println(field.toString());
		}
		System.out.println("子类继承的方法：");
		Method[] sonMethods = sonclass.getDeclaredMethods();
		for (Method m : sonMethods) {
			System.out.println(m.getModifiers() + " " + m.getName());
		}
	}
}

class FatherClass {
	static String str = "abc";
	private static String str_p = "kkk";

	public void methodA() {
		// code
	}

	private void methodB() {
		// code
	}

}

/*
 * 子类继承了父类的全部方法 和成员 只是私有的方法或成员不能调用
 */
class sonClass extends FatherClass {

}
