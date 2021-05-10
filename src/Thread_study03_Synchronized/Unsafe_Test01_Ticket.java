package Thread_study03_Synchronized;

public class Unsafe_Test01_Ticket {

	public static void main(String[] args) {
		Web12306 web = new Web12306();
		System.out.println(Thread.currentThread().getName());
		
		new Thread(web,"你").start();
		new Thread(web,"我").start();
		new Thread(web,"他").start();
	}
}

class Web12306 implements Runnable{
	private int ticketNum = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while(flag) {
			test();
			
			//模擬延時
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" > "+ticketNum--);
		}		
	}
	
	public void test() {
		if(ticketNum<0) {
			flag = false;
			return;
		}
	}
}