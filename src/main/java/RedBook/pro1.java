package RedBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pro1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String str = scanner.nextLine();
		str = str.replaceAll("RED", "");
		String strs[] = str.split("[A-Z]+");
		long max = -1;
		// for (int i = 0; i < strs.length; i++) {
		// if (!strs[i].equals("")) {
		// long number = Long.parseLong(strs[i]);
		// if (max < number) {
		// max = number;
		// }
		// }
		// }
		// System.out.println(max);
		int max_index = -1;
		int maxlen = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() > maxlen) {
				maxlen = strs[i].length();
				max_index = i;
			}
		}
		if (max_index != -1) {
			System.out.print(strs[max_index]);
		} else {
			System.out.print(-1);
		}
	}

}
