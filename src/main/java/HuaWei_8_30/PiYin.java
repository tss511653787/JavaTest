package HuaWei_8_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PiYin {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String in = scanner.nextLine();
		int len = in.length();
		List<String> list = new ArrayList<String>();
		int j = 0;
		// initail
		for (int i = 0; i < len; i++) {
			if (in.charAt(i) >= 'A' && in.charAt(i) <= 'Z') {
				StringBuilder temp = new StringBuilder();
				if (i == len - 1) {
					temp.append(in.charAt(i));
					break;
				} else {
					temp.append(in.charAt(i));
					j = i + 1;
					while (j < len && in.charAt(j) >= 'a'
							&& in.charAt(j) <= 'z') {
						temp.append(in.charAt(j));
						j++;
					}
				}
				list.add(temp.toString());
			}
		}
		if (list.size() == 0 || list.size() == 1
				&& list.get(0).equals("Double")) {
			System.out.print("ERROR");
		}
		// 正向
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("Yi", "One");
		map1.put("Er", "Two");
		map1.put("San", "Three");
		map1.put("Si", "Four");
		map1.put("Wu", "Five");
		map1.put("Liu", "Six");
		map1.put("Qi", "Seven");
		map1.put("Ba", "Eight");
		map1.put("Jiu", "Nine");
		map1.put("Ling", "Zero");
		Map<String, String> map2 = new HashMap<>();
		Set<String> map1_key = map1.keySet();
		// 反向
		for (String key : map1_key) {
			map2.put(map1.get(key), key);
		}
		int flag = -1;
		String first = list.get(0);
		if (first.equals("Double")) {
			String second = list.get(1);
			if (map1.containsKey(second)) {
				flag = 1;
			} else {
				flag = 2;
			}
		} else {
			if (map1.containsKey(first)) {
				flag = 1;
			} else {
				flag = 2;
			}
		}
		if (flag == 1) {
			for (int i = 0; i < list.size(); i++) {
				String num = list.get(i);
				System.out.print(map1.get(num));
			}

		} else if (flag == 2) {
			for (int i = 0; i < list.size(); i++) {
				String num = list.get(i);
				if (num.equals("Double")) {
					String out = list.get(i + 1);
					System.out.print(map2.get(out));
					System.out.print(map2.get(out));
					i = i + 2;
				} else {
					System.out.print(map2.get(num));
				}
			}
		}
	}
}
