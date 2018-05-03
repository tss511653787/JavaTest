package DynamicProgramming;

/*
 * 物品重量w[n]={0，2，2，6，5，4}
 * 价值v[n]={0,6,3,5,4,6}
 * 包 m=10
 * */
public class Bag {
	public static void main(String[] args) {
		System.out.println(bagProblem());
	}

	public static int bagProblem() {
		int[] w = { 0, 2, 2, 6, 5, 4 };
		int[] v = { 0, 6, 3, 5, 4, 6 };
		int bag = 10;
		// 建立状态矩阵 中的值是当前容积下最大价值
		int[][] opt = new int[w.length + 1][bag + 1];
		// initial all->0
		// start
		for (int i = 1; i < w.length + 1; i++) {
			for (int j = 1; j < bag + 1; j++) {
				// 当前物品能放入背包
				if (w[i - 1] < j) {
					opt[i][j] = Max(opt[i - 1][j - w[i - 1]] + v[i - 1],
							opt[i - 1][j]);
				} else {
					// 不能放入
					opt[i][j] = opt[i - 1][j];
				}
			}
		}
		return opt[w.length][bag];
	}

	public static int Max(int i, int j) {
		// TODO Auto-generated method stub
		return i > j ? i : j;
	}

}
