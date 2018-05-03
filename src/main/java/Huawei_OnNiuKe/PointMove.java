package Huawei_OnNiuKe;

import java.util.Scanner;

public class PointMove {
	/*
	 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
	 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(";");
		String[] correctPont = CheckPoint(input);
		System.out.print(Move(correctPont));

	}

	// 移动函数
	private static String Move(String[] correctPont) {
		// TODO Auto-generated method stub
		int[] res = new int[2];
		res[0] = 0;
		res[1] = 0;
		for (String s : correctPont) {
			String first = s.substring(0, 1);
			String second = s.substring(1);
			int num = Integer.parseInt(second);
			switch (first) {
			case "A":
				res[0] = res[0] - num;
				break;
			case "S":
				res[1] = res[1] - num;
				break;
			case "W":
				res[1] = res[1] + num;
				break;
			case "D":
				res[0] = res[0] + num;
				break;
			}
		}
		return res[0] + "," + res[1];
	}

	// 定义一个坐标检测方法
	private static String[] CheckPoint(String[] input) {
		// TODO Auto-generated method stub
		// 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (Pass(input[i])) {
				out.append(input[i]);
				if (i < input.length - 1) {
					out.append(";");
				}
			}
		}
		String[] res = out.toString().split(";");
		return res;
	}

	// 具体判断函数
	private static boolean Pass(String in) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (in.length() > 3) {
			flag = false;
		} else if (in.length() == 0) {

		} else {
			String first = in.substring(0, 1);
			String second = in.substring(1);
			if ((!first.equals("A")) && (!first.equals("W"))
					&& (!first.equals("S")) && (!first.equals("D"))) {
				flag = false;
			}
			try {
				int num = Integer.parseInt(second);
			} catch (Exception e) {
				// TODO: handle exception
				flag = false;
			}
		}
		return flag;
	}

}
