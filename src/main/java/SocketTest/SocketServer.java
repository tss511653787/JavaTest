package SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/*
 * 实现一个Socketserver端
 * */

public class SocketServer {
	private static ServerSocket soServerSocket;

	public static void main(String[] args) throws IOException {
		soServerSocket = new ServerSocket(9099);
		/*
		 * ThreadPoolCode?
		 */
		while (true) {
			System.out.println("Start Listening...");
			Socket soc = soServerSocket.accept();
			Thread t = new Thread(new Server(soc));
			t.start();
		}
	}

}

class Server implements Runnable {
	private Socket incoming;
	private InputStream inputStream;
	private OutputStream outputStream;

	public Server(Socket incoming) {
		super();
		this.incoming = incoming;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// get in/out putStream
		if (incoming != null) {
			System.out.println("Connect success from:"
					+ incoming.getRemoteSocketAddress());
		}
		
		try {
			inputStream = incoming.getInputStream();
			outputStream = incoming.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (incoming != null && outputStream != null) {

		} else {
			System.out.println("流初始化异常");
			System.exit(1);
		}
		Scanner in = new Scanner(inputStream);
		while (in.hasNext()) {
			String inStr = in.nextLine();
			if (inStr.equals("BYE")) {
				try {
					System.out.println(incoming.getRemoteSocketAddress()
							+ "shutdown");
					incoming.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(inStr);
		}
		Scanner out = new Scanner(System.in);
		String outStr = out.nextLine();
		byte[] outbyte = outStr.getBytes();
		try {
			outputStream.write(outbyte);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
