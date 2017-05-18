package Designpatterns.Adapter;

/*
 * 状态模式:和策略模式非常相似
 * 都是避免过多的条件语句 使得类的结构 更清晰
 * 没一个状态都是一个类方便增加和修改
 * 使用一个环境角色对象空置具体类的状态
 * eg:MP3的状态变化设定
 * */

public interface State {
	// 开机
	public abstract void powerOn();

	public abstract void powerOff();

	public abstract void next();

	public abstract void pre();

	// test
	public static void main(String[] args) {
		ContextMp3 m = new ContextMp3(new PowerOn());
		m.powerOn();
		m.powerOn();
		m.next();
		m.powerOff();
		m.powerOn();
		m.next();
	}

}

// 具体的状态类实现
class PowerOn implements State {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("已开机");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("关机");
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		System.out.println("播放下一首");
	}

	@Override
	public void pre() {
		// TODO Auto-generated method stub
		System.out.println("播放上一首");
	}

}

class PowerOff implements State {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("开机");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pre() {
		// TODO Auto-generated method stub

	}

}

class ContextMp3 {
	State st;

	public void setSt(State st) {
		this.st = st;
	}

	public ContextMp3(State st) {
		super();
		this.st = st;
	}

	public void powerOn() {
		st.powerOn();
		setSt(new PowerOn());
	}

	public void powerOff() {
		st.powerOff();
		setSt(new PowerOff());
	}

	public void next() {
		st.next();
	}

	public void pre() {
		st.pre();
	}
}
