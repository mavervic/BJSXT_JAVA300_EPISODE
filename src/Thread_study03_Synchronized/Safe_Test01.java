package Thread_study03_Synchronized;
/**
 * synchronized
 * 1.同步方法
 * 2.同步塊
 * @author YaoSheng
 *
 */
public class Safe_Test01 {

	public static void main(String[] args) {
		SafeWeb12306 web = new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		
		new Thread(web,"你").start();
		new Thread(web,"我").start();
		new Thread(web,"他").start();
	}
}

class SafeWeb12306 implements Runnable{
	private int ticketNum = 100;
	private boolean flag = true;

	@Override
	public void run() {
		while(flag) {
			test();
		}		
	}
	
	public synchronized void test() {
		if(ticketNum<=0) {
			flag = false;
			return;
		}
		//模擬延時
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" > "+ticketNum--);
	}
}