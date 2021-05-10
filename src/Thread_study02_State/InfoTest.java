package Thread_study02_State;
/**
 * 線程的其他方法
 * Thread.currentThread();
 * getName();
 * setName();
 * @author YaoSheng
 *
 */
public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		MyInfo info = new MyInfo("戰鬥機");
		Thread t = new Thread(info);
		t.setName("小雞");
		t.start();
		Thread.sleep(1000);
		System.out.println(t.isAlive());
	}

}
class MyInfo implements Runnable{
	private String name;
	
	public MyInfo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->" + name);
	}

	
	
	
}