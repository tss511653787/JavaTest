package Designpatterns.Adapter;

//模版方法
//将子类中公用的算法提升到父类的模版中 减少子类的代码重复
//子类易于扩展 子类可以选择实现父类的方法 实现子类的扩展 和对父类的反向控制
//汽车举例

public abstract class Template {
	public abstract void start();

	public abstract void powerOn();

	public abstract void dirive();

	public abstract void fast();

	public abstract void stop();

	public final void Process() {
		powerOn();
		start();
		dirive();
		if (canfast()) {
			fast();
		}
		stop();
	}

	protected boolean canfast() {
		// TODO Auto-generated method stub
		return true;
	}

	// test
	public static void main(String[] args) {
		Toyota c1 = new Toyota();
		c1.Process();
		Ferrari f1 = new Ferrari();
		f1.Process();
	}
}

class Toyota extends Template {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("toyota start");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("toyata power on");
	}

	@Override
	public void dirive() {
		// TODO Auto-generated method stub
		System.out.println("toyata drive");
	}

	@Override
	public void fast() {
		// TODO Auto-generated method stub
		// 不实现加速
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("toyata stop");
	}

	@Override
	protected boolean canfast() {
		// TODO Auto-generated method stub
		// 车子不能加速
		return false;
	}

}

class Ferrari extends Template {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Ferrari start");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("Ferrari powerOn");
	}

	@Override
	public void dirive() {
		// TODO Auto-generated method stub
		System.out.println("Ferrari drive");
	}

	@Override
	public void fast() {
		// TODO Auto-generated method stub
		System.out.println("Ferrari go fast");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Ferrari stop");
	}

	@Override
	protected boolean canfast() {
		// TODO Auto-generated method stub
		return true;
	}

}
