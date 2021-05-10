package Thread_study03_Synchronized;

public class Happy12306 {

	public static void main(String[] args) {
		Train12306 t = new Train12306(2, "Hello World Cinama");
		new Passenger(t,"老高", 2).start(); 
		new Passenger(t,"老裴", 2).start(); 
	}
}

class Passenger extends Thread{
	int seats;
	public Passenger(Runnable target, String name, int seats) {
		super(target,name);
		this.seats = seats;
	}
}

class Train12306 implements Runnable {
	int available;
	String name;

	public Train12306(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}

	@Override
	public void run() {
		Passenger p = (Passenger)Thread.currentThread();
		boolean flag = this.bookTicket(p.seats);
		if (flag) {
			System.out.println("出票成功" + Thread.currentThread().getName() + "位置為" + p.seats);
		} else {
			System.out.println("出票失敗" + Thread.currentThread().getName() + "位置不夠");
		}
	}
	
	public synchronized boolean bookTicket(int seats) {
		System.out.println("可用位置為" + available);
		if (seats > available) {
			return false;
		}
		available -= seats;
		return true;
	}
}
