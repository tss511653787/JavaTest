package MianShiBaoDian;

import java.util.Hashtable;

public class Test1 {
	public static void main(String[] args) {
		Hashtable<String, Integer> table = new Hashtable<>();
		go(new Mybase());
	}

	static void go(Base b) {
		// TODO Auto-generated method stub
		b.add(8);
	}
}

// 这个有点意思哦
class Base {
	int i;

	Base() {
		add(1);
		System.out.println(i);
	}

	void add(int v) {
		// TODO Auto-generated method stub
		i += v;
		System.out.println(i);
	}

	public void print() {
		System.out.println(i);
	}
}

class Mybase extends Base {
	Mybase() {
		add(2);
	}

	void add(int v) {
		i = v * 2;
		System.out.println(i);
	}
}