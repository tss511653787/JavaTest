package Wangyi;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 1、将a_i放入b序列的末尾
 2、逆置b序列
 小易需要你计算输出操作n次之后的b序列。
 * */
public class NiXuSort {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		nixu();
	}

	/*
	 * 双端队列 奇数次插入队头 逆序 偶数次插入队尾 不逆序
	 */
	public static void nixu() {
		int num = Integer.parseInt(scan.nextLine());
		int[] arr = new int[num];
		String[] in = scan.nextLine().split("\\s+");
		// inital
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for (int j = 1; j <= num; j++) {
			if (j % 2 != 0) {
				// 奇数
				queue.offerLast(arr[j - 1]);
			} else {
				// 偶数
				queue.offerFirst(arr[j - 1]);
			}
		}
		if (num % 2 != 0) {
			// Collections.reverse(queue);
			while (queue.size() != 1) {
				System.out.print(queue.pollLast() + " ");
			}
			System.out.print(queue.pollLast());
		} else {
			while (queue.size() != 1) {
				System.out.print(queue.pollFirst() + " ");
			}
			System.out.print(queue.pollFirst());
		}

	}
}
