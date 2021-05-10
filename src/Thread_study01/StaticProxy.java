package Thread_study01;

/**
 * 靜態代理 介面 1.真實角色 2.代理角色
 * 
 * @author YaoSheng
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMary();
//		new Thread(new XXX).start();
	}
}

interface Marry {
	void happyMary();
}

class You implements Marry {

	@Override
	public void happyMary() {
		System.out.println("you and 嫦娥終於奔月了");
	}
}

class WeddingCompany implements Marry{
	//真實結婚對象
	private Marry target;
	public WeddingCompany(Marry target) {
		super();
		this.target = target;
	}
	@Override
	public void happyMary() {
		before();
		this.target.happyMary();	
		after();
	}
	private void before(){
		System.out.println("布置");
	}
	
	private void after() {
		System.out.println("鬧玉兔");
	}
}