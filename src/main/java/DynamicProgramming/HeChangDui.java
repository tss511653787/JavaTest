package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 合唱队问题：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
 *合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   、
 *则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。 
 *你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 
 * */
/*
 * 思路：
 * 分别从前向后和从后向前 求最大递增子序列
 * 2状态规划表求和=总状态
 * 总人数-总状态max值+1=结果
 * */
public class HeChangDui {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = Integer.parseInt(scan.nextLine());
			String[] in = scan.nextLine().split("\\s+");
			int[] arr = new int[in.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(in[i]);
			}
			// 分别从前向后和从后向前求最大递增子序列
			int[] leftToright = findmaxLen(arr);
			int[] arr1 = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr1[arr.length - 1 - i] = arr[i];
			}
			int[] rightToleft = findmaxLen(arr1);
			int[] count = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				count[i] = leftToright[i] + rightToleft[arr.length - 1 - i];
			}
			int max = 0;
			for (int m : count) {
				if (m > max)
					max = m;
			}
			System.out.println(arr.length - max + 1);
		}

	}

	public static int[] findmaxLen(int[] arr) {
		int len = arr.length;
		// 状态方程
		int[] opt = new int[len];
		for (int i = 0; i < len; i++) {
			opt[i] = 1;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (opt[j] + 1 > opt[i]) {
						opt[i] = opt[j] + 1;
					}
				}
			}
		}
		return opt;
	}
}
