package IO_study03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class ObjectTest02File {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 寫出
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));

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
		oos.close();

		// 讀取
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
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
		ois.close();
	}
}
