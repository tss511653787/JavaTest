package ReView2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * 常见比较排序和非比较排序的优化整理
 * 比较：选择 冒泡 快排 归并 插入 希尔 堆 二叉树 
 * 非比较：基数 计数 桶排
 * */
public class TenSortOptimize {
	// test
	public static void main(String[] args) {
		int[] small = { 0, 100, 5, 17, 19, 33, 4, 2 };
		int n = 100000;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		// 对数器验证
		int[] copy = new int[n];
		System.arraycopy(arr, 0, copy, 0, n);
		intsertSort(arr);
		JiShuSort(copy);
		for (int i = 0; i < n; i++) {
			if (arr[i] != copy[i]) {
				System.out.print("wrong");
				break;
			}
		}
	}

	// out
	public static void outRes(int[] array) {
		for (int n : array) {
			System.out.print(n + " ");
		}
	}

	// 插入 O(n2)
	public static void intsertSort(int[] array) {
		int len = array.length;
		for (int i = 1; i < len; i++) {
			int target = array[i];
			int j = 0;
			// find>array[i]位置
			for (; j < i; j++) {
				if (array[j] <= array[i]) {
				} else {
					break;
				}
			}
			// 后移
			int m = i;
			while (m > j) {
				array[m] = array[m - 1];
				m--;
			}
			// insert
			array[j] = target;
		}
	}

	// 选择
	public static void selectSort(int[] array) {
		int temp;
		int len = array.length;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				if (array[i] > array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
	}

	// 冒泡排序的2个优化
	// 方法1；设置一个flag标记 发生交换则flag = true 默认值为false 如果某一轮flag一直是false的说明已经排序完成 结束排序
	public static void MaoPao1(int[] arr) {
		int temp;
		int len = arr.length;
		boolean flag = false;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				return;
			}
		}
	}

	// 方法2：2个指针从2个方向斤进行遍历 记录最后交换的位置为lastswap 说明lastswap到j中所有的元素已排好
	// 则直接跳到lastswap位置即可
	public static void MaoPao2(int[] arr) {
		int temp;
		int len = arr.length;
		int lastswap;
		for (int j = len - 1; j > 0; j = lastswap) {
			lastswap = 0;
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					lastswap = i;
				}
			}
		}
	}

	// 快排
	public static void QuickSort(int[] arr) {
		int len = arr.length;
		int low = 0;
		int high = len - 1;
		quickSort(arr, low, high);
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int mid = quick(arr, low, high);
			quickSort(arr, low, mid - 1);
			quickSort(arr, mid + 1, high);
		}
	}

	private static int quick(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		// target value
		int target = arr[low];
		while (low < high) {
			while ((low < high) && (arr[high] >= target)) {
				high--;
			}
			arr[low] = arr[high];
			while ((low < high) && (arr[low] < target)) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[high] = target;
		return high;
	}

	// 堆排序
	// 大顶堆
	public static void HeapSort(int[] arr) {
		int temp;
		int len = arr.length;
		int j = len - 1;
		while (j > 0) {
			makeHeap(arr, j);
			temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
			j--;
		}
	}

	public static void makeHeap(int[] arr, int j) {
		// TODO Auto-generated method stub
		int temp;
		// k>0对顶部不用加入调整
		for (int k = j; k > 0; k--) {
			if (k % 2 == 0) {
				// 右孩子
				if (arr[k] > arr[k / 2 - 1]) {
					temp = arr[k];
					arr[k] = arr[k / 2 - 1];
					arr[k / 2 - 1] = temp;
				}
			} else {
				// 左孩子
				if (arr[k] > arr[k / 2]) {
					temp = arr[k];
					arr[k] = arr[k / 2];
					arr[k / 2] = temp;
				}
			}
		}
	}

	// 归并
	public static void MergeSort(int[] arr) {
		int len = arr.length;
		mergeSort(arr, 0, len);
	}

	public static void mergeSort(int[] arr, int first, int n) {
		// TODO Auto-generated method stub
		// n是整个的长度
		if (n > 1) {
			int n1 = n / 2;
			int n2 = n - n1;
			mergeSort(arr, first, n1);
			mergeSort(arr, first + n1, n2);
			merge(arr, first, first + n1, n1, n2);
		}
	}

	public static void merge(int[] arr, int first, int last, int n1, int n2) {
		// TODO Auto-generated method stub
		// copy arr
		int[] copy = new int[n1 + n2];
		int copyed = 0;
		int copyed1 = 0;
		int copyed2 = 0;
		while ((copyed1 < n1) && (copyed2 < n2)) {
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
		// 覆盖元数组
		for (int i = 0; i < n1 + n2; i++) {
			arr[first + i] = copy[i];
		}
	}

	// shell
	public static void shellSort(int[] array) {
		int len = array.length;
		for (int d = len / 2; d > 0; d = d / 2) {
			for (int i = 0; i < d; i++) {
				// 从划分的第一个数开始
				for (int j = i + d; j < len; j = j + d) {
					int target = array[j];
					int p = i;
					for (; p < j; p += d) {
						if (array[p] <= target) {
						} else {
							break;
						}
					}
					int m = j;
					while (m > p) {
						array[m] = array[m - d];
						m -= d;
					}
					array[p] = target;
				}
			}
		}
	}

	// 二叉树排序算法：其思想就是用过一个BST(二叉搜索书进行插入) 结果就是中序遍历结果
	public static void BSTsort(int[] array) {
		if (array.length == 1) {
			return;
		}
		BST root = new BST(array[0], null, null);
		BST p = root;
		int len = array.length;
		// insert
		for (int i = 1; i < len; i++) {
			int target = array[i];
			while (true) {
				if (p.data >= target) {
					// left
					if (p.left != null) {
						p = p.left;
					} else {
						p.left = new BST(target, null, null);
						p = root;
						break;
					}
				} else {
					if (p.right != null) {
						p = p.right;
					} else {
						p.right = new BST(target, null, null);
						p = root;
						break;
					}
				}
			}
		}
		int[] copy = inOrderPrint(root, len);
		for (int i = 0; i < len; i++) {
			array[i] = copy[i];
		}
	}

	public static int[] inOrderPrint(BST root, int len) {
		int[] res = new int[len];
		int i = 0;
		Stack<BST> stk = new Stack<>();
		BST p = root;
		while (p != null || !stk.isEmpty()) {
			while (p != null) {
				stk.push(p);
				p = p.left;
			}
			if (!stk.isEmpty()) {
				BST out = stk.pop();
				res[i++] = out.data;
				p = out.right;
			}
		}
		return res;
	}

	// 桶排序
	// 一个全部值全建立数组的特殊实现 时间复杂度O(n) 但是空间复杂度是max-min
	public static void easyBucketSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int n : arr) {
			max = max > n ? max : n;
			min = min < n ? min : n;
		}
		int len = max - min + 1;
		int[] bucket = new int[len];
		// initail 0
		for (int x : arr) {
			bucket[x - min]++;
		}
		int[] copy = new int[arr.length];
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (bucket[i] != 0) {
				int num = bucket[i];
				while (num > 0) {
					copy[j++] = i + min;
					num--;
				}
			}
		}
		// copy
		for (int i = 0; i < arr.length; i++) {
			arr[i] = copy[i];
		}
	}

	// 基数排序
	public static void JiShuSort(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int n : arr) {
			list.add(n);
		}
		// 桶
		ArrayList[] buckets = new ArrayList[10];
		for (int i = 0; i < 10; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		int max = Collections.max(list);
		String maxS = String.valueOf(max);
		int len = maxS.length();
		for (int i = 0; i < len; i++) {
			// 分散
			for (int num : list) {
				int p = TiQu(num, i);
				buckets[p].add(num);
			}
			// 收集
			List<Integer> temp = new ArrayList<>();
			for (int m = 0; m < 10; m++) {
				if (buckets[m].size() != 0) {
					for (int j = 0; j < buckets[m].size(); j++) {
						temp.add((Integer) buckets[m].get(j));
					}
					buckets[m].clear();
				}
			}
			list.clear();
			list.addAll(temp);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
	}

	public static int TiQu(int num, int i) {
		// TODO Auto-generated method stub
		int chu = 1;
		for (int j = 0; j < i; j++) {
			chu *= 10;
		}
		return (num / chu) % 10;
	}
}

class BST {
	int data;
	BST left;
	BST right;

	public BST(int data, BST left, BST right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
