package Toutiao;

import java.util.HashSet;
import java.util.Scanner;

public class Uid {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashSet<Long> set = new HashSet<>();
		while (true) {
			long a = scan.nextLong();
			if (a == 0)
				break;
			set.add(a);
		}
		System.out.print(set.size());
	}
}
