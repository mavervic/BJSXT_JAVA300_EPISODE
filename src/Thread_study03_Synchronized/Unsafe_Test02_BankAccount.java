package Thread_study03_Synchronized;
/**
 * 取錢，執行緒不安全
 * @author YaoSheng
 *
 */
public class Unsafe_Test02_BankAccount {
	public static void main(String[] args) {
		Account account = new Account(100, "結婚禮金");
		Drawing me = new Drawing(account,80,"我");
		Drawing wife = new Drawing(account,90,"他");
		me.start();
		wife.start();
	}
}



class Drawing extends Thread{
	Account account; //取錢的帳戶
	int drawMoney; //取的數目
	int pocketTotal; //取錢的總數
	
	public Drawing(Account account, int drawMoney, String name) {
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}

	@Override
	public void run() {
		//判斷式避免帳戶變成負數
		if(account.money-drawMoney < 0) {
			return;
		}
		
		//模擬網路延遲，看看會不會都有取到錢，帳戶餘額錯誤甚至變負數
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