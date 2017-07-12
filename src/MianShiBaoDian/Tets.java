package MianShiBaoDian;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tets {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\a.txt");
		FileInputStream in = new FileInputStream(file);
		StringBuilder bld = new StringBuilder();
		byte[] b = new byte[1024];
		// while(in.read()!=-1)
		while (in.read(b) > 0) {
			in.read(b);
			bld.append(new String(b));
		}
		System.out.println(bld.toString());

		FileInputStream in2 = new FileInputStream(file);
		DataInputStream dataIn = new DataInputStream(in2);
		byte bu = dataIn.readByte();
		System.out.println(bu);
		byte bu2 = dataIn.readByte();
		System.out.println(bu2);

		RandomAccessFile raf = new RandomAccessFile(file, "rw");

	}
}
