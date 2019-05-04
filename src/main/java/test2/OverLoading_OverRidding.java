package test2;

public class OverLoading_OverRidding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Animals {
	private String name;

	public Animals(String name) {
		this.name = name;
	}

	public void Amethord(int num) {
		System.out.println("this is " + num);
	}

	public void Amethord(String num) {
		System.out.println("this is " + num);
	}
}

class Persion extends Animals {

	public Persion(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
	public void Amethord(int num) {
		// TODO Auto-generated method stub
		System.out.println("persion is " + num);
		
	}

}
