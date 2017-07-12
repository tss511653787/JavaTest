package MianShiBaoDian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;
import java.util.zip.CRC32;

import javax.swing.text.AbstractDocument.LeafElement;

public class Nio {
	// 从javase1.4开始加入了新的IO包 包含于java.nio中
	// 举例说明里面的内存映射机制:加快文件读写访问
	public static void main(String[] args) throws IOException {
		String in = "C:\\Users\\Administrator\\Desktop\\topic";
		// nioReadFile(in);
		lockFileTest(in);

	}

	public static void nioReadFile(String filepath) throws IOException {
		File file = new File(filepath);
		FileInputStream filein = new FileInputStream(file);
		FileChannel channel = filein.getChannel();
		long filelength = channel.size();
		MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0,
				filelength);
		// 将ByteBuffer转换成string
		Charset charset = null;
		CharsetDecoder decoder = null;
		CharBuffer charBuffer = null;
		charset = Charset.forName("UTF-8");
		decoder = charset.newDecoder();
		charBuffer = decoder.decode(buf.asReadOnlyBuffer());
		String str = charBuffer.toString();
		System.out.println(str);
	}

	// 对文件加锁
	public static void lockFileTest(String filepath) throws IOException {
		File file = new File(filepath);
		FileInputStream filein = new FileInputStream(file);
		FileChannel channel = filein.getChannel();
		// 对channel加锁
		// true加一个独占锁
		FileLock lock = channel.tryLock(0, channel.size(), true);
		StringBuilder str = new StringBuilder();
		while (filein.read() != -1) {
			byte[] bytebuf = new byte[2048];
			filein.read(bytebuf);
			str.append(new String(bytebuf));
		}
		// 释放锁
		lock.release();
		System.out.println(str);
	}
}
