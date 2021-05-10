package Thread_study01;

public class Racer implements Runnable{
	private String winner; //勝利者
	@Override
	public void run() {
		for(int steps=0; steps<=100; steps++) {
			System.out.println(Thread.currentThread().getName()+" > "+steps);
			try {
				if(Thread.currentThread().getName().equals("rabbit") && steps%10==0) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//比賽是否結束
			boolean flag = gameOver(steps);
			if(flag) {
				break;
			}
		}
	}
	
	public boolean gameOver(int steps) {
		if(winner != null) {
			return true;
		}else if(steps == 100){
			winner = Thread.currentThread().getName();
			System.out.println("winner is "+winner);
			return true;
		}else
			return false;
	}


	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer, "rabbit").start();
		new Thread(racer, "player2").start();
		
	}
}
