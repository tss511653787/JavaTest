package Designpatterns.Adapter;

//策略模式：一个类实现中有很多条件判断语句时可以用具体的策略类，通过实现抽象的算法实现不同条件下的不同功能
//eg：汽车的空置策略
public interface Strategy {
	public abstract void controlCar();
	//test
	public static void main(String[] args) {
		Context con = new Context(new RunCar());
		con.controlCar();
		con = new Context(new StartCar());
		con.controlCar();
	}
}

class StartCar implements Strategy {

	@Override
	public void controlCar() {
		// TODO Auto-generated method stub
		System.out.println("car power on");
	}

}

class RunCar implements Strategy {

	@Override
	public void controlCar() {
		// TODO Auto-generated method stub
		System.out.println("car run");
	}

}

// 环境类 包含策略类 通过传参数实现不同的方法
class Context {
	private Strategy staraety;

	public Context(Strategy staraety) {
		super();
		this.staraety = staraety;
	}

	public void controlCar() {
		staraety.controlCar();
	}
}