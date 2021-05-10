package Thread_study03_Synchronized;

public class HappyCinama {

	public static void main(String[] args) {
		Cinama c = new Cinama(2, "Hello World Cinama");
		new Thread(new Customer(c, 2),"老高").start();
		new Thread(new Customer(c, 1),"老裴").start();
	}

}

class Customer implements Runnable{
	Cinama cinama;
	int seats;
	
	public Customer(Cinama cinama, int seats) {
		this.cinama = cinama;
		this.seats = seats;
	}

	@Override
	public void run() {
		synchronized(cinama) {
			boolean flag = cinama.bookTicket(seats);
			if(flag) {
				System.out.println("出票成功"+Thread.currentThread().getName()+"位置為"+seats);
			}else {
				System.out.println("出票失敗"+Thread.currentThread().getName()+"位置不夠");
			}
		}
	}
}

class Cinama{
	int available;
	String name;
	
	public Cinama(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}

	public boolean bookTicket(int seats) {
		System.out.println("可用位置為" + available);
		if(seats>available) {
			return false;
		}
		available -= seats;
		return true;
	}
}
