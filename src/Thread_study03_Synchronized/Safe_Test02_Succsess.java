package Thread_study03_Synchronized;
/**
 * 取錢，執行緒不安全
 * @author YaoSheng
 *
 */
public class Safe_Test02_Succsess {
	public static void main(String[] args) {
		Account account = new Account(100, "結婚禮金");
		SuccsessDrawing me = new SuccsessDrawing(account,80,"我");
		SuccsessDrawing gf = new SuccsessDrawing(account,90,"他");
		me.start();
		gf.start();
	}
}

class SuccsessDrawing extends Thread{
	Account account; //取錢的帳戶
	int drawMoney; //取的數目
	int pocketTotal; //取錢的總數
	
	public SuccsessDrawing(Account account, int drawMoney, String name) {
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}

	@Override
	public void run() {
		test();
	}
	
	public synchronized void test() {
		//2.提高效率
		if(account.money <= 0) {
			return;
		}
		
		//1.鎖上帳戶
		synchronized(account) {
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
}