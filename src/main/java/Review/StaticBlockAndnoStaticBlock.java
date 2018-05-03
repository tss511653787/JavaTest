package Review;

/*
 * 解析类的静态块和非静态块加载顺序
 * */
public class StaticBlockAndnoStaticBlock {
	public static StaticBlockAndnoStaticBlock t1 = new StaticBlockAndnoStaticBlock();
	public static StaticBlockAndnoStaticBlock t2 = new StaticBlockAndnoStaticBlock();
	// 构造块
	{
		System.out.println("构造块");
	}
	// static块
	static {
		System.out.println("静态块");
	}
	//main method
	public static void main(String[] args) {
		StaticBlockAndnoStaticBlock t = new StaticBlockAndnoStaticBlock();
	}
}
