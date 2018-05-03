package RedBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MiMa {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(scanner.nextLine());
		int[] array = new int[n];
		String[] in = scanner.nextLine().split("\\s+");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(in[i]);
		}
		int k = Integer.parseInt(scanner.nextLine());
		List<Double> res = new ArrayList<Double>();
		for (int i = 0; i <= n - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += array[j];
			}
			res.add(((double) sum / k));
		}
		System.out.print(Collections.max(res));
	}
}
