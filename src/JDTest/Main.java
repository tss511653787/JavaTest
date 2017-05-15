package JDTest;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.valueOf(scan.nextLine());
		double[] Parr = new double[n];
		String[] str = scan.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			Parr[i] = Double.valueOf(str[i]) * 0.01;
		}
		int corrNum = (int) (n * 0.6) + 1;
		int Cc = 0;
		for (int k = corrNum; k <= n; k++) {
			Cc += A(n, k) / A(k, k);
		}
		double Psum = 1.0;
		for (int i = 0; i < n; i++) {
			Psum = Psum * Parr[i];
		}
		double answer = 0.0;
		answer = Cc * Psum;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println(df.format(answer));
	}

	public static int A(int low, int hight) {
		int answer = 1;
		for (int i = 0; i < hight; i++) {
			answer = answer * (low--);
		}
		return answer;
	}
}
