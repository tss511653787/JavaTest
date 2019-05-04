package ClassLoaderDome;

public class ReorderInVolatile {
	// 尝试写一个JVM实现字节码重排优化的例子
	// 使用volatile关键字修饰阻止了重排优化
	public static int flag = 0;

	public ReorderInVolatile() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (changeFlag())
					flag = 1;
			}
		});
		t.setPriority(5);


		Thread panduan = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (flag != 1) {

				}
				System.out.println("flag has been change!" + flag);
			}
		});
		panduan.setPriority(5);

		t.start();
		panduan.start();
	}

	public static boolean changeFlag() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
