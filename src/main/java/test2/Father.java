package test2;

//方法的overload重载和override重写

class Fatherr {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float PrintF(double a) {
		return 3.4f;
	}

}

class Son extends Fatherr {

	public double PrintF(double a, double b) {
		// TODO Auto-generated method stub
		return 3.4f;
	}

}

public class Father {
	public static void main(String[] args) {
		Fatherr a = new Fatherr();
		a.setAge(10);
		Fatherr b = new Fatherr();
		a.setAge(10);
		Fatherr c = b;
		if (b.equals(c))
			System.out.println("true");
	}

}
