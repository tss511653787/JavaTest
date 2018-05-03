package test1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_Socket {

	public static void main(String[] args) throws IOException {
		// 客户端需要连接的端口号+ip
		String Severip = "192.168.253.11";
		int port = 6066;
		// 通过ip转化为InetAddress对象
		// InetAddress ipaddr = InetAddress.getByAddress(byaddr);
		InetAddress ipaddr = InetAddress.getByName(Severip);
		System.out.println("连接服务器端:" + ipaddr + "在:" + port);

		// 创建Socket
		Socket socket = null;
		try {
			socket = new Socket(ipaddr, port);
			System.out.println("连接成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器连接异常");
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("获取服务器ip:" + socket.getRemoteSocketAddress());
		// 数据发送->Sever
		OutputStream outToSever = null;
		try {
			// 发送
			outToSever = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToSever);
			out.writeUTF("从" + socket.getLocalSocketAddress() + "发送数据");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("发送流获取异常");
			System.exit(1);
		}

		// 数据接受
		InputStream inFromSever = socket.getInputStream();
		java.io.DataInputStream in = new java.io.DataInputStream(inFromSever);
		System.out.println("从服务器接受：" + in.readUTF());
		// 关闭socket
		socket.close();
		Scanner scan = new Scanner(System.in);
		System.out.println("客户端输入数字1断开连接:");
		int key = scan.nextInt();
		if (key == 1) {
			socket.close();
			System.out.println("客户端Socket关闭");
		}
	}

}
