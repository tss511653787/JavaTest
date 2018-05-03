package test2;

import java.util.Scanner;

//3.10华为笔试

public class test1 {
	public static void main(String[] args) {
		//7进制转10进制
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		int numDecimal = 0;

		String numStr = String.valueOf(str);
		for (int i = numStr.length() - 1, count = 0; i >= 0; i--) {
			numDecimal += Integer.parseInt(String.valueOf(numStr.charAt(i)))
					* Math.pow(7, count++);
		}
		System.out.println(numDecimal);
	}
}
