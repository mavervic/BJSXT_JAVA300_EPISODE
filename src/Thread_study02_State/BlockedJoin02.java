package Thread_study02_State;

public class BlockedJoin02 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			for(int i = 0; i<100; i++) {
				System.out.println("lambda " + i);
			}
		});
		
		t.start();
		
		for(int i = 0; i<100; i++) {
			if(i == 20) {
				t.join(); //t插隊，main被阻塞
			}
			System.out.println(" main " + i);
		}
	}
}
