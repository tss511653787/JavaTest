package MeiTaun;

import java.util.Scanner;

public class DianDeng {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int num = Integer.parseInt(scanner.nextLine());
		int[] arr = new int[num];
		String[] in = scanner.nextLine().split("\\s+");
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		if (arr[num - 1] == 0) {
			System.out.print("Bob");
		} else {
			System.out.print("Alice");
		}
	}

}
