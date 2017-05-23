package Designpatterns.Adapter;

/*
 * 职责链模式
 * 每个实现职责类的对象组成一个链表 
 * 按照请求等级遍历链表控制哪一个对象处理请求
 * 链表中每个类都有处理请求的机会
 * 类的递归调用
 * */

public abstract class Handler {
	private Handler nexthandler;

	public final Response handleMessage(Request request) {
		Response res = null;
		if (this.getHandleLevel() == (request.getLevel())) {
			// 自己处理
			return this.echo(request);
		} else if (this.nexthandler != null) {
			res = this.nexthandler.handleMessage(request);
			return res;
		} else {
			// 如果自己后面没有处理节点则自己处理
			return this.echo(request);
		}
	}

	abstract int getHandleLevel();

	abstract Response echo(Request request);

	public void setNexthandler(Handler nexthandler) {
		this.nexthandler = nexthandler;
	}

	// test
	public static void main(String[] args) {
		Handle1 h1 = new Handle1();
		Handle2 h2 = new Handle2();
		Handle3 h3 = new Handle3();
		h1.setNexthandler(h2);
		h2.setNexthandler(h3);
		Request r = new Request(3);
		System.out.println(h1.handleMessage(r).getRes());
	}
}

class Response {
	// 处理者返回的数据
	String res;

	public String getRes() {
		return res;
	}

	public Response(String res) {
		super();
		this.res = res;
	}

}

class Request {
	// 请求等级
	int Level;

	public int getLevel() {
		return Level;
	}

	public Request(int level) {
		super();
		Level = level;
	}

	public void setLevel(int level) {
		Level = level;
	}

}

// 具体的职责链处理节点
class Handle1 extends Handler {

	@Override
	int getHandleLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	Response echo(Request request) {
		// TODO Auto-generated method stub
		return new Response("职责1处理请求");
	}

}

class Handle2 extends Handler {

	@Override
	int getHandleLevel() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	Response echo(Request request) {
		// TODO Auto-generated method stub
		return new Response("职责2处理请求");
	}

}

class Handle3 extends Handler {

	@Override
	int getHandleLevel() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	Response echo(Request request) {
		// TODO Auto-generated method stub
		return new Response("职责3处理请求");
	}

}
