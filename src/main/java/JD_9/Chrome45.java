package JD_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/*
 * 统计日志中 chrome45以上版本的访问次数
 * */
public class Chrome45 {
	static Scanner scanner;

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = ".../log.txt";
		Test(filePath);
	}

	public static void Test(String filePath) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<String>();
		File file = new File(filePath);
		scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			input.add(line);
		}
		// filter
		for (int i = 0; i < input.size(); i++) {
			String[] line = input.get(i).split("\\:");
			String pattern = ".*chrome4.*";
			if (Pattern.matches(pattern, line[0])) {
				int num = Integer.parseInt(String.valueOf(line[0]
						.charAt(line[0].length() - 1)));
				if (num <= 5) {
					input.remove(i);
				}
			} else {
				input.remove(i);
			}
		}
		// WordCount
		Map<String, Long> map = new HashMap<>();
		for (String line : input) {
			String key = line.split("\\:")[0];
			map.put(key, map.getOrDefault(key, (long) 1) + 1);
		}
		Set<Map.Entry<String, Long>> sortedset = new TreeSet<>(
				new Comparator<Map.Entry<String, Long>>() {
					@Override
					public int compare(Entry<String, Long> o1,
							Entry<String, Long> o2) {
						// TODO Auto-generated method stub
						if (o1.getValue() > o2.getValue()) {
							return -1;
						} else if (o2.getValue() == o2.getValue()) {
							return 0;
						} else {
							return 1;
						}
					}
				});
		Set<Entry<String, Long>> mapset = map.entrySet();
		sortedset.addAll(mapset);
		// output
		sortedset.forEach(entry -> System.out.println(entry.getKey() + ":"
				+ entry.getValue()));
	}

}
