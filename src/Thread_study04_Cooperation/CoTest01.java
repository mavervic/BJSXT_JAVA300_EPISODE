package Thread_study04_Cooperation;

public class CoTest01 {

	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Product(container).start();
		new Costomer(container).start();
	}

}

//生產者
class Product extends Thread{
	SynContainer container;
	
	public Product(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.println("生產第"+i+"個饅頭");
			container.push(new Steamedbun(i));
		}
	}
}
//消費者
class Costomer extends Thread{
	SynContainer container;
	
	public Costomer(SynContainer container) {
		this.container = container;
	}

	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("消費"+container.pop().id+"個饅頭");
		}
	}
}
//緩存區
class SynContainer{
	int count = 0;
	Steamedbun[] buns = new Steamedbun[10];
	//存
	public synchronized void push(Steamedbun bun) {
		if(count == buns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	
	//取
	public synchronized Steamedbun pop() {
		//容器有數據才能消費
		if(count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		count--;
		Steamedbun bun = buns[count];
		this.notifyAll();
		return bun;
	}	
}
//饅頭
class Steamedbun{
	int id;

	public Steamedbun(int id) {
		this.id = id;
	}
	
}