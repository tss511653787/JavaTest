package NiuKeBook;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JD_1 {
	static Scanner scanner = new Scanner(System.in);

	// test
	public static void main(String[] args) {
		soleProduct();
	}

	/*
	 * 求各个位上的均值
	 */
	public static void avgInNum() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int sum = sunNum(n);
			System.out.println(sum + "/" + (n - 2));
			scan.close();
		}
	}

	public static int sunNum(int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 2; i < n; i++) {
			int num = n;
			while (num > 0) {
				sum += num % i;
				num = num / i;
			}
		}
		return sum;
	}

	/*
	 * 求并集？
	 */
	public static void setUnion() {
		while (scanner.hasNext()) {
			String[] num = scanner.nextLine().split("\\s+");
			int allLen = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
			Set<Integer> set = new TreeSet<>();
			for (int i = 0; i < allLen; i++) {
				set.add(scanner.nextInt());
			}
			set.forEach(s -> System.out.print(s + " "));
		}
	}

	/*
	 * 通过考试 动态规划思想
	 */
	public static void passTheExam() {
		int num = Integer.parseInt(scanner.nextLine());
		String[] arr = scanner.nextLine().split("\\s+");
		double[] passP = new double[num];
		// inital
		for (int i = 0; i < num; i++) {
			passP[i] = Double.parseDouble(arr[i]) * 0.01;
		}
		// opt[i][j]状态表示前i个题目做对j个的概率
		double[][] opt = new double[num + 1][num + 1];
		// initial
		opt[0][0] = 1;
		// bulid ot[i][j]
		for (int i = 1; i < num + 1; i++) {
			opt[i][0] = opt[i - 1][0] * (1 - passP[i - 1]);
			for (int j = 1; j <= i; j++) {
				opt[i][j] = opt[i - 1][j] * (1 - passP[i - 1])
						+ opt[i - 1][j - 1] * passP[i - 1];
			}
		}
		int passNum = (int) Math.ceil(num * 0.6);
		double sum = 0.0;
		for (int j = passNum; j < num + 1; j++) {
			sum += opt[num][j];
		}
		System.out.print(sum);
	}

	/*
	 * 异或后十进制输出
	 */
	public static void YiHuo() {
		int len = Integer.parseInt(scanner.nextLine());
		String num1 = scanner.nextLine();
		String num2 = scanner.nextLine();
		StringBuilder res = new StringBuilder();
		// 运算
		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) == num2.charAt(i)) {
				res.append('0');
			} else {
				res.append('1');
			}
		}
		System.out.print(Integer.parseInt(res.toString(), 2));
	}

	/*
	 * 拍卖商品
	 */
	public static void soleProduct() {
		String[] in1 = scanner.nextLine().split("\\s+");
		// 产品数 顾客数
		int proNum = Integer.parseInt(in1[0]);
		int consNum = Integer.parseInt(in1[1]);
		String[] in2 = scanner.nextLine().split("\\s+");
		int[] prices = new int[consNum];
		for (int i = 0; i < consNum; i++) {
			prices[i] = Integer.parseInt(in2[i]);
		}
		int[] res = new int[2];
		res[1] = Integer.MIN_VALUE;
		for (int priceNow : prices) {
			int w = 0;
			int sum = proNum;
			for (int i = 0; i < consNum; i++) {
				if (prices[i] >= priceNow) {
					if (sum > 0) {
						w += priceNow;
						sum--;
					} else {
						break;
					}
				}
			}
			if (w > res[1]) {
				res[1] = w;
				res[0] = priceNow;
			}
		}
		System.out.print(res[0]);
	}
	
}
