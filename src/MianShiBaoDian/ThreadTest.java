package MianShiBaoDian;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread(new PingPrint());
		t.start();
		System.out.println("pong");
	}
}

class PingPrint extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ping");

	}
}
