package MianShiBaoDian;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class StringAndArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		str.intern();
		int[] a = { 2, 2, 2, 2, -1, 3, 2, 3 };
		// numCountInArr(a).forEach(x -> System.out.print(x + " "));
		// Baoshu(10);
		// RengRen(30, 15);
		String[] str1 = { "Bc", "Ad", "aC", "Hello", "X man", "little",
				"During", "day" };
		ArrayList<String> list = new ArrayList<>(Arrays.asList(str1));
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				// 如果是小写则转换为大写比较
				int min = s1.length();
				if (s2.length() < min)
					min = s2.length();
				for (int i = 0; i < min; i++) {
					char c1 = Character.toUpperCase(s1.charAt(i));
					char c2 = Character.toUpperCase(s2.charAt(i));
					if (c1 == c2) {
					} else {
						// 不等
						return c1 - c2;
					}
				}
				// 相等
				return 0;
			}
		});
		list.forEach(x -> System.out.print(x + " "));

	}

	// 使用hashmap做一个数组的元素统计
	// 返回值是出现次数/数组长度大于0.5的元素
	public static ArrayList<Integer> numCountInArr(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : arr) {
			// good code
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		ArrayList<Integer> answer = new ArrayList<>();
		Set<Integer> ketset = map.keySet();
		for (Integer key : ketset) {
			int value = map.get(key);
			if ((double) value / arr.length > 0.5) {
				answer.add(key);
			}
		}
		return answer;
	}

	// 约瑟环报数报数(扔人)问题
	// 报数问题
	public static void Baoshu(int n) {
		// 有n个人开始报数 报到3就出列 直到所有人都出列为止
		int[] arr = new int[n];
		int len = n;
		for (int i = 0; i < n; i++) {
			arr[i] = 1;
		}
		// 开始报数
		int i = 0;
		int count = 0;
		while (n > 0) {
			if (arr[i] != 0)
				count++;// 报数
			if ((count % 3 == 0) && (arr[i] != 0)) {
				System.out.print((i + 1) + "->");
				arr[i] = 0;
				count = 0;
				n--;
			}
			i++;
			if (i == len)
				i = 0;
		}
	}

	// 扔人问题 上面的n和总数不相等
	public static void RengRen(int n, int outNum) {
		// 有n个人开始报数 报到3就出列 直到所有人都出列为止
		int[] arr = new int[n];
		int len = n;
		for (int i = 0; i < n; i++) {
			arr[i] = 1;
		}
		// 开始报数
		int i = 0;
		int count = 0;
		while (outNum > 0) {
			if (arr[i] != 0)
				count++;// 报数
			if ((count % 9 == 0) && (arr[i] != 0)) {
				System.out.print((i + 1) + "->");
				arr[i] = 0;
				count = 0;
				outNum--;
			}
			i++;
			if (i == len)
				i = 0;
		}
	}
	// 字符串排序
	// 不使用现有的类进行排序

}
