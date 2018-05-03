package Test4;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ThinkInJava {
	public static void main(String[] args) throws IOException {
		String str1 = "abc";
		// 这个地方因为不是从控制台读入所以会为空
		// Console con = System.console();
		// String username = con.readLine();
		// char[] pas = con.readPassword();
		String path = "C:/Users/dell/Desktop/abc.txt";
		File file = new File(path);
		PrintWriter out = new PrintWriter(file);
		out.println("abcd");
		out.println("hefg");
		out.println("ijkl");
		out.println("mnop");
		out.close();
		// 使用RandomAccessFile类操作
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		byte temp = 0;
		for (int i = 4; i > 0; i--) {
			rf.seek(i * 5 - 2);
			temp = rf.readByte();
			rf.seek(i * 5 - 5);
			rf.write(temp);
		}
		rf.close();

	}

}

class Test {
	public static int tt() {
		try {
			return 1;

		} finally {
			return 2;
		}
	}
}
