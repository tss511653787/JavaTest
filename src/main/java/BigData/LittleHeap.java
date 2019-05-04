package BigData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * 使用hashmap对一段文本进行Top10提取
 * */
public class LittleHeap {
	static String filePath = "C:\\Users\\dell\\workspace\\test1\\src\\BigData\\in.txt";
	static int Topkey = 10;

	// main
	public static void main(String[] args) throws FileNotFoundException {
		process(filePath);
	}

	public static void process(String filepath) throws FileNotFoundException {
		filepath = filePath;
		// 预处理
		File file = new File(filepath);
		StringBuilder stringBuilder = new StringBuilder();
		Scanner scanner = new Scanner(file, "UTF-8");
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String res = line.replaceAll("[,]", " ").replaceAll("[.]", " ");
			stringBuilder.append(res);
		}
		scanner.close();
		String input = stringBuilder.toString();
		// WC 统计词频
		String[] in = input.split("\\s+");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : in) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		OEntry[] entrys = new OEntry[map.size()];
		int i = 0;
		for (String key : map.keySet()) {
			entrys[i++] = new OEntry(key, map.get(key));
		}
		HeapSort hs = new HeapSort(entrys, Topkey);
		System.out.println("方法1：小顶堆-----------------------------");
		hs.Sort();
		System.out.println("方法2：排序-----------------------------");
		// 排序
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> en : set) {
			list.add(en);
		}
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue() > o2.getValue()) {
					return -1;
				} else if (o1.getValue() < o2.getValue()) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		// print
		for (int p = 0; p < Topkey; p++) {
			System.out.println(list.get(p).getKey() + " "
					+ list.get(p).getValue());
		}
	}
}

// 小顶堆排序
class HeapSort {
	OEntry[] entrys;
	int topkey;
	OEntry[] heap;

	public HeapSort(OEntry[] entrys, int topkey) {
		super();
		this.entrys = entrys;
		this.topkey = topkey;
	}

	public void Sort() {
		heap = new OEntry[topkey];
		// heap initail
		for (int i = 0; i < topkey; i++) {
			heap[i] = entrys[i];
		}
		for (int j = topkey; j < entrys.length; j++) {
			makeHeap(heap, topkey);
			OEntry en = entrys[j];
			// 大于堆顶就替代堆顶
			if (compare(en, heap[0])) {
				heap[0] = en;
			}
		}
		// out
		for (OEntry en : heap) {
			System.out.println(en.key + " " + en.value);
		}
	}

	public void makeHeap(OEntry[] heap, int topkey) {
		// TODO Auto-generated method stub
		OEntry temp;
		for (int i = topkey - 1; i > 0; i--) {
			if (i % 2 == 0) {
				if (!compare(heap[i], heap[i / 2 - 1])) {
					temp = heap[i];
					heap[i] = heap[i / 2 - 1];
					heap[i / 2 - 1] = temp;
				}
			} else {
				if (!compare(heap[i], heap[i / 2])) {
					temp = heap[i];
					heap[i] = heap[i / 2];
					heap[i / 2] = temp;
				}
			}
		}
	}

	public boolean compare(OEntry e1, OEntry e2) {
		if (e1.value > e2.value) {
			return true;
		} else {
			return false;
		}
	}

}

class OEntry {
	String key;
	Integer value;

	public OEntry(String key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}
}
