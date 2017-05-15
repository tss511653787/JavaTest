package test1;

public class findNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		System.out.println(find(1, a));
	}

	public static boolean find(int target, int[][] array) {
		int m = array.length;
		int n = array[0].length;
		return compare(target, m - 1, 0, array, m, n);
	}

	public static boolean compare(int target, int m, int n, int[][] array,
			int maxlen, int maxvol) {
		if (m < 0 || m >= maxlen || n < 0 || n >= maxvol) {
			return false;
		}
		if (target == array[m][n]) {
			return true;
		} else if (target > array[m][n]) {
			return compare(target, m, n + 1, array, maxlen, maxvol);
		} else if (target < array[m][n]) {
			return compare(target, m - 1, n, array, maxlen, maxvol);
		} else
			return false;
	}
}
