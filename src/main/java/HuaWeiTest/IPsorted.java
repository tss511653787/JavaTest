package HuaWeiTest;

//3.10华为笔试

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class IPsorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[5];
		for (int i = 0; i < 5; i++) {
			Scanner scan = new Scanner(System.in);
			input[i] = scan.nextLine();
		}
		// ip地址分类
		ArrayList<String> Aip = new ArrayList<String>();
		ArrayList<String> Bip = new ArrayList<String>();
		ArrayList<String> Cip = new ArrayList<String>();
		ArrayList<String> Dip = new ArrayList<String>();
		ArrayList<String> Eip = new ArrayList<String>();

		for (String str : input) {
			String[] fir = str.split("\\.");
			int firNum = Integer.parseInt(fir[0]);
			// 检测错误ip
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				flag = detect(Integer.parseInt(fir[i]));
				if (!flag)
					break;
			}
			if (!flag)
				continue;

			// A类地址
			if (firNum >= 0 && firNum <= 127) {
				Aip.add(str);
			}
			// B
			if (firNum >= 128 && firNum <= 191) {
				Bip.add(str);
			}
			// C
			if (firNum >= 192 && firNum <= 223) {
				Cip.add(str);
			}
			// D
			if (firNum >= 224 && firNum <= 239) {
				Dip.add(str);
			}
			// E
			if (firNum >= 240 && firNum <= 255) {
				Eip.add(str);
			}
		}

		if (!Aip.isEmpty()) {
			ArrayList<IP> AIPlist = new ArrayList<IP>();
			for (String ipStr : Aip) {
				IP anewip = new IP(ipStr);
				AIPlist.add(anewip);
			}
			Collections.sort(AIPlist, IP.IPComparator);
			System.out.println("A：" + AIPlist.toString().replaceAll(",", "，"));
		}
		if (!Bip.isEmpty()) {
			ArrayList<IP> BIPlist = new ArrayList<IP>();
			for (String ipStr : Bip) {
				IP anewip = new IP(ipStr);
				BIPlist.add(anewip);
			}
			Collections.sort(BIPlist, IP.IPComparator);
			System.out.println("B：" + BIPlist.toString().replaceAll(",", "，"));
		}
		if (!Cip.isEmpty()) {
			ArrayList<IP> CIPlist = new ArrayList<IP>();
			for (String ipStr : Cip) {
				IP anewip = new IP(ipStr);
				CIPlist.add(anewip);
			}
			Collections.sort(CIPlist, IP.IPComparator);
			System.out.println("C：" + CIPlist.toString().replaceAll(",", "，"));
		}
		if (!Dip.isEmpty()) {
			ArrayList<IP> DIPlist = new ArrayList<IP>();
			for (String ipStr : Dip) {
				IP anewip = new IP(ipStr);
				DIPlist.add(anewip);
			}
			Collections.sort(DIPlist, IP.IPComparator);
			System.out.println("D：" + DIPlist.toString().replaceAll(",", "，"));
		}
		if (!Eip.isEmpty()) {
			ArrayList<IP> EIPlist = new ArrayList<IP>();
			for (String ipStr : Eip) {
				IP anewip = new IP(ipStr);
				EIPlist.add(anewip);
			}
			Collections.sort(EIPlist, IP.IPComparator);
			System.out.println("E：" + EIPlist.toString().replaceAll(",", "，"));
		}

	}

	// 检测ip
	public static boolean detect(int ip) {
		if (ip < 0 || ip > 255)
			return false;
		else
			return true;
	}
}

class IP {
	private String IP;

	public IP(String iP) {
		IP = iP;
	}

	public String getIP() {
		return IP;
	}

	@Override
	public String toString() {
		// 注意大哥！！！ 这个地方要重写toString方法
		return this.IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	// -1 0 1
	public static Comparator<IP> IPComparator = new Comparator<IP>() {
		@Override
		public int compare(IP o1, IP o2) {
			// TODO Auto-generated method stub
			return compartTo(o1.getIP(), o2.getIP());
		}

	};

	// parse ip_str->Long[] ip
	private static long[] parseIp(String ip) {
		ip = ip.replace(".", "#");
		long result[] = new long[4];
		String[] ip1 = ip.split("#");
		if (ip != null) {
			result[0] = Long.parseLong(ip1[0]);
			result[1] = Long.parseLong(ip1[1]);
			result[2] = Long.parseLong(ip1[2]);
			result[3] = Long.parseLong(ip1[3]);
		}
		return result;
	}

	public static int compartTo(String ip1, String ip2) {
		long[] ip11 = parseIp(ip1);
		long[] ip22 = parseIp(ip2);
		long ip1Result = 0, ip2Result = 0;
		for (int i = 0; i < 4; i++) {
			ip1Result += (ip11[i] << (24 - i * 8));
		}
		for (int i = 0; i < 4; i++) {
			ip2Result += (ip22[i] << (24 - i * 8));
		}
		if (ip1Result - ip2Result > 0) {
			return 1;
		} else if (ip1Result - ip2Result < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
