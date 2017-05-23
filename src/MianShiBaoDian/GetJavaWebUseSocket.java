package MianShiBaoDian;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetJavaWebUseSocket {
	public static void main(String[] args) {
		// simpleMyTelnetServer();
	}

	public static void getWebFromNet() {
		try {
			Socket soc = new Socket("119.75.217.109", 80);
			// soc.setSoTimeout(1000);
			java.io.InputStream in = soc.getInputStream();
			Scanner scan = new Scanner(in);
			while (scan.hasNext()) {
				String str = scan.nextLine();
				System.out.println(str);
			}
			soc.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getIp(String hostname) {
		try {
			InetAddress[] addresArr = InetAddress.getAllByName(hostname);
			// 打印ip
			if (addresArr.length != 0) {
				for (InetAddress net : addresArr) {

					System.out.println(net);
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("无法获取主机地址");
			e.printStackTrace();
		} finally {

		}
	}

	public static void simpleMyTelnetServer() {

		try {
			ServerSocket server = new ServerSocket(8189);
			if (server.isBound()) {
				System.out.println("Sever begin:");
			}
			ExecutorService pool = Executors.newFixedThreadPool(50);
			while (true) {
				Socket in = server.accept();
				String name = in.getInetAddress().getHostName();
				System.out.println(name);
				Thread t = new Thread(new ThreadedEchoHander(in));
				pool.execute(t);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 使用NIO里面的可中断套接字实现可以interrupted的sokect Telnet服务器
	// ****重点
	public static void nioclient() throws IOException {
		InetSocketAddress remote = new InetSocketAddress("", 9189);
		SocketChannel channel = SocketChannel.open(remote);
		Scanner scan = new Scanner(channel);
		while (!Thread.currentThread().isInterrupted() && scan.hasNext()) {
			String data = scan.nextLine();
			System.out.println(data);
		}
		scan.close();
		channel.close();
	}

}

// 服务器线程处理逻辑
class ThreadedEchoHander implements Runnable {
	Socket in;

	public ThreadedEchoHander(Socket in) {
		super();
		this.in = in;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 输入输出流
		try {
			java.io.InputStream input = in.getInputStream();
			OutputStream output = in.getOutputStream();
			// 连接成功
			// if(in.isConnected()){}
			PrintWriter out = new PrintWriter(output, true);// autoflush
			out.println("hello!(enter bye to exit) ^_^ ");
			// 接受客户端发送的消息
			Scanner scan = new Scanner(input);
			boolean flag = true;
			while (flag && scan.hasNext()) {
				String info = scan.nextLine();
				if (info.equals("bye")) {
					flag = false;
					out.println("ByeBye");
				}
				// 本地显示并给客户端回复
				System.out.println(info);
				out.println("received:" + info);
			}
			scan.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
