package HuaweiOnline;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LastWordLenth {
	/*
	 * 计算字符串最后一个单词的长度，单词以空格隔开 Scanner scan = new Scanner(System.in); String
	 * input = scan.nextLine();
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
			} else {
				// 是字母则转换为大写
				c = Character.toUpperCase(c);
			}
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				// defult 0
				map.put(c, 1);
			}
		}
		String key = scan.nextLine();
		char findC = Character.toUpperCase(key.charAt(0));
		if (map.containsKey(findC)) {
			System.out.print(map.get(findC));
		} else {
			System.out.print(0);
		}
	}

}
