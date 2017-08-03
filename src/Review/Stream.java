package Review;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stream {
	public static void main(String[] args) throws IOException {
		String filePath = "C:/Users/Administrator/Desktop/a.txt";
		// StreamInOut(filePath);
		// String in = ReaderIn(filePath);
		// WriterOut("C:/Users/Administrator/Desktop/b.txt", in);
		// FileReaderIn(filePath);
		DataInput(filePath);
	}

	public static void FileReaderIn(String filepath) throws IOException {
		char[] c = new char[1024];
		File filein = new File(filepath);
		FileReader reader = new FileReader(filein);
		while (reader.read(c) != -1) {
			String s = new String(c);
			System.out.println(s);
		}
		reader.close();
	}

	private static void ScanFile(String filePath) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File(filePath));
		while (scan.hasNext()) {
			System.out.println(scan.nextLine());
		}
		scan.close();
	}

	public static void StreamInOut(String filePath) throws IOException {
		// 读入文件
		File fileIn = new File(filePath);
		InputStream inputStream = new FileInputStream(fileIn);
		StringBuilder tempBuilder = new StringBuilder();
		byte[] readbyte = new byte[inputStream.available()];
		while (inputStream.read(readbyte) != -1) {
			tempBuilder.append(new String(readbyte));
		}
		String res = tempBuilder.toString();
		System.out.println(res);
		inputStream.close();
		// 写入一个新文件
		File newFile = new File("C:/Users/Administrator/Desktop/b.txt");
		OutputStream outputStream = new FileOutputStream(newFile);
		byte[] out = res.getBytes();
		outputStream.write(out);
		outputStream.close();

	}

	private static void WriterOut(String filePath, String in)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter out = new PrintWriter(new File(filePath));
		out.print(in);
		out.close();
	}

	private static String ReaderIn(String filePath)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		File a = new File(filePath);
		Scanner scan = new Scanner(a);
		StringBuilder stringBuilder = new StringBuilder();
		while (scan.hasNext()) {
			String temp = scan.nextLine();
			stringBuilder.append(temp);
		}
		scan.close();
		return stringBuilder.toString();
	}

	public static void DataInput(String filepath) throws IOException {
		InputStream in = new FileInputStream(new File(filepath));
		DataInputStream dataIn = new DataInputStream(in);
		byte[] b = new byte[dataIn.available()];
		while (dataIn.read(b) != -1) {
			String s = new String(b);
			System.out.println(s);
		}
		dataIn.close();
	}
}
