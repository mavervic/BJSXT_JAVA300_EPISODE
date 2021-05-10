package Thread_study02_State;
/**
 * Sleep模擬網路延時，搶火車票
 * @author YaoSheng
 *
 */
public class BlockedSleep01 {

	public static void main(String[] args) {
		Web12306 web = new Web12306();
		System.out.println(Thread.currentThread().getName());
		
		new Thread(web,"你").start();
		new Thread(web,"我").start();
		new Thread(web,"他").start();
	}

}

class Web12306 implements Runnable{
	private int ticketNum = 20;

	@Override
	public void run() {
		while(true) {
			if(ticketNum<0) {
				break;
			}
			//模擬延時
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"看到的票數 > "+ticketNum--);
		}
		
		
	}
}
