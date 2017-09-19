package QuNa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Six {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] line1 = scanner.nextLine().split("\\s+");
		int num = Integer.parseInt(line1[0]);
		int pairs = Integer.parseInt(line1[1]);
		String[] line2 = scanner.nextLine().split("\\s+");
		Set<String> names = new HashSet<>();
		for (String na : line2) {
			names.add(na);
		}
		List<String> nameList = new ArrayList<String>();
		for (String s : names) {
			nameList.add(s);
		}
		int size = names.size();
		int[][] maxtrix = new int[size][size];
		int p = 0;
		for (int j = 0; j < pairs; j++) {
			int x = nameList.indexOf(line2[p]);
			int y = nameList.indexOf(line2[p + 1]);
			if (maxtrix[x][y] == 0) {
				maxtrix[x][y] = 1;
			}
			p = p + 2;
		}
		// panduan
		boolean flag = false;
		for (int m = 0; m < num; m++) {
			for (int q = 0; q < num; q++) {
				if (maxtrix[m][q] == 1)
					flag = true;
			}
			for (int k = 0; k < num; k++) {
				if (maxtrix[k][m] == 1)
					flag = true;
			}
		}
		if (!flag) {
			System.out.print("DISCONNECTED");
			return;
		}
		// maxlen
		int max;
		int maxrow = 0;
		for (int i = 0; i < size; i++) {
			int count = 0;
			for (int j = 0; j < size; j++) {
				count += maxtrix[i][j];
			}
			maxrow = count > maxrow ? count : maxrow;
		}
		int maxcol = 0;
		for (int i = 0; i < size; i++) {
			int count = 0;
			for (int j = 0; j < size; j++) {
				count += maxtrix[j][i];
			}
			maxcol = count > maxcol ? count : maxcol;
		}
		max = maxrow > maxcol ? maxrow : maxcol;
		System.out.print(max);
	}

}
