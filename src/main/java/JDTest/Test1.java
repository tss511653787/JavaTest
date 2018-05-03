package JDTest;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		// 警察和小偷
		//唉 非常遗憾 就差一点点就可以AC了 怪自己吧
		Scanner scan = new Scanner(System.in);
		int len = Integer.valueOf(scan.nextLine());
		char[] input = new char[len];
		String inStr = scan.nextLine();
		// 赋值
		for (int i = 0; i < inStr.length(); i++) {
			input[i] = inStr.charAt(i);
		}
		// 判断
		int thiefCount = 0;
		for (int i = 0; i < len; i++) {
			if (input[i] >= '1' && input[i] <= '9') {
				// 是警察
				int fanwei = Integer.valueOf(String.valueOf(input[i]));
				// 向前判断
				for (int j = i; (j >= i - fanwei) && (j >= 0); j--) {
					if (input[j] == 'X') {
						thiefCount++;
						input[j] = '#';
					}
				}
				// 向后判断
				for (int k = i; (k <= i + fanwei) && (k <= len); k++) {
					if (input[k] == 'X') {
						thiefCount++;
						input[k] = '#';
					}
				}
			}
		}
		System.out.print(thiefCount);
	}
}
