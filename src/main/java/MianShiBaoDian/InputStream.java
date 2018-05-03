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
		// zip文件的读写
		// 方法一 使用zipEntry(推荐)
		String pathname = "C:/Users/Administrator/Desktop/a.zip";

		File file = new File(pathname);
		FileInputStream in = new FileInputStream(file);
		ZipInputStream zin = new ZipInputStream(in);
		StringBuilder inbuild = new StringBuilder();
		while (zin.getNextEntry() != null) {
			// 读取下一个 ZIP 文件条目并将流定位到该条目数据的开始处:起到了流的定位作用 所以是有必要的语句
			ZipEntry entry = zin.getNextEntry();
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
