package HuaWeiTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Compara {
	public static void main(String[] args) {
		Stu s1 = new Stu(5, "tss");
		Stu s2 = new Stu(10, "sy");
		Man m1 = new Man(16, "zmh");
		Man m2 = new Man(0, "ll");
		Man m3 = new Man(49, "llh");
		Man m4 = new Man(3, "kll");
		Man m5 = new Man(1, "lbl");
		Man m6 = new Man(0, "lcl");
		if (s1.compareTo(s2) == 1)
			System.out.println(true);
		CompareMan CM = new CompareMan();
		TreeSet<Man> tree = new TreeSet<Man>(CM);
		tree.add(m1);
		tree.add(m2);
		tree.add(m3);
		tree.add(m4);
		tree.add(m5);
		tree.add(m6);
		for (Man out : tree) {
			System.out.print(out.age + " ");
		}

	}

}

class Stu implements Comparable<Stu> {

	int age;
	String name;

	public Stu(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Stu o) {
		// TODO Auto-generated method stub
		if (this.age > o.age)
			return 1;
		else
			return 0;
	}
}

class Man {
	int age;
	String name;

	public Man(int age, String name) {
		this.age = age;
		this.name = name;
	}

}

class CompareMan implements Comparator<Man> {

	@Override
	public int compare(Man o1, Man o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}

}
