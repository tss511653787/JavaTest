package Designpatterns.Adapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * java中的动态代理接口的实现
 * java中动态代理两个重要的接口就是Invocation接口和Proxy类
 * 实现Invocantion中的invoke方法
 * Proxy类是用来动态创建一个代理对象 主要使用其中的newProxyInstance方法
 * 
 * */
//被代理对象的抽象接口
interface Subject {
	abstract void rent();

	abstract void hello(String str);
}

class RealSubject implements Subject {

	@Override
	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("我希望骑马");
	}

	@Override
	public void hello(String str) {
		// TODO Auto-generated method stub
		System.out.println("给大家打个招呼" + str);
	}

}

// 实现一个动态代理类
public class DynamicProxy implements InvocationHandler {
	// 维持一个真实对象的引用
	RealSubject sub;

	public DynamicProxy(RealSubject sub) {
		super();
		this.sub = sub;
	}

	// proxy:代理对象 method我们要调用真实类方法的method对象
	// args 调用方法接受的参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("开始代理");
		System.out.println("骑马之前的准备工作");
		method.invoke(sub, args);
		System.out.println("骑马结束");
		return null;
	}

	// test
	public static void main(String[] args) {
		// 客户端
		RealSubject sub = new RealSubject();
		// 创建代理类
		InvocationHandler handler = new DynamicProxy(sub);
		/*
		 * 通过Proxy类的newInstance方法来创建代理对象
		 * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
		 */
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass()
				.getClassLoader(), sub.getClass().getInterfaces(), handler);
		System.out.println(subject.getClass().getName());
		subject.rent();
		subject.hello("hi");
	}

}

class Client {

}
