package NiuKeBook;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BaiDu_1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		interestingSort();
	}

	/*
	 * 买帽子？
	 */
	public static void buyCaP() {
		int capNum = Integer.parseInt(scanner.nextLine());
		String[] caps = scanner.nextLine().split("\\s+");
		Set<Integer> set = new TreeSet<Integer>();
		for (String s : caps) {
			set.add(Integer.valueOf(s));
		}
		if (set.size() >= 3) {
			int flag = 0;
			for (Integer n : set) {
				if (flag == 2) {
					System.out.print(n);
					break;
				} else {
					flag++;
				}
			}
		} else {
			System.out.print(-1);
		}
	}

	/*
	 * 度度熊回家 暴力法
	 */
	public static void BeerbackToHome() {
		int len = Integer.parseInt(scanner.nextLine());
		String[] inArr = scanner.nextLine().split("\\s+");
		int min = Integer.MAX_VALUE;
		// 从排除0和n-1坐标选择忽略点
		for (int i = 1; i < len - 1; i++) {
			List<Integer> points = new ArrayList<>();
			for (String s : inArr) {
				points.add(Integer.parseInt(s));
			}
			points.remove(i);
			int start = points.get(0);
			int sum = 0;
			for (int j = 1; j < points.size(); j++) {
				int nextpoint = points.get(j);
				if (nextpoint > start) {
					sum += (nextpoint - start);
				} else if (nextpoint < start) {
					sum += (start - nextpoint);
				} else {
					// do nothing
				}
				start = nextpoint;
			}
			min = sum < min ? sum : min;
		}
		System.out.print(min);
	}

	/*
	 * 求空间三角形面积海伦公式求解
	 */
	public static void TriangleArea() {
		int num = Integer.parseInt(scanner.nextLine());
		if (num < 3) {
			System.out.println("无法组成三角形");
			return;
		}
		Triangle[] triangles = new Triangle[num];
		for (int i = 0; i < num; i++) {
			String[] in = scanner.nextLine().split("\\s+");
			triangles[i] = new Triangle(in[0], Integer.parseInt(in[1]),
					Integer.parseInt(in[2]), Integer.parseInt(in[3]));
		}
		double max = Double.MIN_VALUE;
		for (int i = 0; i <= num - 3; i++) {
			for (int j = i + 1; j < num; j++) {
				for (int k = j + 1; k < num; k++) {
					// 判断三个点是否满足条件
					Triangle a = triangles[i];
					Triangle b = triangles[j];
					Triangle c = triangles[k];
					if ((a.sameArea(b) && b.sameArea(c))
							|| (!a.sameArea(b) && !b.sameArea(c) && !a
									.sameArea(c))) {
						double area = Area(a, b, c);
						max = area > max ? area : max;
					}
				}
			}
		}
		Format format = new DecimalFormat("0.00000");
		System.out.print(format.format(max));
	}

	public static double Area(Triangle a, Triangle b, Triangle c) {
		// TODO Auto-generated method stub
		double ab = LengthTriangle(a, b);
		double bc = LengthTriangle(b, c);
		double ac = LengthTriangle(a, c);
		double p = 0.5 * (ab + bc + ac);
		return Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
	}

	public static double LengthTriangle(Triangle a, Triangle b) {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)
				+ Math.pow(a.z - b.z, 2));
	}

	/*
	 * 有趣的排序 求原数列和排序后数列 求数列在排序后出列前缀中的最长值
	 */
	public static void interestingSort() {
		int num = Integer.parseInt(scanner.nextLine());
		int[] array = new int[num];
		int[] sortedArray = new int[num];
		String[] in = scanner.nextLine().split("\\s+");
		// 5 initial
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(in[i]);
		}
		System.arraycopy(array, 0, sortedArray, 0, num);
		Arrays.sort(sortedArray);
		int max = 0;
		int j = 0;
		int sum = 0;
		for (int i = 0; i < num;) {
			if (sortedArray[j] == array[i]) {
				sum++;
				i++;
				j++;
			} else {
				i++;
			}
		}
		if (sum > max)
			max = sum;
		System.out.print(num - max);
	}
}

// class Triangle
class Triangle {
	String area;
	int x;
	int y;
	int z;

	public Triangle(String area, int x, int y, int z) {
		super();
		this.area = area;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean sameArea(Triangle t) {
		if (t.area.equals(area)) {
			return true;
		} else {
			return false;
		}
	}
}
