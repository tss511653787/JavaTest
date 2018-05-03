package Test4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerializable {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException, InterruptedException {
		Person me = new Person("tss", null);
		Person father = new Person("ty", me);
		Person grandpa = new Person("thc", father);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:/Users/dell/Desktop/test"));
		oos.writeObject(me);
		oos.writeObject(father);
		oos.writeObject(grandpa);
		oos.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"C:/Users/dell/Desktop/test"));
		Person outme = (Person) in.readObject();
		Person outfa = (Person) in.readObject();
		Person outgr = (Person) in.readObject();
		System.out.println(outgr.son.son.name);
		Thread th1= new Thread();


	}

	// 内部类
	private static class Person implements Serializable {
		public final String name;
		public final Person son;

		public Person(String name, Person son) {
			this.name = name;
			this.son = son;
		}

	}
}
