package BigData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigSort {
	static int k = 10;

	public static void main(String[] args) {
		int num = 100;
		int[] arr = new int[num];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			arr[i] = (int) (100 * (Math.random()));
			list.add(arr[i]);
		}
		bigsort(arr);
		outPrint(arr, k);
		System.out.println();
		Collections.sort(list);
		Collections.reverse(list);
		list.forEach(x -> System.out.print(x + " "));
	}

	private static void outPrint(int[] arr, int k) {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void bigsort(int[] arr) {
		// 复杂度：O(n)+O((n-k)*logk)
		// TODO Auto-generated method stub
		// 前k个元素进行一个logn复杂度的排序
		mergeSort(arr, 0, k);
		// 后面n-k个元素进行替换
		for (int i = k; i < arr.length; i++) {
			int j = 0;
			while (j < k && arr[j] >= arr[i]) {
				j++;
			}
			if (j != k) {
				// 替换
				arr[j] = arr[i];
				mergeSort(arr, 0, k);
			}
		}
	}

	private static void mergeSort(int[] arr, int first, int n) {
		// TODO Auto-generated method stub
		if (n > 1) {
			int n1 = n / 2;
			int n2 = n - n1;
			mergeSort(arr, first, n1);
			mergeSort(arr, first + n1, n2);
			merge(arr, first, n1, n2);
		}
	}

	private static void merge(int[] arr, int first, int n1, int n2) {
		// TODO Auto-generated method stub
		int copyed = 0;
		int copyed1 = 0;
		int copyed2 = 0;
		int[] copy = new int[n1 + n2];
		while (copyed1 < n1 && copyed2 < n2) {
			if (arr[first + copyed1] < arr[first + n1 + copyed2]) {
				copy[copyed++] = arr[first + copyed1++];
			} else {
				copy[copyed++] = arr[first + n1 + copyed2++];
			}
		}
		while (copyed1 < n1) {
			copy[copyed++] = arr[first + copyed1++];
		}
		while (copyed2 < n2) {
			copy[copyed++] = arr[first + n1 + copyed2++];
		}
		for (int j = 0; j < n1 + n2; j++) {
			arr[first + j] = copy[j];
		}
	}

}
