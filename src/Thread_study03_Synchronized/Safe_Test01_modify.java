package Thread_study03_Synchronized;
/**
 * synchronized
 * 1.同步方法
 * 2.同步塊
 * @author YaoSheng
 *
 */
public class Safe_Test01_modify {

	public static void main(String[] args) {
		SafeWeb12306_modify web = new SafeWeb12306_modify();
		System.out.println(Thread.currentThread().getName());
		
		new Thread(web,"你").start();
		new Thread(web,"我").start();
		new Thread(web,"他").start();
	}
}

class SafeWeb12306_modify implements Runnable{
	private int ticketNum = 100;
	private boolean flag = true;

	@Override
	public void run() {
		while(flag) {
			test();
		}		
	}
	
	public void test() {
		//2.考慮票數為0執行緒仍在等待(第一步與第二步合稱double checking)
		if(ticketNum<=0) {
			flag = false;
			return;
		}
		
		//1.考慮剩下一張票不能讓票數變成負數
		synchronized(this) {
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
}