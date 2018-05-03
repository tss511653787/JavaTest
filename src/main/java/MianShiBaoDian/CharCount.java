package MianShiBaoDian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CharCount {
	// 一个字符串中包含多个字母a-z 求出现次数最多的那个字母的次数 如果有多个重复则都求出
	// 思路 hashmap key值不能重复 key值作为字母
	// 类似于WC
	public static HashMap<Character, Integer> charCount(String str) {
		char[] chararr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			chararr[i] = str.charAt(i);
		}
		HashMap<Character, Integer> countmap = new HashMap<>();
		for (char c : chararr) {
			// 不错的写法
			countmap.put(c, countmap.getOrDefault(c, 0) + 1);
		}
		return countmap;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		HashMap<Character, Integer> res = charCount(in);
		// 对hashmap的value进行排序 需要调用sort方法 传入一个comparetor
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>();
		list.addAll(res.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> l1,
					Map.Entry<Character, Integer> l2) {
				// TODO Auto-generated method stub
				return l2.getValue() - l1.getValue();
			}
		});
		list.forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));

	}
}
