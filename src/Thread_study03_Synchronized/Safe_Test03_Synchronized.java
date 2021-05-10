package Thread_study03_Synchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * 多執行緒不安全，集合丟失
 * @author YaoSheng
 *
 */
public class Safe_Test03_Synchronized {

	public static void main(String[] args) throws InterruptedException {
		List list = new ArrayList<>();		
		for(int i=0; i<10000; i++) {
			new Thread(()-> {
				synchronized(list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(list.size());
	}
}