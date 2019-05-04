package XieCheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pro1 {
	static int findMinMis(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer n : A) {
			list.add(n);
		}
		Integer ans = 1;
		while (true) {
			if (!list.contains(ans)) {
				return ans.intValue();
			} else {
				ans++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _A_size = 0;
		_A_size = Integer.parseInt(in.nextLine().trim());
		int[] _A = new int[_A_size];
		int _A_item;
		for (int _A_i = 0; _A_i < _A_size; _A_i++) {
			_A_item = Integer.parseInt(in.nextLine().trim());
			_A[_A_i] = _A_item;
		}

		res = findMinMis(_A);
		System.out.println(String.valueOf(res));

	}

}
