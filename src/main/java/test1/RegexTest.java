package test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// String filePath = "C:/Users/dell/Desktop/file.txt";
		// File inputFile = new File(filePath);
		// FileOutputStream out = new FileOutputStream(inputFile);
		// OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
		// writer.append("现在输入:");
		// writer.append("\r\n");
		// writer.append("English");
		// // 关闭文件输出流和写入流
		// writer.close();
		// out.close();
		// // 读取文件
		// FileInputStream in = new FileInputStream(inputFile);
		// InputStreamReader reader = new InputStreamReader(in, "UTF-8");
		// StringBuffer strbuf = new StringBuffer();
		// while (reader.ready()) {
		// strbuf.append((char) reader.read());
		// }
		// System.out.println(strbuf.toString());
		// in.close();
		// reader.close();
		// 使用scanner类空置用户的输入和输出
		// Scanner scan = new Scanner(System.in);
		// // 使用next和nextLine两种方法比较
		// System.out.println("next:");
		// if (scan.hasNext()) {
		// String str = scan.next();
		// System.out.println(str);
		// }
		// Scanner scan2 = new Scanner(System.in);
		// System.out.println("nextLine:");
		// if (scan2.hasNextLine()) {
		// String st = scan2.nextLine();
		// System.out.println(st);
		// }
		Scanner scan3 = new Scanner(System.in);
		System.out.println("inputFloat:");
		if (scan3.hasNextFloat()) {
			float p = scan3.nextFloat();
			System.out.println("float" + p);
		} else {
			System.out.println("This is not float number");
		}
	}
}
