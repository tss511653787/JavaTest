package MianShiBaoDian;

/*
 * JVM仅仅会调用一次类的finalize方法
 * 判断有没有必要将对象放入F-queue队列中条件是finalize又没被覆盖或已经被调用
 * 具体看笔记 对象如何在finalize中解救自己
 * */
public class Finalize {
	public static Finalize SAVE = null;

	public void isAlive() {
		System.out.println("i am alive");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize has execute!");
		// 解救自己
		SAVE = this;
	}

	// test
	public static void main(String[] args) throws InterruptedException {
		SAVE = new Finalize();
		SAVE = null;
		System.gc();
		Thread.sleep(600);
		if (SAVE != null) {
			SAVE.isAlive();
		} else {
			System.out.println("dead");
		}
		// 对象的finalize方法只会运行一次
		SAVE = null;
		System.gc();
		Thread.sleep(600);
		if (SAVE != null) {
			SAVE.isAlive();
		} else {
			System.out.println("dead");
		}
	}

}
