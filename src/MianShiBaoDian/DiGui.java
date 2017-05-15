/**
 * 
 */
package MianShiBaoDian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class DiGui {

	/**
	 * @param args
	 *            全排列去重复输出 输入没有空格
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		Permutation(inputStr).forEach(x -> System.out.println(x));

	}

	private static void Outlist(ArrayList<String> inlist, String answer,
			ArrayList<String> answerlist) {
		// TODO Auto-generated method stub
		if (inlist.isEmpty()) {
			answerlist.add(answer);
		}
		for (int i = 0; i < inlist.size(); i++) {
			ArrayList<String> temp = new ArrayList<>(inlist);
			Outlist(temp, answer + temp.remove(i), answerlist);
		}
	}

	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str.length() == 0)
			return list;
		// 将输出的str转换成arraylist
		for (int i = 0; i < str.length(); i++) {
			list.add(String.valueOf(str.charAt(i)));
		}
		ArrayList<String> answerlist = new ArrayList<>();
		String answer = "";
		Outlist(list, answer, answerlist);
		// 对answerlist去重
		ArrayList<String> distictList = new ArrayList<>();
		for (String s : answerlist) {
			if (!distictList.contains(s)) {
				distictList.add(s);
			}
		}
		return distictList;
	}
}
