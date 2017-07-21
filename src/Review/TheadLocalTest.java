package Review;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 线程局部变量练习
 * */
/*
 * 不同线程对同一个静态变量进行调用可能出现并发导致静态对象的内部方法破坏
 * 解决：为每一个线程提供一个静态局部变量ThreadLocal类
 * */

public class TheadLocalTest {
	// 一个静态对象
	public static final DateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");
	// 静态线程局部变量
	public static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

	public static void main(String[] args) {
		// 每个线程调用dateFormat
		String date = dateFormat.get().format(new Date());
		System.out.println(date);

	}
}
