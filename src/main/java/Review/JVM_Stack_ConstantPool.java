package Review;

public class JVM_Stack_ConstantPool {
	public static void main(String[] args) {
		String a = "ab";
		String bb = "b";
		String b = "a" + bb;
		System.out.println((a == b)); // result = false

		String a1 = "ab";
		final String bb1 = "b";
		String b1 = "a" + bb1;
		System.out.println((a1 == b1)); // result = true

		String a2 = "ab";
		final String bb2 = getBB();
		String b2 = "a" + bb2;
		System.out.println((a2 == b2)); // result = false
		String s1 = "china";
		String s2 = "china";
		System.out.println(s1 == s2);
		System.out.println(s1.intern() == s2);

	}

	private static String getBB() {
		return "b";
	}
}
