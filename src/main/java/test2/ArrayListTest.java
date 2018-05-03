package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5 };
		PrintArr(arr);
		int[] arr1 = insertElement(arr, 6);
		PrintArr(arr1);
		int[] arr2 = insertElement(arr1, 7);
		PrintArr(arr2);
		int[] arr3 = deleteInArr(arr2, 1);
		PrintArr(arr3);
		System.out.println(Arrays.equals(arr1, arr2));
		List<String> list = new ArrayList<String>();
		StringBuffer buffstr = new StringBuffer("abc");
		String str = "abc";
		System.out.println(str.substring(1, 2));
		// 集合框
		List<Integer> list2 = new ArrayList<Integer>();
	}

	public static int[] insertElement(int[] arr, int target) {
		// system.arraycopy()
		int newlength = arr.length + 1;
		int newIntarr[] = new int[newlength];
		int length = arr.length;
		System.arraycopy(arr, 0, newIntarr, 0, length);
		newIntarr[length] = target;
		return newIntarr;
	}

	// 删除数组上某一个位置上的值
	public static int[] deleteInArr(int[] arr, int index) {
		// index从0开始
		int arrlength = arr.length;
		int[] newarr = new int[arrlength - 1];
		/*
		 * 复制数组的前一段和后一段
		 */
		// arraycopy方法包含前面的位置不包含后面的位置
		System.arraycopy(arr, 0, newarr, 0, index);
		System.arraycopy(arr, index + 1, newarr, index, arrlength - 1 - index);
		return newarr;
	}

	// 将数组最后一个值放到删除值的位置
	// union求并集方法List<?>
	public static HashSet<Integer> union(List<Integer> list1,
			List<Integer> list2) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.addAll(list1);
		set.addAll(list2);
		ArrayList<Integer> res = new ArrayList<>();
		return set;
	}

	public static void PrintArr(int[] arr) {
		if (arr == null) {
			System.out.println("empty");
		} else {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

}
