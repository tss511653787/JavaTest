package MianShiBaoDian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentCollectionIn8 {
	/*
	 * java8中一些线程安全的集合 在java8中处理大数据的新特性
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File fileIn = new File("C:/Users/Administrator/Desktop/wc.txt");
		Scanner scan = new Scanner(fileIn);
		ConcurrentHashMap<String, LongAdder> concurrMap = new ConcurrentHashMap<String, LongAdder>();
		ConcurrentHashMap<String, Integer> conmap = new ConcurrentHashMap<String, Integer>();
		StringBuffer tempBuf = new StringBuffer();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			tempBuf.append(line);
		}
		String[] in = tempBuf.toString().split(" ");
		for (int i = 0; i < in.length; i++) {
			concurrMap.putIfAbsent(in[i], new LongAdder());
			// 原子自增
			concurrMap.get(in[i]).increment();
		}
		for (int i = 0; i < in.length; i++) {
			conmap.put(in[i], conmap.getOrDefault(in[i], 0) + 1);
		}
		Set<String> ketset = concurrMap.keySet();
		for (String s : ketset) {
			System.out.println(s + " : " + concurrMap.get(s));
		}
		System.out.println("----------------------------------------");
		String upTWOres = concurrMap.search(Long.MAX_VALUE,
				(k, v) -> v.intValue() > 5 ? k : null);
		System.out.println(upTWOres);
		// 全部的value值之和
		Integer res = conmap.reduceValues(Long.MAX_VALUE, Integer::sum);
		System.out.println(res);
		// value值大于2的value值之和
		int sum = conmap.reduceValues(Long.MAX_VALUE, v -> v > 2 ? v : null,
				Integer::sum);
		System.out.println(sum);
		ExecutorService pool = Executors.newCachedThreadPool();
		
	}
}
