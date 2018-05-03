package Test4;

import java.util.Scanner;
import java.util.logging.Logger;

public class AssertTest {
	// 使用java中的断言机制实验
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println(ssertTo(1));
		final Logger mylogger = Logger.getLogger("Test4.AssertTest");
		
		
	}

	public static boolean ssertTo(int a) {
		if (a > 0) {
			// 检查是否等于1
			assert a != 1;
			return true;
		} else {
			return false;
		}
	}
}
