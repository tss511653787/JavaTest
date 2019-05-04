package Designpatterns.Adapter;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 单例模式的7种写法
 * 
 * */
//饿汉模式
class Singleton1 {
	private static Singleton1 single1 = new Singleton1();

	private Singleton1() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton1 getInstance() {
		return single1;
	}
}

// 懒汉模式(线程安全和不安全)
// 只写一个线程安全的
public class Singleton {
	int id;
	private static Singleton singleton;
	final static int DEFAULTNUM = 15;
	// 加锁
	private static Lock lock;

	private Singleton() {
		// TODO Auto-generated constructor stub
		this.id = DEFAULTNUM;
	}

	private Singleton(int id) {
		super();
		this.id = id;
	}

	public static Singleton newInstance() {
		lock.lock();
		try {

			if (singleton == null) {
				singleton = new Singleton();
				return singleton;
			} else {
				return singleton;
			}
		} finally {
			lock.unlock();
		}
	}
}

// 双重检查模式
// 这种写法在getSingleton方法中对singleton进行了两次判空，第一次是为了不必要的同步，
// 第二次是在singleton等于null的情况下才创建实例。
class Singleton3 {
	private volatile static Singleton3 singleton3;

	private Singleton3() {

	}

	public static Singleton3 getInstance() {
		if (singleton3 == null) {
			synchronized (Singleton3.class) {
				if (singleton3 == null) {
					singleton3 = new Singleton3();
				}
			}
		}
		return singleton3;
	}

}

// 静态内部类模式：适合高并发 低的资源占用
/*
 * 第一次加载Singleton类时并不会初始化sInstance， 只有第一次调用getInstance方法时虚拟机加载SingletonHolder
 * 并初始化sInstance ，这样不仅能确保线程安全也能保证Singleton类的唯一性， 所以推荐使用静态内部类单例模式。
 */
class Singleton4 {
	private Singleton4() {

	}

	public static Singleton4 getInstance() {
		return Singleton4Inner.sInstance;
	}

	private static class Singleton4Inner {
		private static final Singleton4 sInstance = new Singleton4();
	}
}

// 枚举单例
/*
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是单例， 上述讲的几种单例模式实现中，有一种情况下他们会重新创建对象，那就是反序列化
 */
enum Singleton5 {
	INSTANCE;
	public void doSomeThing() {
	}
}

// 使用容器管理单例模
class SingletonMannager {
	private static HashMap<String, Object> mannager = new HashMap<>();

	private SingletonMannager() {

	}

	public static void registerService(String key, Object instance) {
		if (!mannager.containsKey(key)) {
			mannager.put(key, instance);
		}
	}

	public static Object getService(String key) {
		return mannager.get(key);
	}
}
