package test3;

public class SearchCode {
	public static int binarySearch(int[] array, int target) {
		// 使用非递归实现二分查找
		// 输入的数组是递增排列
		// 返回值是数组的下标 如果没有找到则返回1
		int len = array.length;
		int left = 0;
		int right = len - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;// 没有找到
	}

	// 递归方法实现二分查找
	public static int BinarySearch(int[] array, int first, int size, int target) {
		int mid;
		if (size > 0) {
			mid = first + size / 2;
			if (array[mid] > target)
				return BinarySearch(array, first, size / 2, target);
			else if (array[mid] == target) {
				return mid;
			} else {
				return BinarySearch(array, mid + 1, (size - 1) / 2, target);
			}
		} else
			return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// System.out.println(binarySearch(arr, 9));
		System.out.println(BinarySearch(arr, 0, 9, 9));

	}
}
