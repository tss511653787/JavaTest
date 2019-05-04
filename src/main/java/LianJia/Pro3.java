package LianJia;

import java.util.Scanner;

public class Pro3 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int array[][] = new int[m][2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		System.out.println(func(m, n, arr, array));
	}

	public static int func(int m, int n, int arr[], int array[][]) {
		int s = 0;
		for (int i = 0; i < m; i++) {
			int a = array[i][0];
			int b = array[i][1];
			if (arr[a - 1] > arr[b - 1])
				s += arr[b - 1];
			else
				s += arr[a - 1];
		}
		return s;
	}

}
