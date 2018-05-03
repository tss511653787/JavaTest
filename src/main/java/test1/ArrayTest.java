package test1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrStr = new String[5];
		arrStr[0] = new String("abb");
		String[] arr = { "abc", "b", "c", "d", "b" };
		// 二分查找a
		int loc = Arrays.binarySearch(arr, "b");
		System.out.println(loc);
		// java日期处理
		Date today = new Date();
		System.out.println(today);
		// SimpleDateFormat中y固定表示年 大M固定月 大H固定小时 小m固定分钟,更多格式百度
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		String time = format.format(today);
		System.out.println(time);
		String strFormat = String.format("Today time: %tc", today);
		System.out.printf(strFormat);

	}
}
