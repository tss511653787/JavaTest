package ReView2;

import java.util.Date;

/*
 * Pair 是一个泛型类
 * T没有指定任何条件
 * 所以JVM会使用Object类型对其进行擦除
 * 
 * */
public class Pair<T> {
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

// 继承这个泛型方法
class DateInterl extends Pair<Date> {
	/*
	 * 继承了这个泛型类 还规定了泛型对象类别为Date
	 */
	/*
	 * 那个这个类在JVM中实际上继承了void setValue(Object value)
	 * 而自己又有一个void setValue(Date value)方法
	 * 所以使用一个桥方法来保持多态
	 * */
	@Override
	public void setValue(Date value) {
		// TODO Auto-generated method stub
		super.setValue(value);
	}

}
