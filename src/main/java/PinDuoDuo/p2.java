package PinDuoDuo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class p2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in

		);
		while (scanner.hasNext()) {

			String str1 = scanner.nextLine();
			int n = Integer.parseInt(str1.split(" ")[0]);// 熊
			int m = Integer.parseInt(str1.split(" ")[1]);// 糖
			int[] Bears = new int[n];
			int[] cans = new int[m];
			TreeMap<Integer, Integer> res = new TreeMap<Integer, Integer>(
					new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							// TODO Auto-generated method stub
							return o2 - o1;
						}
					});// 战力

			String str2 = scanner.nextLine();
			for (int i = 0; i < m; i++) {
				cans[i] = Integer.parseInt(str2.split(" ")[i]);
			}
			Arrays.sort(cans);
			for (int i = 0; i < n; i++) {
				String str = scanner.nextLine();
				int key = Integer.parseInt(str.split(" ")[0]);
				Bears[i] = key;
				int value = Integer.parseInt(str.split(" ")[1]);
				res.put(key, value);
			}
			TreeMap<Integer, Integer> result = getResult(n, m, cans, res);
			for (int i = 0; i < n; i++) {
				System.out.println(result.get(Bears[i]));
			}
		}
	}

	private static TreeMap<Integer, Integer> getResult(int n, int m,
			int[] cans, TreeMap<Integer, Integer> res) {
		// TODO Auto-generated method stub
		Iterator<Entry<Integer, Integer>> iters = res.entrySet().iterator();
		while (iters.hasNext()) {
			Map.Entry<Integer, Integer> entry = iters.next();
			int hunger = entry.getValue();
			for (int i = m - 1; i >= 0; i--) {
				if (cans[i] != -1 && hunger >= cans[i]) {
					hunger = hunger - cans[i];
					entry.setValue(hunger);
					cans[i] = -1;
					i = m - 1;
				}
			}
		}
		return res;
	}
}