package Designpatterns.Adapter;

//装饰模式 开闭原则的最好体现 通过集成抽象的装饰器来实现对原来对象的功能扩展
public abstract class Decoration extends Car {
	Car car;

	public Decoration() {

	}

	public Decoration(Car car) {
		super();
		this.car = car;
	}

	@Override
	void run() {
		// TODO Auto-generated method stub
		car.run();
	}

	@Override
	void powerOn() {
		// TODO Auto-generated method stub
		car.powerOn();
	}

	public static void main(String[] args) {
		HondaCar honda = new HondaCar();
		honda.run();
		honda.powerOn();
		System.out.println("------------------------");
		ConcreteDecorationOne con = new ConcreteDecorationOne(honda);
		con.run();
		con.powerOn();
	}

}

class ConcreteDecorationOne extends Decoration {
	public ConcreteDecorationOne(Car car) {
		super(car);
	}

	@Override
	void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("自动行驶已加入");
	}

	@Override
	void powerOn() {
		// TODO Auto-generated method stub
		super.powerOn();
		System.out.println("自动泊车已加入");
	}

}

abstract class Car {
	String name;
	String id;

	public Car() {

	}

	public Car(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	// 抽象汽车类
	abstract void run();

	abstract void powerOn();
}

class HondaCar extends Car {

	@Override
	void run() {
		// TODO Auto-generated method stub
		System.out.println("本田智能启动");
	}

	@Override
	void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("本田无钥匙启动");
	}

}