package test2;

public class RemoveSpace {
	public static int mut(int num, int many) {
		int res = 1;
		for (int i = 0; i < many; i++) {
			res = res * num;
		}
		return res;
	}

	public int NumberOf1(int n) {
		int sum = 0;
		if (n == 0)
			sum = 0;
		else if (n > 0) {
			// n是正整数

		}
		return sum;

	}

	public static void main(String[] args) {
		String str = Integer.toBinaryString(5);
		int len = str.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == '1') {
				count = count + 1;
			}
		}
		System.out.println(count);
	}
}
