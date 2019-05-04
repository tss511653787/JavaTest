package HuaWeiTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Niuke7 {
	public static void main(String[] args) {
		// int[] arr = { 2, 3, 4, 2, 6, 2, 5, 1 };
		// ArrayList<Integer> list = maxInWindows(arr, 3);
		ArrayList<ArrayList<Integer>> res = FindContinuousSequence(100);
		System.out.println(res);
	}

	static ArrayList<Integer> list = null;

	static public void Insert(Integer num) {
		if (list == null) {
			list = new ArrayList<>();
			list.add(num);
			Collections.sort(list);
		} else {
			list.add(num);
			Collections.sort(list);
		}
	}

	static public Double GetMedian() {
		int len = list.size() - 1;
		double answer = 0.0;
		if (len % 2 == 0) {
			answer = list.get(len / 2);
			return answer;
		} else {
			int n1 = list.get(len / 2);
			int n2 = list.get(len / 2 + 1);
			answer = 0.5 * (n1 + n2);
			return answer;
		}
	}

	// 滑动窗口判断当前最大值
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> maxArr = new ArrayList<>();
		for (int i = 0; i + size - 1 < num.length; i++) {
			int j = i + size - 1;
			int max = findmax(num, i, j);
			maxArr.add(max);
		}
		return maxArr;
	}

	private static int findmax(int[] num, int i, int j) {
		// TODO Auto-generated method stub
		int max = num[i];
		for (int k = i; k <= j; k++) {
			if (num[k] > max)
				max = num[k];
		}
		return max;
	}

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		for (int i = 2; sumNumber(i) < sum; i++) {
			if ((sum - sumNumber(i)) % i == 0) {
				ArrayList<Integer> list = new ArrayList<>();
				int first = (sum - sumNumber(i)) / i;
				list.add(first);
				for (int k = 1; k < i; k++) {
					list.add(first + k);
				}
				answer.add(list);
			}
		}
		Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.get(0) < o2.get(0)) {
					return -1;
				} else if (o1.get(0) == o2.get(0)) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		return answer;
	}

	public static int sumNumber(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			sum = sum + i;
		}
		return sum;
	}

}
