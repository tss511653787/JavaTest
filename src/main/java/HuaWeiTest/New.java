package HuaWeiTest;

import java.util.Scanner;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] coun = new int[5];
		//题目：华为实习笔试第二题
		//next方法 不能读到带有空格的字符串 读到空格标识结束 开始是从第一个没有空格的字符开始
		//nextLine方法读到回车才意味着结束 可以读取空格
		//ctrl+z EOF结束
		while (scan.hasNext()) {
			// 读取输入的字符变量
			String str = scan.next();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					coun[i]++;
				}
			}
		}
		int minNum = Integer.MAX_VALUE;
		for (int j = 0; j < coun.length; j++) {
			if (coun[j] < minNum) {
				minNum = coun[j];
			}
		}
		System.out.println(minNum);
	}

}
