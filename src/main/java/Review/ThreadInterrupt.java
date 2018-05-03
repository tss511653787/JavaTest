package Review;

/*
 * Thread的interrupted 和 isInterrupted的区别
 * interrupted()方法是一个静态方法会检测当前线程是否被中断 同时会清除线程的中断状态
 * isInterrupted()检测是否被中断 不会改变中断状态
 * */
public class ThreadInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread();
		t.start();
		//向线程发出中断请求
		t.interrupt();
		if (t.isInterrupted()) {
			System.out.println(t.getName() + " has been interrupt");
		}
	}
}
