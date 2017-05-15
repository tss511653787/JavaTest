package HuaWeiTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static void getMemIds(String[] memberIds, String[] tradeIds,
			String[] tradeAmount, String[] cartIds, int amount) {
		ArrayList<String> list = new ArrayList<String>();
		for (String str : tradeAmount) {
			if (Integer.valueOf(str) >= amount) {
				list.add(str);
			}
		}
		ArrayList<Integer> listIndex = new ArrayList<Integer>();
		for (String s : list) {
			listIndex.add(list.indexOf(s));
		}
		ArrayList<String> findMen = new ArrayList<String>();
		for (Integer i : listIndex) {
			findMen.add(memberIds[i]);
		}
		for (String out : findMen) {
			System.out.println(out);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] memberIds = s.nextLine().split(",");
		String[] tradeIds = s.nextLine().split(",");
		String[] tradeAmount = s.nextLine().split(",");
		String[] cartIds = s.nextLine().split(",");
		int amount = s.nextInt();

		getMemIds(memberIds, tradeIds, tradeAmount, cartIds, amount);
	}

}
