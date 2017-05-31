package MianShiBaoDian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class SeachInDictonary {
	/*
	 * 使用多线程并发检索一个包含某个字符串的文件 并发使用阻塞队列实现同步
	 */
	private static final int FILE_QUEUQ_SIZE = 10;
	private static final int SEARCH_THREAD_NUM = 100;
	private static final File END = new File("");
	private static Queue<File> blockingQueue = new LinkedBlockingQueue<File>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("please input a dictionary:");
		String dictionaryPath = scan.nextLine();
		System.out.println("please input a keyword:");
		String keyword = scan.nextLine();
		// 内部类
		Runnable eumerator = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				eumerate(new File(dictionaryPath));
				blockingQueue.offer(END);
			}
		};
		Thread putFileThread = new Thread(eumerator);
		putFileThread.start();
		// 开启多线程进行搜索
		for (int i = 0; i < SEARCH_THREAD_NUM; i++) {
			Runnable serchTheard = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					boolean flag = false;
					while ((!flag) && (!blockingQueue.isEmpty())) {
						File outfile = blockingQueue.poll();
						if (outfile == END) {
							blockingQueue.offer(outfile);
							flag = true;
						} else {
							Serch(outfile, keyword);
						}
					}
				}
			};
			Thread searchThead = new Thread(serchTheard);
			searchThead.start();
		}
	}

	public static void Serch(File outfile, String keyword) {
		// TODO Auto-generated method stub
		try {
			if (outfile.getPath() != "") {
				Scanner scan = new Scanner(outfile, "UTF-8");
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					if (line.contains(keyword)) {
						System.out.println(outfile + ":" + outfile.getPath()
								+ keyword);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void eumerate(File file) {
		// TODO Auto-generated method stub
		File[] filelist = file.listFiles();
		for (File f : filelist) {
			if (f.isDirectory()) {
				eumerate(f);
			} else {
				blockingQueue.offer(f);
			}
		}
	}

}
