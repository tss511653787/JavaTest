package QuNai;

import java.util.Scanner;

public class AZjinzhi {
	public static void main(String[] args) {
		// 简历一个对应的数组
		String abc = "abcdefghijklmnopqrstuvwxyz";
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String input = scan.next();
			int[] num = new int[input.length()];
			for (int i = 0; i < input.length(); i++) {
				num[i] = Integer.valueOf(abc.indexOf(input.charAt(i)));
			}
			int answer = 0;
			for (int j = 0; j < num.length; j++) {
				answer += (int) Math.pow(26, num.length - 1 - j) * num[j];
			}
			System.out.println(answer);
		}
	}
}
