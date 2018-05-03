package Review;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/*
 * 有些程序员说的嵌套类实际就是静态内部类
 * */
public class NestedClass {
	private String id;

	// 定义一个静态内部类
	static class InnerClass {
		private String name;
		private int age;

		public InnerClass(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
	}

	public static void main(String[] args) {
		// NestedClass obj = new NestedClass();
		InnerClass in = new InnerClass("abc", 5);
	}

	public static void out(String path) throws FileNotFoundException   {
		File file = new File(path);
		InputStream in = new FileInputStream(file);
	}
}
