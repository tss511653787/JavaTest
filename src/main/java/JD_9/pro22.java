package JD_9;

import java.util.Scanner;
import java.util.Stack;

public class pro22 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.next();
			long sum = 1;
			long res = 1;
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				if (!stack.isEmpty()) {
					if (stack.peek() == '(' && str.charAt(i) == ')') {
						stack.pop();
						sum--;

					} else {
						stack.push(str.charAt(i));
						sum++;
						res = res * sum;
					}
				} else {
					stack.push(str.charAt(i));
					sum = 1;

				}
			}
			System.out.println(res % 1000000007);
		}
	}
}
