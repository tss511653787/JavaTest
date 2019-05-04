package Review;


public class ThreadTest extends Thread {

	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest ts = new ThreadTest();
		t1.start();
		System.out.println("one");
		ts.start();
		System.out.println("two");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread" + Thread.currentThread().getName());
	}

}