package Thread_study01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Racer02 implements Callable<Integer> {
	private String winner; // 勝利者

	@Override
	public Integer call() throws Exception {
		for (int steps = 0; steps <= 100; steps++) {
			System.out.println(Thread.currentThread().getName() + " > " + steps);
			if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps % 10 == 0) {
				Thread.sleep(1000);
			}
			// 比賽是否結束
			boolean flag = gameOver(steps);
			if(flag) {
				return steps;
			}
		}
		return null;
	}

	public boolean gameOver(int steps) {
		if (winner != null) {
			return true;
		} else if (steps == 100) {
			winner = Thread.currentThread().getName();
			System.out.println("winner is " + winner);
			return true;
		} else
			return false;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Racer02 racer = new Racer02();
		//建立執行服務
		ExecutorService ser = Executors.newFixedThreadPool(2);
		//提交執行
		Future<Integer> result1 = ser.submit(racer);
		Future<Integer> result2 = ser.submit(racer);
		//獲取結果
		Integer r1 = result1.get();
		Integer r2 = result2.get();
		System.out.println(r1+r2);
		
		//關閉服務
		ser.shutdownNow();

	}
}
