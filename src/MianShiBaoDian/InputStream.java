/**
 * 
 */
package MianShiBaoDian;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.RandomAccess;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author Administrator
 *
 */
public class InputStream {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * InputStreamReader in = new InputStreamReader(System.in); char[] a =
		 * new char[10]; char s = (char) in.read(); in.close();
		 * System.out.println(s);
		 */
		/*
		 * 读写二进制数据 String pathname = "C:/Users/Administrator/Desktop/a"; File
		 * file = new File(pathname); FileInputStream in = new
		 * FileInputStream(file); DataInputStream datain = new
		 * DataInputStream(in); int c = datain.readInt(); System.out.println(c);
		 */
		// zip文件的读写
		String pathname = "C:/Users/Administrator/Desktop/a.zip";
		File file = new File(pathname);
		FileInputStream in = new FileInputStream(file);
		ZipInputStream zin = new ZipInputStream(in);
		ZipEntry entry;
		StringBuilder inbuild = new StringBuilder();
		while ((entry = zin.getNextEntry()) != null) {
			String filename = entry.getName();
			inbuild.append(filename + "\n");
			Scanner scan = new Scanner(zin);
			while (scan.hasNext()) {
				inbuild.append(scan.nextLine() + "\n");
			}
			zin.closeEntry();
		}
		zin.close();
		in.close();
		// System.out.println(inbuild.toString());
		// 方法2 使用zipfile类 通过zipEntry 读取zip中的每一个文件
		ZipFile zipfile = new ZipFile(file);
		Enumeration en = zipfile.entries();
		StringBuilder inbuild2 = new StringBuilder();
		while (en.hasMoreElements()) {
			ZipEntry tempEntry = (ZipEntry) en.nextElement();
			java.io.InputStream in2 = zipfile.getInputStream(tempEntry);
			String filename2 = tempEntry.getName();
			inbuild2.append(filename2 + "\n");
			Scanner scan2 = new Scanner(in2);
			while (scan2.hasNext()) {
				inbuild2.append(scan2.nextLine() + "\n");
			}
		}
		System.out.println(inbuild2.toString());

	}

}
