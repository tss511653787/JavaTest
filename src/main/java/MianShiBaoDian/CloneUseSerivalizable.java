package MianShiBaoDian;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import test1.*;

public class CloneUseSerivalizable {
	// 使用本地序列化方法实现对象的克隆
	// 效率很低

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("001", "马祥振", "neu", 10, 18);
		ByteArrayOutputStream byout = new ByteArrayOutputStream();
		ObjectOutputStream objout = new ObjectOutputStream(byout);
		objout.writeObject(e1);
		// 反序克隆
		ByteArrayInputStream byin = new ByteArrayInputStream(
				byout.toByteArray());
		ObjectInputStream objin = new ObjectInputStream(byin);
		Employee cloneE = (Employee) objin.readObject();
		System.out.println(cloneE);
	}

	public static Employee clone(Employee e) throws CloneNotSupportedException {
		return (Employee) e.clone();
	}

}
