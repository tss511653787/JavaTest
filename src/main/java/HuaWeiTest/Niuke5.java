package HuaWeiTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import HuaWeiTest.NiuKe3;

public class Niuke5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		ListNode phead = deleteDuplication(head);
		while (phead != null) {
			System.out.print(phead.val + "->");
			phead = phead.next;
		}
	}

	// 不使用任何运算符求两个数的和(异或 位运算)
	public static int Add(int num1, int num2) {
		if (num2 == 0)
			return num1;
		int ares = num1 ^ num2;
		int bres = (num1 & num2) << 1;
		return Add(ares, bres);
	}

	// 输入一个字符串,包括数字字母符号,可以为空 转换为整数
	public static int StrToInt(String str) {
		if (str.length() == 0)
			return 0;
		else {
			// 确定符号位
			char flag = str.charAt(0);
			if (flag == '+') {
				if (str.length() == 1)
					return 0;
				StringBuilder temp = new StringBuilder();
				for (int i = 1; i < str.length(); i++) {
					char c = str.charAt(i);
					if (c >= '0' && c <= '9') {
						temp.append(c);
					} else {
						return 0;
					}
				}

				BigInteger num = new BigInteger(temp.toString());
				return num.intValue();
			} else if (flag == '-') {
				if (str.length() == 1)
					return 0;
				StringBuilder temp = new StringBuilder();
				for (int i = 1; i < str.length(); i++) {
					char c = str.charAt(i);
					if (c >= '0' && c <= '9') {
						temp.append(c);
					} else {
						return 0;
					}
				}
				BigInteger num = new BigInteger(temp.toString());
				return -num.intValue();
			} else {
				// 没有符号位
				StringBuilder temp = new StringBuilder();
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					if (c >= '0' && c <= '9') {
						temp.append(c);
					} else {
						return 0;
					}
				}
				BigInteger num = new BigInteger(temp.toString());
				return num.intValue();
			}
		}
	}

	// 返回数组中任意一个重复的数字
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int n : numbers) {
			list.add(n);
		}
		// 遍历list
		for (int i = 0; i < length; i++) {
			int temp = list.get(0);
			list.remove(0);
			if (list.contains(temp)) {
				duplication[0] = temp;
				return true;
			}
		}
		return false;
	}

	/*
	 * 
	 * 今日头条2面中的一个编程问题：给定一个很大的int型数组 输出里面重复的数字1.很大数组的存放 是否可能存索引2.具体的找重复的实现
	 * 是否可以使用wordcount的Hashmap思想
	 */
	public static int[] findDoubleAppear(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int number : array) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		// 对map进行遍历
		ArrayList<Integer> list = new ArrayList<>();
		Set<Integer> mapk = map.keySet();
		for (int k : mapk) {
			int value = map.get(k);
			if (value > 1)
				list.add(k);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	/*
	 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
	 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
	 */
	public static int[] multiply(int[] A) {
		int[] b = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int answer = 1;
			for (int j = 0; j < A.length; j++) {
				if (i == j) {
				} else {
					answer *= A[j];
				}
			}
			b[i] = answer;
		}
		return b;
	}

	/*
	 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
	 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
	 */
	public static boolean match(char[] str, char[] pattern) {
		// 分2大种情况讨论
		if (str == null || pattern == null) {
			return false;
		} else if (str.length == 0 && pattern.length == 0) {
			return true;
		}
		// } else if (str.length == 0 && pattern.length != 0) {
		// return panduan(pattern);
		// } else {
		// 设置匹配初始索引
		int strindex = 0;
		int patternindex = 0;
		return matchTo(str, pattern, strindex, patternindex);
	}

	private static boolean matchTo(char[] str, char[] pattern, int strindex,
			int patternindex) {
		// TODO Auto-generated method stub
		// 匹配结束条件
		// 指针到末尾说明匹配成功
		if (strindex == str.length && patternindex == pattern.length) {
			return true;
		}
		// pattenindex先到末尾则匹配失败
		if (strindex != str.length && patternindex == pattern.length) {
			return false;
		}
		// 当前patten第二位是*的情况
		if (patternindex + 1 < pattern.length
				&& pattern[patternindex + 1] == '*') {
			// 第一位匹配
			if (((strindex != str.length) && str[strindex] == pattern[patternindex])
					|| ((strindex != str.length) && pattern[patternindex] == '.')) {
				// 三种情况
				return matchTo(str, pattern, strindex + 1, patternindex + 2)
						|| matchTo(str, pattern, strindex, patternindex + 2)
						|| matchTo(str, pattern, strindex + 1, patternindex);
			}
			// 第一位不匹配
			else {
				// pattenindex后移2位
				return matchTo(str, pattern, strindex, patternindex + 2);
			}

		}
		// 当前patten第二位不是*的情况
		else {
			// 第一位匹配
			if ((strindex != str.length)
					&& (str[strindex] == pattern[patternindex])
					|| (pattern[patternindex] == '.' && (strindex != str.length))) {
				return matchTo(str, pattern, strindex + 1, patternindex + 1);
			}
			// 第一位不匹配
			return false;
		}
	}

	// 判断是否是数字
	public boolean violenceisNumeric(char[] str) {
		try {
			double n = Double.parseDouble(String.valueOf(str));
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// 正常的思路：使用多个flag标签实现
	// 首先判断是数字的特性
	public boolean isNumeric(char[] str) {
		// 多种情况判断
		if (str.length == 0)
			return false;
		boolean sign = false;// +-判断flag
		boolean eflag = false;// e E 判断flag
		boolean pointflag = false;// .判断flag
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '+' || str[i] == '-') {
				if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
					// 是第一次出现+- 不是首位 且前面没有e/E 则不是数字
					return false;
				}
				if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
					// 不是第一次出现
					return false;
				}
			} else if (str[i] == '.') {
				if (eflag || pointflag) {
					// 不是第一次出现||有e/E出现
					return false;
				}
				pointflag = true;
			} else if (str[i] == 'e' || str[i] == 'E') {
				if (eflag)
					return false;
				if (i == str.length - 1)
					// e/E不能在末尾
					return false;
				eflag = true;
			} else if (str[i] < '0' || str[i] > '9') {
				return false;
			}
		}
		return true;
	}

	// 全局变量
	public static ArrayList<Character> list = new ArrayList<>();
	public static LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

	// Insert one char from stringstream
	public static void Insert(char ch) {

		// 不为空则add
		// jdk1.8之前 LinkedHashMap还没有实现getOrDefault方法
		// map.put(ch, map.getOrDefault(ch, 0) + 1);
		if (!map.containsKey(ch)) {
			map.put(ch, 1);
		} else {
			map.put(ch, map.get(ch) + 1);
		}
		list.add(ch);

	}

	// return the first appearence once char in current stringstream
	public static char FirstAppearingOnce() {
		char res = '#';
		for (char c : list) {
			if (map.get(c) == 1) {
				res = c;
				break;
			}
		}
		return res;
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ArrayList<ListNode> list = new ArrayList<>();
		while (pHead != null) {
			if (list.contains(pHead))
				return pHead;
			list.add(pHead);
			pHead = pHead.next;
		}
		return null;
	}

	/*
	 * 在一个排序的链表中，存在重复的结点， 请删除该链表中重复的结点，重复的结点不保留， 返回链表头指针。
	 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5有一个较为复杂的算法
	 */
	public static ListNode deleteDuplication(ListNode pHead) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// 遍历链表计算重复节点
		ListNode tail = pHead;
		while (tail != null) {
			if (!map.containsKey(tail.val)) {
				map.put(tail.val, 1);
			} else {
				map.put(tail.val, map.get(tail.val) + 1);
			}
			tail = tail.next;
		}
		// 删除发生重复的节点
		tail = pHead;
		Set<Integer> mapset = map.keySet();
		for (int val : mapset) {
			int num = map.get(val);
			if (num > 1) {
				int flag = deleteInlinkedlist(pHead, val, num);
				if (flag == 1) {
					for (int i = 0; i < num; i++) {
						pHead = pHead.next;
					}
				}
			}
		}
		return pHead;
	}

	private static int deleteInlinkedlist(ListNode pHead, int val, int num) {
		// TODO Auto-generated method stub
		ListNode tail = pHead;
		ListNode last = tail;
		if (tail.val == val) {
			// 第一个节点就是要删除的
			return 1;
		} else {
			// 要删除的不是第一个节点
			while (tail != null) {
				if (tail.next != null) {
					last = tail.next;
					if (last.val == val) {
						break;
					}
				}
				tail = tail.next;
			}
			for (int i = 0; i < num; i++) {
				last = last.next;
			}
			tail.next = last;
			return 0;
		}
	}
}
