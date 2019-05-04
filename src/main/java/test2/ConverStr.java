package test2;

import java.util.ArrayList;
import java.util.Collections;

public class ConverStr {
	public static String[] convert(String input) {
		// 字符串输入转变层数组
		if (input == null)
			return null;
		// 建立一个较大的数组
		// String[] anseer = new String[input.length()];
		ArrayList<String> answerList = new ArrayList<String>();
		// 遍历input
		for (int i = 0; i < input.length();) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-'
					|| input.charAt(i) == '*' || input.charAt(i) == '/'
					|| input.charAt(i) == '(' || input.charAt(i) == ')') {
				answerList.add(String.valueOf(input.charAt(i)));
				i++;
			} else {
				// 这个是数组或者是‘.’ 寻找末尾
				int end = searchEnd(input, i);
				answerList.add(input.substring(i, end));
				i = end;
			}
		}
		String[] answer = {};
		return answerList.toArray(answer);

	}

	public static int searchEnd(String inserch, int start) {
		int end = start;
		while (start != inserch.length()) {
			if (inserch.charAt(start) == '+' || inserch.charAt(start) == '-'
					|| inserch.charAt(start) == '*'
					|| inserch.charAt(start) == '/'
					|| inserch.charAt(start) == '('
					|| inserch.charAt(start) == ')') {
				end = start;
				break;
			} else {
				start++;
			}
		}
		if (start == inserch.length())
			return inserch.length();
		else {
			return end;
		}
	}

	public static void main(String[] args) {
		// 测试
		String In = "5.0+3.0*2.4+400";
		String[] res = convert(In);
		for (String str : res) {
			System.out.print(str + " ");
		}
	}
}
