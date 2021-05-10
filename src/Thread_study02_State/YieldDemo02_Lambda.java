package Thread_study02_State;
/**
 * 禮讓執行緒，讓CPU重新選擇調用哪個執行緒
 * @author YaoSheng
 *
 */

public class YieldDemo02_Lambda {

	public static void main(String[] args) {
		new Thread(()-> {
			for(int i=0; i<100; i++) {
				System.out.println("Lambda"+i);
			}
		}).start();
		
		for(int i = 0; i<100; i++) {
			if(i%20 == 0) {
				Thread.yield();
			}
			System.out.println("main"+i);
		}
	}
}
		