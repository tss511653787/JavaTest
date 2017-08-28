package ReView2;

/*
 * 常见比较排序和非比较排序的优化整理
 * 比较：选择 冒泡 快排 归并 插入 希尔 堆 二叉树 
 * 非比较：基数 计数 桶排
 * */
public class TenSortOptimize {
	// test
	public static void main(String[] args) {
		int[] small = { 0, 100, 5, 17, 19, 33, 4, 2 };
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		// 对数器验证
		int[] copy = new int[100];
		System.arraycopy(arr, 0, copy, 0, 100);
		intsertSort(arr);
		shellSort(copy);
		for (int i = 0; i < 100; i++) {
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
}
