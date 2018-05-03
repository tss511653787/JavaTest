package Review;

import java.util.ArrayList;
import java.util.List;

class Person {
	String name = "No name";

	public Person() {
		super();
	}

	public Person(String nm) {
		name = nm;
	}
}

class Employee1 extends Person {
	String empID = "0000";

	public Employee1(String id) {
		super();
		empID = id;
	}
}

public class ttt {
	public static void main(String args[]) {
		Employee1 e = new Employee1("123");
		System.out.println(e.empID);

	}
}
