package MianShiBaoDian;

import java.util.ArrayList;
import java.util.List;

public class TenSortAlgorithm {
	// 十大常用排序算法复习
	public static void main(String[] args) {
		// 测试数组
		int[] arr = { 521, 310, 72, 373, 15, 546, 385, 856, 187, 147 };
		// mergeSort(arr, 0, arr.length);
		// heapsort(arr);
		// shellSort(arr);
		// print(arr);
		// jishuSort(arr);
		// 升序排列
		// RadixSort(arr);
		maopaoSort(arr);
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	// 冒泡排序
	public static void maopaoSort(int[] arr) {
		int len = arr.length;
		int temp;
		for (int i = 0; i < len; i++)
			/*
			 * 每次把大数冒到末尾
			 */
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
	}

	// 选择排序
	// ???
	public static void selectSort(int[] arr) {
		int len = arr.length;
		int temp;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	// 插入排序
	public static void intsetSort(int[] arr) {
		int len = arr.length;
		int target;
		// 从第二个数开始插入
		for (int i = 1; i < len; i++) {
			int j = 0;
			for (; j < i; j++) {
				if (arr[j] <= arr[i]) {
				} else {
					break;
				}
			}
			target = arr[i];
			for (int m = i; m > j; m--) {
				arr[m] = arr[m - 1];
			}
			arr[j] = target;
		}
	}

	// shell排序
	// 关键在于步长的确定上 一般是n/2 每次都/2
	public static void shellSort(int[] arr) {
		int len = arr.length;
		int b = arr.length / 2;
		int target;
		// 每次步长都/2
		for (; b > 0; b = b / 2) {
			// 分组
			for (int i = 0; i < b; i++) {
				// 对分好组的元素进行插入排序
				for (int j = i + b; j < len; j += b) {
					int k = i;
					for (; k < j; k += b) {
						if (arr[k] <= arr[j]) {
						} else {
							break;
						}
					}
					target = arr[j];
					for (int m = j; m > k; m -= b) {
						arr[m] = arr[m - b];
					}
					arr[k] = target;
				}
			}
		}
	}

	// 快排
	public static void quickSortAll(int[] arr, int low, int hight) {
		if (low < hight) {
			int mid = quicksort(arr, low, hight);
			quickSortAll(arr, low, mid - 1);
			quickSortAll(arr, mid + 1, hight);
		}

	}

	private static int quicksort(int[] arr, int low, int hight) {
		// TODO Auto-generated method stub
		// 将第一个数作为target标志
		int targrt = arr[low];
		while (low < hight) {
			while (arr[hight] >= targrt) {
				hight--;
			}
			arr[low] = arr[hight];
			while (arr[low] < targrt) {
				low++;
			}
			arr[hight] = arr[low];
		}
		arr[hight] = targrt;
		return hight;
	}

	// 归并排序
	public static void mergeSort(int[] arr, int first, int n) {
		// first:从那个位置开始 这里是0
		// first开始后面多少个元素排序这里是数组的长度
		// 长度不为0则分割
		if (n > 1) {
			// 分割
			int n1 = n / 2;
			int n2 = n - n1;
			mergeSort(arr, first, n1);
			mergeSort(arr, first + n1, n2);
			// 合并
			merge(arr, first, n1, n2);
		}
	}

	private static void merge(int[] arr, int first, int n1, int n2) {
		// TODO Auto-generated method stub
		int copyed = 0;
		int copyed1 = 0;
		int copyed2 = 0;
		int[] copy = new int[n1 + n2];
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
		for (int i = 0; i < n1 + n2; i++) {
			arr[first + i] = copy[i];
		}
	}

	// 堆排序
	public static void heapsort(int[] arr) {
		int n = arr.length - 1;
		while (n > 0) {
			// 建立大顶堆
			// 每次把堆顶数字和数组尾数字交换
			makeheap(arr, n);
			int temp;
			temp = arr[0];
			arr[0] = arr[n];
			arr[n] = temp;
			n--;
		}
	}

	// *****这里非常值得注意 建堆的过程是从后向前建堆 从最后一个需要建堆的节点开始
	private static void makeheap(int[] arr, int n) {
		// TODO Auto-generated method stub
		int temp;
		for (int i = n; i >= 1; i--) {
			if (i % 2 != 0) {
				// 左节点
				if (arr[i] > arr[i / 2]) {
					temp = arr[i];
					arr[i] = arr[i / 2];
					arr[i / 2] = temp;
				}
			} else {
				// 右节点
				if (arr[i] > arr[i / 2 - 1]) {
					temp = arr[i];
					arr[i] = arr[i / 2 - 1];
					arr[i / 2 - 1] = temp;
				}
			}
		}
	}

	/*
	 * 非常见排序
	 */

	// 计数排序
	// 目前看到的适用条件是0-max的自然数 应该可以扩展，先大致学习一下基本思路
	public static void jishuSort(int[] arr) {
		int max = findmax(arr);
		int[] tempC = new int[max + 1];
		int[] tempB = new int[arr.length];
		// 对数组arr遍历统计每个元素出现的个数
		for (int i = 0; i < arr.length; i++) {
			tempC[arr[i]]++;
		}
		// 将数组C转化为统计<=当前位置上元素的个数
		int[] copyC = new int[max + 1];
		for (int i = 0; i < max + 1; i++) {
			copyC[i] = tempC[i];
		}
		//
		for (int i = 0; i < max + 1; i++) {
			int count = 0;
			for (int j = 0; j <= i; j++) {
				count += copyC[j];
			}
			tempC[i] = count;
		}
		/*
		 * tempB输出结果 关键代码
		 */
		for (int k = arr.length - 1; k >= 0; k--) {
			int num = arr[k];
			tempB[tempC[num] - 1] = num;
			tempC[num]--;
		}
		for (int out : tempB) {
			System.out.print(out + " ");
		}
	}

	private static int findmax(int[] arr) {
		// TODO Auto-generated method stub
		int max = arr[0];
		for (int n : arr) {
			if (n > max)
				max = n;
		}
		return max;
	}

	// 桶排序
	// 桶排序的思路很简单 适用条件是已知数组的最大范围(最小范围也已知 需要在空桶做标记)情况 建立相应多的桶 然后将数放入到桶中,然后遍历桶得到结果

	// 基数排序的收集 分配
	// 思路:按照从最低位到最高位进行分配 然后收集
	public static void RadixSort(int[] arr) {
		// 获取数组中最大数字的位数
		int max = findMax(arr);
		int lenmax = findLen(max);
		// 建立10个桶
		ArrayList[] arrlist = new ArrayList[10];
		for (int i = 0; i < 10; i++) {
			arrlist[i] = new ArrayList<Integer>();
		}
		// 进行lenmax次分配和收集
		for (int i = 1; i <= lenmax; i++) {
			// 分配
			for (int j = 0; j < arr.length; j++) {
				int number = arr[j];
				int n = GetNumInPos(number, i);
				arrlist[n].add(number);
			}
			// 收集
			int[] copyarr = new int[arr.length];
			int l = 0;
			for (int k = 0; k < 10; k++) {
				if (arrlist[k].size() != 0) {
					for (int m = 0; m < arrlist[k].size(); m++) {
						copyarr[l++] = (int) arrlist[k].get(m);
					}
					// 清空桶
					arrlist[k].clear();
				}
			}
			// 覆盖原数组
			l = 0;
			for (; l < arr.length; l++) {
				arr[l] = copyarr[l];
			}
		}
	}

	private static int GetNumInPos(int num, int pos) {
		int temp = 1;
		for (int i = 0; i < pos - 1; i++)
			temp *= 10;
		return (num / temp) % 10;
	}

	private static int findLen(int max) {
		// TODO Auto-generated method stub
		String number = String.valueOf(max);
		return number.length();
	}

	private static int findMax(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null)
			return 0;
		else {
			int max = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max)
					max = arr[i];
			}
			return max;
		}
	}

}
