package test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sever_Socket extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 服务器端是使用了多线程编程 监听Socket端口
		int port = 9909;
		Thread t = new Sever_Socket(port);
		t.start();
	}

	private ServerSocket sever;

	// 构造器
	public Sever_Socket(int port) {
		try {
			sever = new ServerSocket(port);
			// sever.setSoTimeout();//可选设置一个最大超时时间
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("SeverSocket初始化异常");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void run() {
		Socket soc = null;
		while (true) {
			System.out.println("等待客户端连接......" + sever.getLocalPort());
			try {
				soc = sever.accept();
				System.out.println("从" + soc.getRemoteSocketAddress() + "接收");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("开启监听异常");
				e.printStackTrace();
				System.exit(1);
			}
			// 数据传输
			try {
				DataInputStream in = new DataInputStream(soc.getInputStream());
				System.out.println(in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("输入数据流异常");
				e.printStackTrace();
				System.exit(1);
			}
			try {
				DataOutputStream out = new DataOutputStream(
						soc.getOutputStream());
				out.writeUTF("连接服务器成功" + soc.getLocalSocketAddress());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("输出数据流异常");
				System.exit(1);
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("服务器输入数字1断开连接:");
			int key = scan.nextInt();
			if (key == 1) {
				try {
					soc.close();
					System.out.println("服务器端Socket关闭");
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Socket关闭异常");
					System.exit(1);
				}

			}

		}

	}

}
