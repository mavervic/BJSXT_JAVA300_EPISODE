package IO_study03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 1.寫出後讀取 2.讀取順序與寫入一樣 3.不是所有物件實體都可以序列化Serializable
 * 
 * ObjectInputStream ObjectOutputStream
 * 
 * @author YaoSheng
 *
 */
public class ObjectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 寫出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));

		// 操作數據類型
		oos.writeUTF("編碼辛酸淚");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		oos.writeObject("誰解其中味");
		oos.writeObject(new Date());
		Employee emp = new Employee("馬雲", 400);
		oos.writeObject(emp);
		oos.flush();

		byte[] datas = baos.toByteArray();
		System.out.println(datas.length);
		// 讀取
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		// 與寫入順序一致
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println();
		Object str = ois.readObject();
		Object date = ois.readObject();
		Object employee = ois.readObject();
		
		if(str instanceof String) {
			String strObj = (String)str;
			System.out.println(strObj);
		}
		
		if(date instanceof Date) {
			Date dateObj = (Date)date;
			System.out.println(dateObj);
		}
		
		if(employee instanceof Employee) {
			Employee empObj = (Employee)employee;
			System.out.println(empObj.getName()+">"+empObj.getSalary());
		}
	}

}

//javabean 封裝數據用
class Employee implements java.io.Serializable{
	private transient String name; //transient表示該數據不進行序列化
	private double salary;

	public Employee() {
	}

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
