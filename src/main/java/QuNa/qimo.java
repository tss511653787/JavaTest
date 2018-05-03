package QuNa;

import java.util.Scanner;

/**
 * Created by carrbrent on 2017/9/14.
 */
public class qimo {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = scanner.nextLine();
			char[] chars = s.toCharArray();
			for (int j = 0; j < m; j++) {
				if (chars[j] == 'x') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}
		int p = 0;
		int q = 0;
		for (int i = 0; i < m; i = i + 2) {
			for (int j = 0; j < n; j++) {
				p = p + arr[j][i];
			}
		}
		for (int i = 1; i < m; i = i + 2) {
			for (int j = 0; j < n; j++) {
				q = q + arr[j][i];
			}
		}
		System.out.println(Math.max(p, q));

	}
}
