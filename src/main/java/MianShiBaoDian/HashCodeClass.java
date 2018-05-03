package MianShiBaoDian;

public class HashCodeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = new Object();
		Print(obj.hashCode());
		String str = new String("ab");
		Print(str.hashCode());
		Integer in = new Integer(10);
		Print(in.hashCode());
		Character c = 'a';
		Print(c.hashCode());

	}

	public static void Print(int i) {
		System.out.println(i);
	}

}
