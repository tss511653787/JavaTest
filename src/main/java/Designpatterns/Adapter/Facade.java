package Designpatterns.Adapter;

//外观(门面)设计模式 其实就是进一步封装了一个类去实现子系统逻辑
public class Facade {
	private Subsystem1 objs1 = new Subsystem1();
	private Subsystem2 objs2 = new Subsystem2();

	public void Method() {
		objs1.f1();
		objs2.f2();
	}

}

class Subsystem1 {
	public void f1() {

	}
}

class Subsystem2 {
	public void f2() {

	}
}
