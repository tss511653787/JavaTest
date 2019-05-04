package ReView2;

/*
 * 这是一个函数式接口 
 * 函数式接口特点：接口中只有一个方法
 * */
public interface HanShuInterface {
	void call(String str);

	public static void main(String[] args) {
		String str = "abc";
		HanShuInterface han = (s) -> System.out.println(s);
	}
}
