package Huawei_OnNiuKe;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Inputdata {

	public static String Input() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	// 四舍五入浮点数
	public static void main(String[] args) {
		SortStr();

	}

	public static int Caculate(float in) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#");
		String res = df.format(in);
		return Integer.valueOf(res);
	}

	public static void KVsum() {
		Scanner scan = new Scanner(System.in);
		int sum = Integer.valueOf(scan.nextLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		while (sum != 0) {
			String[] in = scan.nextLine().split(" ");
			int key = Integer.parseInt(in[0]);
			int value = Integer.parseInt(in[1]);
			if (map.containsKey(key)) {
				int oldValue = map.get(key);
				map.put(key, oldValue + value);
			} else {
				map.put(key, value);
			}
			sum--;
		}
		Set<Integer> mapSet = map.keySet();
		for (int k : mapSet) {
			System.out.println(k + " " + map.get(k));
		}
	}

	/*
	 * 输入一个int型整数，按照从右向左的阅读顺序， 返回一个不含重复数字的新的整数
	 */
	public static void DictinctNum() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		LinkedHashSet<Character> CharSet = new LinkedHashSet<>();
		for (int i = input.length() - 1; i >= 0; i--) {
			CharSet.add(input.charAt(i));
		}
		StringBuilder temp = new StringBuilder();
		for (Character c : CharSet) {
			temp.append(c);
		}
		System.out.print(Integer.parseInt(temp.toString()));
	}

	/*
	 * 编写一个函数，计算字符串中含有的不同字符的个数。 字符在ACSII码范围内(0~127)。不在范围内的不作统计。
	 */
	public static void Sumdictinct() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}
		System.out.print(set.size());
	}

	/*
	 * 逆序输出
	 */
	public static void Reverse() {
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		StringBuilder str = new StringBuilder(in);
		System.out.print(str.reverse().toString());
	}

	/*
	 * 句子反转
	 */
	public static String reverse(String sentence) {
		String[] in = sentence.split(" ");
		StringBuilder temp = new StringBuilder();
		for (int i = in.length - 1; i >= 0; i--) {
			if (i == 0) {
				temp.append(in[i]);
			} else {
				temp.append(in[i]);
				temp.append(" ");
			}
		}
		return temp.toString();
	}

	/*
	 * 给定n个字符串，请对n个字符串按照字典序排列
	 */
	public static void SortStr() {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		ArrayList<String> list = new ArrayList<>();
		while (num > 0) {
			String in = scan.nextLine();
			list.add(in);
			num--;
		}
		Collections.sort(list);
		int count = 0;
		for (String out : list) {
			if (count == list.size() - 1) {
				System.out.print(out);
			} else {
				System.out.print(out);
				System.out.println();
				count++;
			}
		}
	}
}
