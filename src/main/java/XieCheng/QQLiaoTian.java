package XieCheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class QQLiaoTian {
	static Scanner scanner;
	static String file_path = "C://Users//Administrator//Desktop//i.txt";
	static File file_in;
	static File file_out;
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws FileNotFoundException {
		file_in = new File(file_path);
		scanner = new Scanner(file_in);
		if (scanner != null) {
			map = new HashMap<>();
		}
		while (scanner.hasNext()) {
			String[] line = scanner.nextLine().trim().split("\\s+");
			for (String s : line) {
				if (!s.equals(" ")) {
					map.put(s, map.getOrDefault(s, 0) + 1);
				}
			}
		}
		Set<Entry<String, Integer>> map_set = map.entrySet();
		// toList
		List<Entry<String, Integer>> map_list = new ArrayList<Map.Entry<String, Integer>>();
		for (Entry<String, Integer> s : map_set) {
			map_list.add(s);
		}
		Collections.sort(map_list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1,
					Entry<String, Integer> e2) {
				// TODO Auto-generated method stub
				if (e1.getValue() > e2.getValue()) {
					return -1;
				} else if (e1.getValue() < e2.getValue()) {
					return 1;
				} else {
					return 0;
				}
			}

		});
		map_list.forEach(entry -> System.out.println(entry.getKey() + " "
				+ entry.getValue()));
	}
}
