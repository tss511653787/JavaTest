package MianShiBaoDian;

public class PermGenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "java"第一次进入常量池
		String str1 = new StringBuffer("打呼噜的").append("人们").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new String("打呼噜的人们");
		System.out.println(str2.intern() == str2);

	}

}
