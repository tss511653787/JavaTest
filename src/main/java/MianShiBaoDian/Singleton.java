package MianShiBaoDian;

class Singleton {
	// 单例模式的2中实现形式
	// 1.private修饰构造器 getInstance返回唯一的单例
	private Singleton() {
	}

	private static Singleton single = new Singleton();

	public static Singleton getInstance() {
		return single;
	}
}

class AnthorSingleton {
	private AnthorSingleton() {

	}

	private static AnthorSingleton single = null;

	public static AnthorSingleton getInstance() {
		if (single == null) {
			single = new AnthorSingleton();
			return single;
		} else {
			return single;
		}
	}
}

