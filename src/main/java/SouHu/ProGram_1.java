package SouHu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProGram_1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] in1 = scanner.nextLine().split("\\s+");
		String[] in2 = scanner.nextLine().split("\\s+");
		// 输出数目
		int out = Integer.parseInt(in1[0]);
		// 数组长度
		int len = Integer.parseInt(in1[1]);
		int[] arr = new int[len];
		// inital
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(in2[i]);
		}
		// Kolakoski数组
		List<Integer> list = new ArrayList<Integer>();
		// 原来数组元素更替
		int cur = 0;
		int l = 0;
		list.add(arr[0]);
		while (list.size() < out) {
			int lenght = list.get(l);
			if (l == 0) {
				lenght--;
			}
			for (int i = 0; i < lenght; i++) {
				list.add(arr[cur]);
			}
			cur++;
			if (cur == len) {
				cur = 0;
			}
			l++;
		}
		list.forEach(x -> System.out.print(x + " "));
	}
}
