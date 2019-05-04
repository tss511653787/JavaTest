package SocketTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Socket客户端编程
 * */
/*
 * 需要在另一个主机上调试
 * */

public class ClientSocket {
	private static Socket soc;
	private static InputStream inputStream;
	private static OutputStream outputStream;

	public static void main(String[] args) {
		try {
			soc = new Socket("219.216.65.248", 9909);
			System.out.println("Connect Server" + soc.getRemoteSocketAddress()
					+ "successfully");
			inputStream = soc.getInputStream();
			outputStream = soc.getOutputStream();
			Scanner in = new Scanner(inputStream);
			while (in.hasNext()) {
				String s = (String) in.nextLine();
				System.out.println(s);
			}
			PrintWriter out = new PrintWriter(outputStream);
			Scanner scan = new Scanner(System.in);
			while (scan.hasNext()) {
				String input = (String) scan.next();
				out.print(input);
			}
			scan.close();
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
