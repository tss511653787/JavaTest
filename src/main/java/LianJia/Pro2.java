package LianJia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Pro2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		long r;
		long avg;
		String[] in1 = scanner.nextLine().split("\\s+");
		n = Integer.parseInt(in1[0]);
		r = Integer.parseInt(in1[1]);
		avg = Integer.parseInt(in1[2]);
		// 需要的总分
		long need_sorce = avg * n;
		// 当前分数
		long now_sorce = 0;
		// 存放 ai和bi数组
		long[][] arr = new long[n][2];
		List<Subject> list = new ArrayList<Subject>();
		for (int i = 0; i < arr.length; i++) {
			String[] in = scanner.nextLine().split("\\s+");
			// arr[i][0] = Integer.parseInt(in[0]);
			// arr[i][1] = Integer.parseInt(in[1]);
			Subject sub = new Subject(Integer.parseInt(in[0]),
					Integer.parseInt(in[1]));
			list.add(sub);
			now_sorce += sub.sorce;
		}
		// 冒泡排序
		// Mao_sort(arr);
		Collections.sort(list, new Comparator<Subject>() {

			@Override
			public int compare(Subject o1, Subject o2) {
				// TODO Auto-generated method stub
				if (o1.magic_value < o2.magic_value) {
					return -1;
				} else if (o1.magic_value > o2.magic_value) {
					return 1;
				} else {
					return 0;
				}
			}

		});
		long magic_value = 0;
		int i = 0;
		// while (now_sorce < need_sorce && i < n) {
		// if (arr[i][0] < r) {
		// magic_value += arr[i][1];
		// now_sorce++;
		// arr[i][0]++;
		// } else {
		// i++;
		// }
		// }
		while (now_sorce < need_sorce && i < n) {
			if (list.get(i).sorce < r) {
				magic_value += list.get(i).magic_value;
				now_sorce++;
				list.get(i).sorce++;
			} else {
				i++;
			}
		}
		System.out.print(magic_value);
	}

	private static void Mao_sort(long[][] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j][1] > arr[j + 1][1]) {
					swap(arr, j, j + 1);
					flag = false;
				}
			}
			if (flag) {
				return;
			}
		}
	}

	private static void swap(long[][] arr, int j, int i) {
		// TODO Auto-generated method stub
		long temp1;
		long temp2;
		temp1 = arr[j][1];
		temp2 = arr[j][0];
		arr[j][1] = arr[i][1];
		arr[j][0] = arr[i][0];
		arr[i][1] = temp1;
		arr[i][0] = temp2;
	}
}

class Subject {
	long sorce;
	long magic_value;

	public Subject(long sorce, long magic_value) {
		super();
		this.sorce = sorce;
		this.magic_value = magic_value;
	}
}
