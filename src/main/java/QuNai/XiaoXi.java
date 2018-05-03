package QuNai;

import java.util.ArrayList;

public class XiaoXi {
	// 判断两个单词的差值为1个字母
	public static int PanDuan(String a, String b) {
		int diffcount = 0;
		if (a == b)
			return 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diffcount++;
		}
		if (diffcount == 1)
			return 1;
		else {
			return diffcount;
		}
	}

	public static void main(String[] args) {

	}

	public static void FindPath(String[] all, String target, String find) {
		// target是当前单词
		// find是目标单词
		boolean flag = false;
		ArrayList<String> temp = new ArrayList<>();
		for (String str : all) {
			if (PanDuan(str, target) == 0) {
				// 找到
//				return 1;
			} else if (PanDuan(str, target) == 1) {
				temp.add(str);
			}
		}
		
	}
}
