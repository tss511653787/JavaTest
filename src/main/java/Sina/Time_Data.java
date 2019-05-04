package Sina;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Time_Data {
	static Scanner scanner = new Scanner(System.in);
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws ParseException {
		String d1 = scanner.nextLine();
		String d2 = scanner.nextLine();

		Date day1 = format.parse(d1);
		Date day2 = format.parse(d2);
		long betweenday = -(((day1.getTime() - day2.getTime()) / (1000 * 60 * 60 * 24)) + 1);
		int start = dateToWeek(d1);
		start++;
		long count = 0;
		for (long i = 0; i < betweenday - 1; i++) {
			if (start > 6) {
				start = 0;
			}
			if (start == 4) {
				count++;
				start++;
			} else {
				start++;
			}
		}
		System.out.print(betweenday + " " + count);
	}

	public static int dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return w;
	}

}
