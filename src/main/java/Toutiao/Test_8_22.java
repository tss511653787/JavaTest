package Toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 8.22
 * */
public class Test_8_22 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ZuoBiaoMax();
	}

	public static void ZuoBiaoMax() {
		int num = Integer.parseInt(scanner.nextLine());
		Point[] points = new Point[num];
		// inital
		for (int i = 0; i < num; i++) {
			String[] in = scanner.nextLine().split("\\s+");
			points[i] = new Point(Long.parseLong(in[0]), Long.parseLong(in[1]));
		}
		List<Point> res = new ArrayList<Point>();
		for (int i = 0; i < num; i++) {
			Point now = points[i];
			int j = 0;
			for (; j < num; j++) {
				if (i == j) {
					// same point
				} else if (!now.Panduan(points[j])) {
					break;
				}
			}
			if (j == num) {
				res.add(now);
			}
		}
		Collections.sort(res, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return (int) (o1.x - o2.x);
			}

		});
		res.forEach(p -> System.out.println(p.x + " " + p.y));
	}

}

class Point {
	long x;
	long y;

	public Point(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}

	public boolean Panduan(Point p) {
		if (x > p.x) {
			return true;
		} else if (x <= p.x && y > p.y) {
			return true;
		} else {
			return false;
		}
	}
}
