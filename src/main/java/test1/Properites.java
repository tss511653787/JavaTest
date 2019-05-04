package test1;

import java.util.Iterator;
import java.util.Properties;

public class Properites {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 属性 Properity是Hashtable的一个子类 具有Hashtable方法
		Properties pro = new Properties();
		pro.put("aaa", "ccc");
		pro.put("bbb", "dddd");
		pro.put("eee", "ttt");
		Iterator iter = pro.keySet().iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str + " " + pro.getProperty(str, "null"));

		}
		String getPro = pro.getProperty("tss", "No");
		System.out.println(getPro);

	}

}
