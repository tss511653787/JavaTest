package ReView2;

public class CatchException {
	private static void test(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			try {
				if (arr[i] % 2 == 0) {
					throw new NullPointerException();
				} else {
					System.out.print(i);
				}
			} finally {
				System.out.print("e");
			}
		}
	}

	public static void main(String[] args) {
		try {
			test(new int[] { 0, 1, 2, 3, 4, 5 });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("has catched");
			e.printStackTrace();
		}
		Test test = null;
		// 这里有一个警告：hello()应该以静态形式访问 但是test这个空对象仍然可以引用的static方法
		test.hello();
	}
}

class Test {
	public static void hello() {
		System.out.println("hello");
	}
}
