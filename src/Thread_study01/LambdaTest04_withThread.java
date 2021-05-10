package Thread_study01;

/**
 * Lambda推導，加入參數
 * 
 * @author YaoSheng
 *
 */
public class LambdaTest04_withThread {
	public static void main(String[] args) {
		new Thread (()->{
			for(int i=0; i<10; i++) {
				System.out.println(i);
			}
		}).start();
		
		new Thread (()->{
			for(int i=10; i<20; i++) {
				System.out.println(i);
			}
		}).start();
	}
}