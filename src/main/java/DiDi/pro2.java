package DiDi;

import java.util.Scanner;

/*
 * 丑数
 * */
public class pro2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int num = scanner.nextInt();
		System.out.print(GetUglyNumber_Solution(num));

	}

	public static int GetUglyNumber_Solution(int index) {
		if (index < 7)
			return index;
		int[] k = new int[index];
		k[0] = 1;
		int t2 = 0;
		int t3 = 0;
		int t5 = 0;
		for (int i = 1; i < index; i++) {
			k[i] = findmin(k[t2] * 2, findmin(k[t3] * 3, k[t5] * 5));
			if (k[i] == k[t2] * 2)
				t2++;
			if (k[i] == k[t3] * 3)
				t3++;
			if (k[i] == k[t5] * 5)
				t5++;
		}
		return k[index - 1];
	}

	private static int findmin(int a, int b) {
		// TODO Auto-generated method stub
		return (a < b) ? a : b;
	}

}
