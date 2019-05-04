package DiDi;

import java.util.Scanner;

public class pro1 {
	static Scanner scanner = new Scanner(System.in);

	/*
	 * xor
	 */
	public static void main(String[] args) {
		int num = Integer.parseInt(scanner.nextLine());
		int[] arr = new int[num];
		String[] in = scanner.nextLine().split("\\s+");
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		int last = 0;
		int count = 0;
		for (int i = 0; i < num; i++) {
			int temp = 0;
			for (int j = i; j >= last; j--) {
				temp = temp ^ arr[j];
				if (temp == 0) {
					last = i + 1;
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}
