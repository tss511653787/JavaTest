package TX;

import java.util.Arrays;
import java.util.Scanner;

public class sortNum {
	// Arrays.sort(arr);
	static int[] flag = new int[100];
	static int index = 0;// 记录当前

	public static void numGroup(int[] arr, int start, int length, int sum) {
		if (sum == 0) {
			for (int j = 0; j < index; j++) {
				System.out.print(flag[j]);
			}
			System.out.println();
		} else {
			for (int i = start; i < length; i++) {
				flag[index++] = arr[i];
				numGroup(arr, i + 1, length - 1, sum - arr[i]);
			}
		}
		index--;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = Integer.valueOf(scan.nextLine());
		int num = Integer.valueOf(scan.nextLine());
		int[] arrNum = new int[num];
		String[] arrInt = scan.nextLine().split(" ");
		for (int i = 0; i < arrNum.length; i++) {
			arrNum[i] = Integer.valueOf(arrInt[i]);
		}
		scan.close();
		Arrays.sort(arrNum);
		numGroup(arrNum, 0, arrNum.length, sum);
	}
}
