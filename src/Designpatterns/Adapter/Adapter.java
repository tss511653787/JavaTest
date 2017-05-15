package Designpatterns.Adapter;

//适配器模式的两种
//1 接口型适配器
public class Adapter extends ExitingClass implements RequiredInterface {

	@Override
	public void requiredMethod() {
		// TODO Auto-generated method stub
		System.out.println("A required Method");
	}

	// overload
	public static int usefulMethod(int a) {
		System.out.println("OOOP");
		return a;
	}

}

// 类与对象的适配器
class Adapter2 extends RequiredClass {

	ExitingClass exitObj;

	private Adapter2(ExitingClass exitObj) {
		super();
		this.exitObj = exitObj;
	}

	@Override
	public void requiredMethod() {
		// TODO Auto-generated method stub
		// 使用对象调用方法
		exitObj.usefulMethod();
	}

	// overload
	public static int usefulMethod(int a) {
		System.out.println("OOO");
		return a;
	}

}

interface RequiredInterface {
	public void requiredMethod();
}

abstract class RequiredClass {
	public abstract void requiredMethod();
}

class ExitingClass {
	public static void usefulMethod() {
		System.out.println("A usefulMethod");
	}
}
