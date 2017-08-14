package Wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *      * 最后的结果只可能出现在棋子横纵坐标的组合上      * 比如两颗棋子的坐标为(1, 2)和(5, 6) 那最后的结果只可能出现在(1,
 * 2),(1, 6),(5, 2),(5, 6)      * 按总共候选点的个数就是n * n      *
 * 计算出所有棋子到每个候选点的距离,并对这个距离排序,根据计算出的距离选择最优解      *
 * 比如要求有一个格子有3颗棋子最小移动次数,只需要计算每个候选点放三颗棋子的移动次数,然后取最小值      *      * @param x
 *      * @param y      * @param distances      
 */
public class XiaoYiCorrect {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] Xin = scan.nextLine().split("\\ ");
		String[] Yin = scan.nextLine().split("\\ ");
		long[] Xarr = new long[num];
		long[] Yarr = new long[num];
		for (int i = 0; i < num; i++) {
			Xarr[i] = Long.parseLong(Xin[i]);
			Yarr[i] = Long.parseLong(Yin[i]);
		}
		List<List<Integer>> distance = new ArrayList<List<Integer>>();
		couuntDis(Xarr, Yarr, distance);

	}

	public static void couuntDis(long[] xarr, long[] yarr,
			List<List<Integer>> distance) {
		// TODO Auto-generated method stub
		for (int i = 0; i < xarr.length; i++) {
			for (int j = 0; j < yarr.length; j++) {
				List<Integer> dis = new ArrayList<>();
				for (int m = 0; m < xarr.length; m++) {
					dis.add((int) (Math.abs(xarr[m] - xarr[i])
							+ Math.abs(yarr[m] - yarr[j])));
				}
			}
		}
	}
}
