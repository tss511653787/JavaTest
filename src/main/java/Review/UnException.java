package Review;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 泛型类编程可以使得一个编译器取消对受查类异常的检查
 * 将受查类异常转化为非受查类异常
 * */
public class UnException {
	@SuppressWarnings("unchecked")
	public static <T extends Throwable> void thowAs(Throwable e) throws T {
		// 转成泛型T类型
		throw (T) e;
	}

	public static void main(String[] args) {

		new Block() {

			@Override
			public void body() throws Exception {
				// TODO Auto-generated method stub
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(new File("path"));
				while (scan.hasNext()) {
					String in = scan.nextLine();
					System.out.println(in);
				}
			}
		}.toThread().start();
	}

}

abstract class Block {
	public abstract void body() throws Exception;

	public Thread toThread() {
		return new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					body();
				} catch (Throwable e) {
					// TODO: handle exception
					UnException.<RuntimeException> thowAs(e);
				}
			}

		};
	}
}
