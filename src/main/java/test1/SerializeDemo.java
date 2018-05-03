/**
 * 
 */
package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author dell
 *
 */
public class SerializeDemo {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		// 序列化
		SerializeIn();
		// 反序列化
		// UnSerialize();

	}

	public static void SerializeIn() throws IOException {
		// 序列化Employee对象
		Employee e = new Employee();
		e.setId("150");
		e.setAddress("东北大学");
		e.setName("tss");
		e.setNum(25);
		e.setSSN(1550);
		System.out.println(e);
		String filePath = "C:/Users/Administrator/Desktop/employee.ser";
		File file = new File(filePath);
		FileOutputStream fileoutput = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileoutput);
		out.writeObject(e);
		out.close();
		fileoutput.close();
	}

	public static void UnSerialize() throws IOException, ClassNotFoundException {
		String filePath = "C:/Users/Administrator/Desktop/employee.ser";
		FileInputStream filein = new FileInputStream(filePath);
		ObjectInputStream in = new ObjectInputStream(filein);
		Employee e = (Employee) in.readObject();
		System.out.println(e);
	}

}
