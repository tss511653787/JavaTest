package Designpatterns.Adapter;

abstract class ComputerFactory {
	public abstract <T extends Computer> T createComputer(Class<T> cls);
}

// 工厂模式通过反射达到建立对象
public class Factory extends ComputerFactory {

	@SuppressWarnings({ "finally", "unchecked" })
	@Override
	public <T extends Computer> T createComputer(Class<T> cls) {
		// TODO Auto-generated method stub
		Computer com = null;
		try {
			String classname = cls.getName();
			com = (Computer) Class.forName(classname).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return (T) com;
		}
	}

	// test
	public static void main(String[] args) throws Exception {
		Factory factory = new Factory();
		Computer computer = factory.createComputer(DellComputer.class);
		if (computer != null) {
			computer.start();
		} else {
			throw new Exception("创建失败！");
		}
	}

}

// abstract class Computer

class HPComputer extends Computer {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Hp Power on");
	}

}

class ASUSComputer extends Computer {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("ASUS Power on");
	}

}
