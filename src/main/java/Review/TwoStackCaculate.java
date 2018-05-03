package Review;

import java.util.Scanner;
import java.util.Stack;

/*
 * 两个站实现中缀表达式求值
 * */

public class TwoStackCaculate {
	/*
	 * 定义数字栈和符号栈
	 */

	public static void main(String[] args) {
		Stack<Double> numStk = new Stack<>();
		Stack<Character> calStk = new Stack<>();
		calStk.push('#');
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		for (int i = 0; i < in.length();) {
			try {
				// 一个位数
				String num = FindNum(in, i);
				double n = Double.parseDouble(String.valueOf(num));
				numStk.push(n);
				i = i + num.length();
			} catch (Exception e) {
				// TODO: handle exception
				char c = in.charAt(i);
				if (Compare(c, calStk.peek())) {
					calStk.push(c);
					i++;
				} else {
					// 符号出栈计算
					if (calStk.peek() == '#') {
						// no code
					} else {
						// 后出栈的是第一个数
						double b = numStk.pop();
						double a = numStk.pop();
						char col = calStk.pop();
						double res = Caculate(a, b, col);
						numStk.push(res);
						// i--;
					}
				}
			}
		}
		while (calStk.peek() != '#') {
			double b = numStk.pop();
			double a = numStk.pop();
			char col = calStk.pop();
			double res = Caculate(a, b, col);
			numStk.push(res);
		}
		System.out.println(numStk.pop());
	}

	/*
	 * find complete Number
	 */
	private static String FindNum(String in, int i) {
		// TODO Auto-generated method stub
		StringBuilder temp = new StringBuilder();
		for (int j = i; j < in.length(); j++) {
			if ((in.charAt(j) >= '0' && in.charAt(j) <= '9')
					|| in.charAt(j) == '.') {
				temp.append(in.charAt(j));
			} else {
				break;
			}
		}
		return temp.toString();
	}

	private static double Caculate(double a, double b, char col) {
		// TODO Auto-generated method stub
		if (col == '+') {
			return a + b;
		} else if (col == '-') {
			return a - b;
		} else if (col == '*') {
			return a * b;
		} else {
			return (a / b);
		}
	}

	private static boolean Compare(char c, Character peek) {
		// TODO Auto-generated method stub
		/*
		 * c优先级大则返回true 否则返回flase
		 */
		if (peek.equals('#')) {
			return true;
		} else if ((c == '*' || c == '/')
				&& (peek.equals('+') || peek.equals('-'))) {
			return true;
		} else {
			return false;
		}
	}

}
