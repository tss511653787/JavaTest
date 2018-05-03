package Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class LambdaInAction {
	public static void main(String[] args) {
		List<Persion> persionList;
		persionList = new ArrayList<>();
		persionList.add(new Persion());
		persionList.add(new Persion());
		persionList.add(new Persion("kk", 5));
		Stream<Persion> perStream = persionList.stream();
		// perStream.forEach(per -> per.setAge(per.getAge() + 1));
		Persion[] arrPersion = perStream.toArray(Persion[]::new);
		for (Persion p : arrPersion) {
			System.out.println(p);
		}
	}

}

class Persion {
	private String name;
	private int age;

	public Persion() {
		name = "tss";
		age = 25;
	}

	public Persion(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + age;
	}

}
