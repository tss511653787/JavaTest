package HuaWeiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Toutiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		func2();

	}

	public static void func2() {
		Scanner scan = new Scanner(System.in);
		String[] num = scan.nextLine().split(" ");
		int numSentance = Integer.valueOf(num[0]);
		int numFind = Integer.valueOf(num[1]);
		String[] sentance = new String[numSentance];
		String[] find = new String[numFind];
		for (int i = 0; i < numSentance; i++) {
			sentance[i] = scan.nextLine();
		}
		for (int i = 0; i < numFind; i++) {
			find[i] = scan.nextLine();
		}
		int[][] maxNum = new int[numFind][numSentance];
		// 赋0
		for (int m = 0; m < numFind; m++) {
			for (int n = 0; n < numSentance; n++)
				maxNum[m][n] = 0;
		}

		for (int i = 0; i < numFind; i++) {
			// 将数组转化为arrylist的方法
			ArrayList<String> findlist = new ArrayList<String>(
					Arrays.asList(find[i].split(" ")));
			for (int j = 0; j < numSentance; j++) {
				ArrayList<String> senList = new ArrayList<>(
						Arrays.asList(sentance[j].split(" ")));
				ArrayList<String> copy = (ArrayList<String>) senList.clone();
				// 对copy求交集
				copy.retainAll(findlist);
				// 存储交集的长度
				maxNum[i][j] = copy.size();
			}
		}
		for (int i = 0; i < numFind; i++) {
			int max = findMaxIndex(maxNum, i);
			System.out.println(sentance[max]);
		}
	}

	public static int findMaxIndex(int[][] a, int i) {
		int max = 0;
		// 列数
		int len = a[i].length;
		int answer = 0;
		for (int j = 0; j < len; j++) {
			if (a[i][j] > max) {
				max = a[i][j];
				answer = j;
			}
		}
		return answer;
	}

	public static void func1() {
		Scanner scan = new Scanner(System.in);
		String[] line1 = scan.nextLine().split(" ");
		int n = Integer.valueOf(line1[0]);
		int q = Integer.valueOf(line1[1]);
		int[] intarr1 = new int[n];
		int[] intarr2 = new int[n];
		String[] line2 = scan.nextLine().split(" ");
		for (int i = 0; i < intarr1.length; i++) {
			intarr1[i] = Integer.valueOf(line2[i]);
		}
		String[] line3 = scan.nextLine().split(" ");
		for (int i = 0; i < intarr2.length; i++) {
			intarr2[i] = Integer.valueOf(line3[i]);
		}
		// 竖着存放
		int[] x = new int[q];
		int[] y = new int[q];
		for (int j = 0; j < q; j++) {
			String[] in = scan.nextLine().split(" ");
			x[j] = Integer.valueOf(in[0]);
			y[j] = Integer.valueOf(in[1]);
		}
		int[] count = new int[q];
		for (int i = 0; i < q; i++)
			count[i] = 0;
		// 判断
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++) {
				if (intarr1[j] >= x[i] && intarr2[j] >= y[i]) {
					count[i]++;
				}
			}
		}
		for (int i = 0; i < q; i++) {
			System.out.println(count[i]);
		}

	}
}
