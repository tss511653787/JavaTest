package ReView2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataOutPut {
	String a;
	static Scanner scanner = new Scanner(System.in);

	/*
	 * DataOutput的实现类输出的二进制编码格式
	 */
	public static void main(String[] args) throws IOException,
			InterruptedException {
		String filepath = "C:\\Users\\Administrator\\Desktop\\a.txt";
		OutputStream out = new FileOutputStream(new File(filepath));
		DataOutputStream dot = new DataOutputStream(out);
		dot.writeInt(10000);
		dot.close();
		DataOutPut o = new DataOutPut();
		DataOutPut.Inner.Print();
		LinkedHashMap<String, Inner> map = new LinkedHashMap<>();

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			// fast fail
			list.remove(1);
		}
	}

	// inner class
	static class Inner {
		static final String sss = "aa";
		String abc;

		public Inner(String abc) {
			super();
			this.abc = abc;
		}

		public static void Print() {
			System.out.println("static method" + sss);
		}
	}

}
