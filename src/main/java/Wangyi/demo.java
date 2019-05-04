package Wangyi;


public class demo implements C {

	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("zilei");
	}

	public static void main(String[] args) {
		 C c = new demo();
		 c.f();
		 demo d = new demo();
		 d.f();
	}

}

interface C {
	default void f() {
		System.out.println("C 的 f");
	}

	static void f2() {
		// interface 里面可以有静态方法
	}
}
