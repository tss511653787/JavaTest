package test1;

public class Employee implements java.io.Serializable, Cloneable {
	// 可以序列话的属性
	public String id;
	public String name;
	// 地址为隐私信息 在序列化中不被保存
	public transient String address = null;
	public Integer num;
	// 不可以被序列化的属性
	public transient Integer SSN;

	public Employee() {
		super();
	}

	public Employee(String id, String name, String address, Integer num,
			Integer sSN) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.num = num;
		SSN = sSN;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ ", num=" + num + ", SSN=" + SSN + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getSSN() {
		return SSN;
	}

	public void setSSN(Integer sSN) {
		SSN = sSN;
	}

	public void mailCherk() {
		System.out.println("Mailing a cherk to " + name + " " + address);

	}

}
