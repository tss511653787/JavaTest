package test3;

public class Sort {

	public static void main(String[] args) {
		int[] arr = { 10, 30, 4, 5, 9, 0, 1 };
		// Methord.PrintArr(Methord.maoPaoSort(arr));
		// Methord.PrintArr(Methord.selectionsort(arr));
		// Methord.PrintArr(Methord.insertSort(arr));
		// Methord.mergeSort(arr, 0, arr.length);
		// Methord.PrintArr(arr);
		Methord.quicksort(arr, 0, arr.length - 1);
		// Methord.PrintArr(arr);
		// Methord.HeapSort(arr);
		Methord.PrintArr(arr);

	}

}

class Methord {
	// 写一个冒泡法
	public static int[] maoPaoSort(int[] arr) {
		int len = arr.length;
		int temp;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] selectionsort(int[] arr) {
		int len = arr.length;
		int temp;
		int big;
		for (int i = len - 1; i >= 0; i--) {
			big = 0;
			for (int j = big + 1; j <= i; j++) {
				if (arr[j] > arr[big]) {
					big = j;
				}
			}
			temp = arr[big];
			arr[big] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	// 插入排序
	public static int[] insertSort(int[] arr) {
		int len = arr.length;
		int temp;
		for (int i = 1; i < len; i++) {
			// 从第二个元素开始 一次插入到排序数组中
			temp = arr[i];
			int j = i;
			// 确定插入的位置
			while (j > 0 && temp < arr[j - 1]) {
				// 还没有达到条件就继续后移
				arr[j] = arr[j - 1];
				j--;
			}
			// 放入合适的位置
			arr[j] = temp;
		}
		return arr;

	}

	// 合并排序：递归思想
	public static void merge(int[] data, int first, int n1, int n2) {
		// first 是从数则的哪个位置开始
		// data 是已经分割成2段的数组 前n1和后n2
		// 结果从小到大排列
		int[] temp = new int[n1 + n2];
		// 初始化三个统计指标的值
		int copyedn1 = 0;
		int copyedn2 = 0;
		int copyed = 0;
		while ((copyedn1 < n1) && (copyedn2 < n2)) {
			// 两个数组中还有元素需要被复制
			if (data[first + copyedn1] < data[first + n1 + copyedn2]) {
				temp[copyed] = data[first + copyedn1];
				copyed++;
				copyedn1++;
			} else {
				temp[copyed] = data[first + n1 + copyedn2];
				copyed++;
				copyedn2++;
			}
		}
		while (copyedn1 < n1) {
			temp[copyed] = data[first + copyedn1];
			copyed++;
			copyedn1++;
		}
		while (copyedn2 < n2) {
			temp[copyed] = data[first + n1 + copyedn2];
			copyed++;
			copyedn2++;
		}
		for (int i = 0; i < n1 + n2; i++) {
			data[first + i] = temp[i];
		}
	}

	public static void mergeSort(int[] data, int first, int n) {
		// 递归的思想对数组进行合并排序
		int n1;
		int n2;
		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;
			mergeSort(data, first, n1);
			mergeSort(data, first + n1, n2);
			merge(data, first, n1, n2);
		}
	}

	// 快速排序的Patition方法
	public static int quickPartition(int[] data, int low, int high) {
		// first 是数组开始的位置 n是数组中元素的个数 返回值是交换基准值后的下标
		// 取数组的第一个值为target值
		int target = data[low];
		int temp;
		while (low < high) {
			while ((high > low) && (data[high] > target)) {
				high--;
			}
			while ((high > low) && (data[low] < target)) {
				low++;
			}
			temp = data[low];
			data[low] = data[high];
			data[high] = temp;
		}
		data[high] = target;
		return high;
	}

	// 快速排序的递归方法
	public static void quicksort(int[] data, int low, int high) {
		// 分割的思想
		int piv;
		if (low < high) {
			piv = quickPartition(data, low, high);
			quicksort(data, low, piv - 1);
			quicksort(data, piv + 1, high);
		}

	}

	public static void PrintArr(int[] arr) {
		for (int number : arr) {
			System.out.print(number + " ");
		}

	}

	// 堆排序
	public static void HeapSort(int[] data) {
		// 将具有N个元素的数组装化成堆
		int[] arr = data;
		int unsorted = arr.length;
		int temp;
		// 数组调整成堆
		makeHeap(arr, unsorted);
		while (unsorted > 1) {
			unsorted--;
			temp = arr[0];
			arr[0] = arr[unsorted];
			arr[unsorted] = temp;
			// 重新对数组进行堆调整
			makeHeap(arr, unsorted);
		}
	}

	public static void makeHeap(int[] data, int n) {
		int temp;
		for (int i = 1; i < n; i++) {
			if (data[i] > data[parent(i)]) {
				// 从非跟节点开始 如果比双亲大就交换
				temp = data[parent(i)];
				data[parent(i)] = data[i];
				data[i] = temp;
			}
		}
	}

	public static int parent(int n) {
		return (n - 1) / 2;
	}
}
