package Thread_study03_Synchronized;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 * 多執行緒不安全，集合丟失
 * @author YaoSheng
 *
 */
public class Safe_Test03_Concurrent {

	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList list = new CopyOnWriteArrayList<>();		
		for(int i=0; i<10000; i++) {
			new Thread(()-> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		Thread.sleep(100);
		System.out.println(list.size());
	}
}