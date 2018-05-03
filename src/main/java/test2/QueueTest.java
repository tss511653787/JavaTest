package test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.sun.org.apache.regexp.internal.recompile;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Character> queue = new LinkedList<Character>();
		// 队列要尽量避免使用add方法 使用offer()输入 poll()输出 peek()查看队首
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		System.out.println(isPalindrome(in));
	}

	// 判断输入的字符串是不是回文
	public static boolean isPalindrome(String input) {
		if (input == null)
			return false;
		Stack<Character> stk = new Stack<Character>();
		Queue<Character> que = new LinkedList<Character>();
		for (int j = 0; j < input.length(); j++) {
			stk.push(Character.toUpperCase(input.charAt(j)));
			que.offer(Character.toUpperCase(input.charAt(j)));
		}
		char[] stkOut = new char[input.length()];
		char[] queOut = new char[input.length()];
		int i = 0;
		while (!stk.isEmpty()) {
			stkOut[i] = stk.pop();
			i++;
		}
		for (char c : stkOut) {
			System.out.print(c + "-");
		}
		i = 0;
		while (!que.isEmpty()) {
			queOut[i] = que.poll();
			i++;
		}
		System.out.println();
		for (char c : queOut) {
			System.out.print(c + "-");
		}
		return equalsForChar(stkOut, queOut);
	}

	public static boolean equalsForChar(char[] a, char[] b) {
		int i = 0;
		for (; i < a.length; i++) {
			if (a[i] == b[i]) {
				continue;
			} else {
				break;
			}
		}
		if (i == a.length)
			return true;
		else
			return false;
	}
}
