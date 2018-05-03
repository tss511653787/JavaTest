package ReView2;

public class FinallyTest {
	public static void main(String[] args) {
		System.out.println(fun1());
	}

	public static String fun1() {
		int a = 10;
		int b = 0;
		try {
			try {
				int c = a / b;
				System.out.println("继续执行？");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("内层catch被执行");
			} finally {
				System.out.println("内层finally被执行");
				return "内层return";
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("最外层catch被执行");
		} finally {
			System.out.println("最外层finally被执行");
			return "外层return";
		}
	}

}
