package Test5;

import java.util.Scanner;

public class BagTest {
	//背包问题

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = Integer.valueOf(scan.nextLine());
		int[] price = new int[num];
		String[] priceStrAtt = scan.nextLine().split(" ");
		for (int i = 0; i < num; i++) {
			price[i] = Integer.valueOf(priceStrAtt[i]);
		}
		int[] wight = new int[num];
		String[] weightStrAtt = scan.nextLine().split(" ");
		for (int i = 0; i < num; i++) {
			wight[i] = Integer.valueOf(weightStrAtt[i]);
		}
		int maxWeight = scan.nextInt();
		System.out.println(knapsack(price, wight, maxWeight));
		

	}

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		if (a > b)
			return a;
		else
			return b;
	}

	public static int knapsack(int val[], int wt[], int W) {
		int N = wt.length;
		int[][] V = new int[N + 1][W + 1];
		for (int col = 0; col <= W; col++) {
			V[0][col] = 0;
		}
		for (int row = 0; row <= N; row++) {
			V[row][0] = 0;
		}
		for (int item = 1; item <= N; item++) {
			for (int weight = 1; weight <= W; weight++) {
				if (wt[item - 1] <= weight) {
					V[item][weight] = Math.max(val[item - 1]
							+ V[item - 1][weight - wt[item - 1]],
							V[item - 1][weight]);
				} else {
					V[item][weight] = V[item - 1][weight];
				}
			}
		}
		return V[N][W];
	}

}
