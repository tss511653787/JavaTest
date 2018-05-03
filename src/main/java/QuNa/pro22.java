package QuNa;

import java.util.*;

public class pro22 {

	public static String r = "";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();

		Map<String, Integer> map = new HashMap();

		int[][] guanxi = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					guanxi[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < r; i++) {
			String name1 = in.next();
			String name2 = in.next();
			if (!map.containsKey(name1))
				map.put(name1, map.size());
			if (!map.containsKey(name2))
				map.put(name2, map.size());
			guanxi[map.get(name1)][map.get(name2)] = 1;
			guanxi[map.get(name2)][map.get(name1)] = 1;
		}

		for (int x = 0; x < n; x++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (guanxi[i][x] < Integer.MAX_VALUE
							&& guanxi[x][j] < Integer.MAX_VALUE
							&& guanxi[i][j] > guanxi[i][x] + guanxi[x][j]) {
						guanxi[i][j] = guanxi[i][x] + guanxi[x][j];
					}
				}
			}
		}

		boolean flag = false;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (guanxi[i][j] == Integer.MAX_VALUE) {
					flag = true;
					break;
				} else {
					if (guanxi[i][j] > max) {
						max = guanxi[i][j];
					}

				}

			}
		}
		if (flag) {
			System.out.println("DISCONNECTED");
		} else {
			System.out.println(max);
		}
		in.close();
	}

}
