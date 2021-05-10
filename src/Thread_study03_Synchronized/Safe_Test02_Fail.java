package Thread_study03_Synchronized;
/**
 * 取錢，執行緒不安全
 * @author YaoSheng
 *
 */
public class Safe_Test02_Fail {
	public static void main(String[] args) {
		Account account = new Account(100, "結婚禮金");
		FailDrawing me = new FailDrawing(account,80,"我");
		FailDrawing gf = new FailDrawing(account,90,"他");
		me.start();
		gf.start();
	}
}

class FailDrawing extends Thread{
	Account account; //取錢的帳戶
	int drawMoney; //取的數目
	int pocketTotal; //取錢的總數
	
	public FailDrawing(Account account, int drawMoney, String name) {
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}

	@Override
	public void run() {
		test();
	}
	
	//synchronized鎖錯資源，應該鎖領錢的地方(ATM或是說帳戶)
	public synchronized void test() {
		if(account.money-drawMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money -= drawMoney;
		pocketTotal += drawMoney;
		System.out.println(this.getName()+" 帳戶餘額: "+account.money);
		System.out.println(this.getName()+" 口袋裡的錢: "+pocketTotal);
	}
}