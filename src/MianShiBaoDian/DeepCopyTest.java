package MianShiBaoDian;

/*
 * 对比前拷贝和神拷贝的区别
 * */

public class DeepCopyTest {
	private String Uid;

	class DeepCopy implements Cloneable {
		private String part;
		Employee e;

		public DeepCopy(String part, Employee e) {
			super();
			this.part = part;
			this.e = e;
		}

		@Override
		protected DeepCopy clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			DeepCopy copy = (DeepCopy) super.clone();
			copy.e = e.clone();
			return copy;
		}
	}

	class shallowCopy implements Cloneable {
		private String part;
		Employee e;

		public shallowCopy(String part, Employee e) {
			super();
			this.part = part;
			this.e = e;
		}

		@Override
		protected shallowCopy clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return (shallowCopy) super.clone();
		}

	}

	class Employee implements Cloneable {
		int id;
		String name;

		public Employee(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public Employee clone() throws CloneNotSupportedException {
			return (Employee) super.clone();
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		DeepCopyTest t = new DeepCopyTest();
		Employee p1 = t.new Employee(10, "kkk");
		shallowCopy s1 = t.new shallowCopy("aaa", p1);
		Employee p2 = t.new Employee(20, "mmm");
		DeepCopy d1 = t.new DeepCopy("bbb", p2);
		shallowCopy s11 = s1.clone();
		System.out.println(s11.e.name);
		p1.name = "kkkl";
		System.out.println(s11.e.name);
		System.out.println(s11.e == p1);
		DeepCopy d11 = d1.clone();
		System.out.println(d11.e.name);
		p2.name = "mmml";
		System.out.println(d11.e.name);
		System.out.println(d11.e == p2);
	}
}
