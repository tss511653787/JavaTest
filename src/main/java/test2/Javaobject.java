package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class Javaobject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str1 = { "abc", "bbb" };
		String[] str2 = { "abc", "ccc" };
		for (String outStr : union(str1, str2)) {
			System.out.println(outStr);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		// ADT IntArrayBag
		int a = Integer.MAX_VALUE;

	}

	public static String[] union(String[] a, String[] b) {
		HashSet<String> set = new HashSet<String>();
		for (String str : a) {
			set.add(str);
		}
		for (String str : b) {
			set.add(str);
		}
		String[] res = {};
		return set.toArray(res);

	}
}
