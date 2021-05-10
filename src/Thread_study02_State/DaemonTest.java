package Thread_study02_State;
/**
 * 守護線程Daemon[ˈdēmən]
 * jvm的終止不必等守護線程執行完畢
 * @author YaoSheng
 *
 */
public class DaemonTest {

	public static void main(String[] args) {
		new Thread(new You()).start();
		Thread t = new Thread(new God());
		t.setDaemon(true); //設定為守護線程
		t.start();
	}

}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 365 * 100; i++) {
			System.out.println("充實的度過了一天");
		}
	}
}

class God implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("上帝每天守護著生靈");
		}
	}
}