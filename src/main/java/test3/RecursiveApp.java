package test3;

public class RecursiveApp {
	public static void main(String[] args) {
		// PrintInt(-567886);
		// System.out.println(pow(5.0, -9));
		// FribnaPrint(10);
		hanoi(3, 'A', 'B', 'C');
	}

	public static void PrintInt(int number) {
		// 递归打印一个整数 可以是负数
		if (number > 0) {
			if (number < 10) {
				// 只有一位 打印
				System.out.println(number);
			} else {
				PrintInt(number / 10);
				System.out.println(number % 10);
			}
		} else {
			System.out.println("-");
			PrintInt(-number);
		}
	}

	public static double pow(Double x, int n) {
		if (x == 0 && n <= 0) {
			System.out.println("error");
			return 0.0;
		} else if (x == 0) {
			return 0.0;
		} else if (n == 0) {
			return 1.0;
		} else if (n < 0) {
			return 1 / pow(x, -n);
		} else {
			return x * pow(x, n - 1);
		}
	}

	public static void FribnaPrint(int num) {
		// 打印斐波那契数列的前n项
		for (int i = 0; i <= num; i++) {

			System.out.print(Fibonacci(i) + " ");

		}
	}

	public static int Fibonacci(int x) {
		// x是项的个数
		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		} else {
			return Fibonacci(x - 1) + Fibonacci(x - 2);
		}

	}

	// 汉诺塔算法
	public static void hanoi(int n, char from, char temp, char to) {
		// 有n个大小不同的盘子，从from到to 中间借助temp
		if (n == 1) {
			// n==1直接挪动
			move(n, from, to);
		} else {
			// 借助目的 把前n-1个盘子挪动到temp上
			hanoi(n - 1, from, to, temp);
			// 把最后剩的一个盘子挪到目的塔上
			move(n, from, to);
			// 把temp上的n-1个盘子借助from移动到to上
			hanoi(n - 1, temp, from, to);
		}
	}

	public static void move(int n, char from, char to) {
		System.out.println("Disk" + n + " from" + from + "to " + to);
	}
}
