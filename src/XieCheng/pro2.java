package XieCheng;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class pro2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String in = scanner.nextLine();
		Set<Character> set = new LinkedHashSet<>();
		int len = in.length();
		for (int i = 0; i < len; i++) {
			set.add(in.charAt(i));
		}
		set.forEach(c -> System.out.print(c));
	}

}
