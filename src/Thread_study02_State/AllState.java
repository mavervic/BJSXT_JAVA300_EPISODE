package Thread_study02_State;

import java.lang.Thread.State;

public class AllState {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("...");
			}
		});
		
		//觀察狀態
		State state = t.getState();
		System.out.println(state); //new
		
		t.start();
		state = t.getState();
		System.out.println(state); //runnable
		
		while(state != Thread.State.TERMINATED) {
			System.out.println(Thread.activeCount());
			try {
				Thread.sleep(100);
				state = t.getState();
				System.out.println(state);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
