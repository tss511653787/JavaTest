package Designpatterns.Adapter;

public class StaticFactory {
	public static Computer c;

	public static void makeComputer(String computerName) {
		switch (computerName) {
		case "dell":
			c = new DellComputer();
			c.start();
			break;
		default:
			break;
		}
	}

}

abstract class Computer {
	public abstract void start();
}

class DellComputer extends Computer {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("DELL Power on");
	}

}
