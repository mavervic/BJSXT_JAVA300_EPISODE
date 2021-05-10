package Thread_study03_Synchronized;

/**
 * 哲學家用餐問題
 * 
 * @author YaoSheng
 *
 */
public class DeadLock {

	public static void main(String[] args) {
		Makeup g1 = new Makeup(1, "媽媽");
		Makeup g2 = new Makeup(0, "妹妹");
		g1.start();
		g2.start();
	}

}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	int choice;
	String girl;

	public Makeup(int choice, String girl) {
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		makeup();
	}

	private void makeup() {
		if (choice == 0) {
			synchronized (lipstick) {
				System.out.println(this.girl + "塗口紅");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(this.girl + "照鏡子");
				}
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.girl + "照鏡子");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(this.girl + "塗口紅");
				}
			}
		}
	}
}