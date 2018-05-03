package test2;

import java.util.Scanner;
import java.util.Stack;

public class IntStack {
	public static void main(String[] args) {
		String in = "abcd";
		System.out.println(reverseStr(in));
		String in2 = "{(";
		System.out.println(isBalanced(in2));

	}

	public static String reverseStr(String input) {
		char[] arrStr = input.toCharArray();
		Stack<Character> stk = new Stack<Character>();
		for (char c : arrStr) {
			stk.push(c);
		}
		StringBuffer output = new StringBuffer();
		while (!stk.isEmpty()) {
			output.append(stk.pop());
		}
		return output.toString();
	}

	// 括号的平衡
	public static boolean isBalanced(String input) {
		// ()[]{}
		final char small_left = '(';
		final char small_right = ')';
		final char nomal_left = '[';
		final char nomal_right = ']';
		final char big_left = '{';
		final char big_right = '}';

		int len = input.length();
		boolean flag = true;
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < len && flag; i++) {
			switch (input.charAt(i)) {
			// 匹配到左面括号则压栈
			case small_left:
			case nomal_left:
			case big_left:
				stk.push(input.charAt(i));
				break;
			case small_right:
				if (stk.isEmpty() || (stk.pop() != small_left))
					flag = false;
				break;
			case nomal_right:
				if (stk.isEmpty() || (stk.pop() != nomal_left))
					flag = false;
				break;
			case big_right:
				if (stk.isEmpty() || (stk.pop() != big_left))
					flag = false;
				break;
			}
		}
		return (stk.isEmpty() && flag);

	}
}
