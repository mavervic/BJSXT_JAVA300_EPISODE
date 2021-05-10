package Thread_study02_State;
/**
 * 禮讓執行緒，讓CPU重新選擇調用哪個執行緒
 * @author YaoSheng
 *
 */

public class YieldDemo01 {

	public static void main(String[] args) {
		MyYield my = new MyYield();
		new Thread(my,"a").start();
		new Thread(my,"b").start();
	}

}

class MyYield implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" > start");
		Thread.yield();//禮讓
		System.out.println(Thread.currentThread().getName()+" > end");
	}
	
}