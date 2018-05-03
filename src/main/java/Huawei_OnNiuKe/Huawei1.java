package Huawei_OnNiuKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Huawei1 {
	public static void main(String[] args) {
		SumOFOneBinaryNum();
	}

	public static void MingMing() {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		Set<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < len; i++) {
			treeSet.add(scan.nextInt());
		}
		for (Integer j : treeSet) {
			System.out.println(j);
		}
	}

	public static void StringSplit() {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(",");
		int num = Integer.valueOf(input[0]);
		int splen = Integer.valueOf(input[1]);
		ArrayList<String> list = new ArrayList<>();
		while (num != 0) {
			String in = scan.nextLine();
			if (in.length() == 0) {
				num--;
				continue;
			}
			if (in.length() < splen) {
				int insertZero = splen - in.length();
				StringBuilder answer = new StringBuilder();
				answer.append(in);
				for (int i = 0; i < insertZero; i++) {
					answer.append("0");
				}
				list.add(answer.toString());
			} else if (in.length() > splen) {
				int numS = in.length() / splen;
				int lastlen = in.length() % splen;
				for (int i = 0, j = 0; i < numS; i++) {
					StringBuilder answer = new StringBuilder();
					answer.append(in.substring(j, j + splen));
					list.add(answer.toString());
					j = j + splen;
				}
				String last = in.substring(numS * splen);
				StringBuilder answer = new StringBuilder();
				answer.append(last);
				for (int i = 0; i < splen - lastlen; i++) {
					answer.append("0");
				}
				list.add(answer.toString());
			} else {
				// 等于splen情况
				list.add(in);
			}
			num--;
		}
		for (String str : list) {
			System.out.println(str);
		}

	}

	public static void GooodSplitString() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			if (str.length() % 8 != 0) {
				str = str + "00000000";
			}
			while (str.length() >= 8) {
				System.out.println(str.substring(0, 8));
				str = str.substring(8);
			}
		}
	}

	public static void ChangeToTen() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String in = scan.nextLine();
			String num = in.substring(2);
			int sum = 0;
			for (int i = 0; i < num.length(); i++) {
				int n;
				if (num.charAt(i) == 'A') {
					n = 10;
				} else if (num.charAt(i) == 'B') {
					n = 11;
				} else if (num.charAt(i) == 'C') {
					n = 12;
				} else if (num.charAt(i) == 'D') {
					n = 13;
				} else if (num.charAt(i) == 'E') {
					n = 14;
				} else if (num.charAt(i) == 'F') {
					n = 15;
				} else {
					n = Integer.valueOf(String.valueOf(num.charAt(i)));
				}
				sum += Math.pow(16, num.length() - 1 - i) * n;
			}
			System.out.println(sum);
		}
	}

	/*
	 * 将整数分解成质数因子乘积形式 180=2*2*3*3*5
	 */
	public static String getResult(long ulDataInput) {
		List<Integer> answer = new ArrayList<>();
		int start = 2;
		while (ulDataInput != 1) {
			if (ulDataInput % start == 0) {
				ulDataInput = ulDataInput / start;
				answer.add(start);
			} else {
				start++;
				while (!findZhiShu(start)) {
					start++;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (Integer s : answer) {
			res.append(s + " ");
		}
		return res.toString();
	}

	public static boolean findZhiShu(int i) {
		if (i == 1 || i == 2) {
			return true;
		} else {
			int j = 2;
			for (; j <= i / 2; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (j > i / 2) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void SumOFOneBinaryNum() {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		String res = Integer.toBinaryString(input);
		System.out.println(res);
		int count = 0;
		for (int i = 0; i < res.length(); i++) {
			if (res.charAt(i) == '1') {
				count++;
			}
		}
		System.out.print(count);
	}
}
