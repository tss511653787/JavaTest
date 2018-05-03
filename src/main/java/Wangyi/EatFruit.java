package Wangyi;

import java.util.Scanner;

/*
 * 吃水果 交房租
 * */
public class EatFruit {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] in = scan.nextLine().split("\\ ");
		long x = Integer.parseInt(in[0]);
		long f = Integer.parseInt(in[1]);
		long d = Integer.parseInt(in[2]);
		long p = Integer.parseInt(in[3]);
		long day = 0;
		while (d >= 0) {
			// eat fruit
			if (f > 0) {
				f--;
			} else {
				if (d - p < 0) {
					break;
				} else {
					d -= p;
				}
			}
			// 交房租
			if (d - x < 0) {
				break;
			} else {
				d -= x;
			}
			day++;
		}
		System.out.print(day);
	}
}
