package Thread_study02_State;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * 媽媽讓兒子去買米
 * 兒子拿了錢在路上鬼混了10秒才去買
 * 兒子回來後媽媽開始洗米
 * @author YaoSheng
 *
 */
public class BlockedJoin01 {
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Mon()).start();
	}
}

class Mon implements Runnable{
	@Override
	public void run() {
		System.out.println("媽媽讓兒子去買米");
		Thread son = new Thread(new Son());
		son.start();
		try {
			son.join();
			System.out.println("兒子終於買到米回來了");
			System.out.println("媽媽開始煮米了");
		} catch (InterruptedException e) {
			System.out.println("兒子出去太久媽媽出發去找兒子");
			e.printStackTrace();
		} 
		
	}
}

class Son implements Runnable{
	@Override
	public void run() {
		System.out.println("兒子出發了");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"秒過去");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
