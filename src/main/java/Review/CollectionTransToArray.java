package Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 集合和数组的相互转化总结
 * */
public class CollectionTransToArray {
	public static void main(String[] args) {
		// String 类型 以及其他封装类型的数组和list的转换
		// 数组转为list
		String[] strs = { "" };
		List<String> str_list = new ArrayList<String>(Arrays.asList(strs));
		String[] back_arr = str_list.toArray(new String[str_list.size()]);
		// 8中基本类型的数组和list转化就必须麻烦方法了
		// 因为需要封装
		int[] arr_int = new int[10];
		List<Integer> int_list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int_list.add(arr_int[i]);
		}
		// 回转型代码略
	}

}
