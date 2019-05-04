package Designpatterns.Adapter;

/*
 * 中介者模式:使用一个中介对象作为两个实例对象之间的交互桥梁
 * 每个实例对象不需要彼此过多依赖，使用中介者进行信息的交互
 * 符合迪米特原则
 * 松散耦合
 * eg：使用Mediator中介者转发信息
 * */

public abstract class Mediator {
	public abstract void sendMessage(String message, Persion per);

	// test
	public static void main(String[] args) {
		ContreteMediator me = new ContreteMediator();
		Teacher t = new Teacher(me);
		Student s = new Student(me);
		me.setStu(s);
		me.setTea(t);
		t.sendMessage("留作业");
		s.sendMessage("知道了");
	}
}

abstract class Persion {
	// 人的抽象角色
	Mediator mediator;

	abstract void sendMessage(String message);

	abstract void getMessage(String message);

	public Persion(Mediator mediator) {
		super();
		this.mediator = mediator;
	}

}

// 具体的每个人
class Teacher extends Persion {

	public Teacher(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	void sendMessage(String message) {
		// TODO Auto-generated method stub
		mediator.sendMessage(message, this);
	}

	@Override
	void getMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("teacher has recived message:" + message);
	}

}

class Student extends Persion {

	public Student(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	void sendMessage(String message) {
		// TODO Auto-generated method stub
		mediator.sendMessage(message, this);
	}

	@Override
	void getMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("student has recived message:" + message);
	}

}

class ContreteMediator extends Mediator {
	// 持有每个具体对象的引用
	private Student stu;
	private Teacher tea;

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	@Override
	public void sendMessage(String message, Persion per) {
		// TODO Auto-generated method stub
		// 消息的转发逻辑
		if (per == stu) {
			tea.getMessage(message);
		} else if (per == tea) {
			stu.getMessage(message);
		}
	}

}
