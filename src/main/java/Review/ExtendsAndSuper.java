package Review;

import java.util.ArrayList;
import java.util.List;

/*
 * 解释泛型接口中的区别
 * Extends 定义了上界 集合只能get不能add
 * super 定义了下界 集合只能add不能get
 * */

public class ExtendsAndSuper {
	private static List<? extends Fruit> fruits;
	private static List<? super RedApple> redapples;

	public static <T> T[] getArr(T a) {
		return null;
	}

	public static void main(String[] args) {
		// 可以接受任何Fruit类以下的实例
		fruits = new ArrayList<Apple>();
		// 不能add 因为上界是Fruit不知道实际的类型 不能随便的add
		// fruits.add(new RedApple());
		// 可以get 因为上界是Fruit 都可以引用
		Fruit f = fruits.get(0);

		// 下届是redapple 定一个Apple集合
		redapples = new ArrayList<Apple>();
		// 添加下界以及下界以下的实例都是可行的
		redapples.add(new RedApple());
		// 但是get不可行 因为下界是redapple不知道实际存放的是redapple的哪个父类
		// RedApple a = redapples.get(0);
	}
}

class RedApple extends Apple {

	/*
	 * 红苹果类
	 */
	
}

class Apple extends Fruit {
	/*
	 * 苹果类
	 */
}

class Fruit {
	/*
	 * 水果类
	 */
}
