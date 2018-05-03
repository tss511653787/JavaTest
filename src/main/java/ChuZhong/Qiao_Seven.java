package ChuZhong;

import java.util.ArrayList;
import java.util.List;

public class Qiao_Seven {
	final static int THREE = 3;
	final static int SEVEN = 7;

	/*
	 * 2018.2.19 初中聚会
	 */
	public static void main(String[] args) {
		System.out.println("从1到100开始敲3、7");
		List<Integer> answer = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			if (Panduan(i)) {
				answer.add(i);
			} else {
				answer.add(-1);
			}
		}
		int num = 0;
		// OutPut
		for (int j : answer) {
			if (j == -1) {
				System.out.print("敲");
			} else {
				System.out.print(j);
			}
			num++;
			if (num == 10) {
				System.out.println();
				num = 0;
			} else {
				System.out.print(" ");
			}
		}
	}

	// 判断该数是否需要敲
	private static boolean Panduan(int i) {
		// TODO Auto-generated method stub
		if (i % THREE == 0 || i % SEVEN == 0 || Contain_3_OR_7(i)) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean Contain_3_OR_7(int i) {
		// TODO Auto-generated method stub
		String str = String.valueOf(i);
		if (str.contains(String.valueOf(THREE)) || str.contains(String.valueOf(SEVEN))) {
			return true;
		} else {
			return false;
		}
	}

}
