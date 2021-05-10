package Thread_study03_Synchronized;

import java.util.ArrayList;
import java.util.List;

public class HappyCinama2 {
	
	public static void main(String[] args) {
		List<Integer> available = new ArrayList<>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		
		List<Integer> seats1 = new ArrayList<>();
		seats1.add(1);
		seats1.add(2);
		seats1.add(3);		
		List<Integer> seats2 = new ArrayList<>();
		seats2.add(4);	
		seats2.add(5);	
		
		
		Cinama2 c = new Cinama2(available, "Hello World Cinama");
		new Thread(new HappyCustomer(c, seats1), "老高").start();
		new Thread(new HappyCustomer(c, seats2), "老裴").start();
	}

}

class HappyCustomer implements Runnable {
	Cinama2 cinama;
	List<Integer> seats;

	public HappyCustomer(Cinama2 cinama, List<Integer> seats) {
		this.cinama = cinama;
		this.seats = seats;
	}

	@Override
	public void run() {
		synchronized (cinama) {
			boolean flag = cinama.bookTicket(seats);
			if (flag) {
				System.out.println("出票成功" + Thread.currentThread().getName() + "位置為" + seats);
			} else {
				System.out.println("出票失敗" + Thread.currentThread().getName() + "位置不夠");
			}
		}
	}
}

class Cinama2 {
	List<Integer> available;
	String name;

	public Cinama2(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}

	public boolean bookTicket(List<Integer> seats) {
		System.out.println("歡迎光臨戲院，可用位置為" + available);
		List<Integer> temp = new ArrayList<>();
		temp.addAll(available);

		// 相減
		temp.removeAll(seats);
		// 判斷大小
		if (available.size() - temp.size() != seats.size()) {
			return false;
		}
		available = temp;
		return true;
	}
}
