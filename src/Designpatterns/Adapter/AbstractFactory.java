package Designpatterns.Adapter;

public abstract class AbstractFactory {
	public abstract DesktopComputer createDesktopComputer();

	public abstract NotebookComputer createNotebookComputer();

	public static void main(String[] args) {
		LenovoFactory lenocoFactory = new LenovoFactory();
		lenocoFactory.createDesktopComputer().start();
		lenocoFactory.createNotebookComputer().start();
		HpFactory hpFactory = new HpFactory();
		hpFactory.createDesktopComputer().start();
		hpFactory.createNotebookComputer().start();
	}
}

abstract class DesktopComputer {
	public abstract void start();
}

abstract class NotebookComputer {
	public abstract void start();
}

class LenovoFactory extends AbstractFactory {

	@Override
	public DesktopComputer createDesktopComputer() {
		// TODO Auto-generated method stub
		return new LenovoDesktopComputer();
	}

	@Override
	public NotebookComputer createNotebookComputer() {
		// TODO Auto-generated method stub
		return new LenovoNotebookComputer();
	}

}

class HpFactory extends AbstractFactory {
	@Override
	public DesktopComputer createDesktopComputer() {
		return new HpDesktopComputer();
	}

	@Override
	public NotebookComputer createNotebookComputer() {
		return new HpNotebookComputer();
	}
}

class LenovoDesktopComputer extends DesktopComputer {
	@Override
	public void start() {
		System.out.println("联想台式电脑启动");
	}
}

class HpDesktopComputer extends DesktopComputer {
	@Override
	public void start() {
		System.out.println("惠普台式电脑启动");
	}
}

class LenovoNotebookComputer extends NotebookComputer {
	@Override
	public void start() {
		System.out.println("联想笔记本电脑启动");
	}
}

class HpNotebookComputer extends NotebookComputer {
	@Override
	public void start() {
		System.out.println("惠普笔记本电脑启动");
	}
}
