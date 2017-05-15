package HuaWeiTest;

import java.util.Scanner;
import java.util.Stack;

public class HuaWei {
	public static String huawei1(String str) {
		String input = str;
		String regexStr = input.replaceAll("[^(A-Za-z)]", "");
		String res = regexStr.toLowerCase();
		return res;
	}

	public static int postfix(String input) {
		// 后缀表达式求职
		final char A = 10;
		final char B = 11;
		final char C = 12;
		final char D = 13;
		final char E = 14;
		final char F = 15;
		Stack<Integer> numStk = new Stack<Integer>();
		for (int i = 0; i < input.length(); i++) {
			// 编列输入的字符串
			char c = input.charAt(i);
			if (c == 'A') {
				numStk.push(10);

			} else if (c == 'B') {
				numStk.push(11);
			} else if (c == 'C') {
				numStk.push(12);
			} else if (c == 'D') {
				numStk.push(13);
			} else if (c == 'E') {
				numStk.push(14);
			} else if (c == 'F') {
				numStk.push(15);
			} else if (c == '+') {
				int last = numStk.pop();
				int first = numStk.pop();
				int res = first + last;
				numStk.push(res);

			} else if (c == '-') {
				int last = numStk.pop();
				int first = numStk.pop();
				int res = first - last;
				numStk.push(res);

			} else if (c == '*') {
				int last = numStk.pop();
				int first = numStk.pop();
				int res = first * last;
				numStk.push(res);
			} else {
				int num = Integer.parseInt(String.valueOf(c));
				numStk.push(num);
			}
		}
		int answer = 0;
		if (!numStk.isEmpty()) {
			answer = numStk.pop();
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		System.out.println(postfix(in));
	}
}
