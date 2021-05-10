package Thread_study03_Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 多執行緒不安全，集合丟失
 * @author YaoSheng
 *
 */
public class Unsafe_Test03_Collection {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();		
		for(int i=0; i<10000; i++) {
			new Thread(()-> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		
		
		
		Vector<String> vector = new Vector<String>();
		for(int i=0; i<10000; i++) {
			new Thread(()-> {
				vector.add(Thread.currentThread().getName());
			}).start();
		}
		
		try {
			Thread.sleep(1000);
			//size應該等於10000
			System.out.println("list.size= " + list.size());
			//size應該等於10000
			System.out.println("vector.size= " + vector.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}