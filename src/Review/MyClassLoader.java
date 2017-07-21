package Review;

/*
 * 自己编写的ClassLoader类 用于类的加载
 * */

public class MyClassLoader extends ClassLoader {
	/*
	 * 只要在findClass方法实现自己的类加载就可以了 具体参加JVM书源码
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.findClass(name);
		// mycode
	}

}
