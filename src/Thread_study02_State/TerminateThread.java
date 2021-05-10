package Thread_study02_State;
/**
 * 終止Thread
 * @author YaoSheng
 *
 */
public class TerminateThread implements Runnable{
	private String name;
	private boolean flag = true;

	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		
		//true表示運作
		while(flag) {
			System.out.println(name + " > " + i++);
		}
	}
	
	public void terminate() {
		this.flag = false;
	}
	
	public static void main(String[] args) {
		TerminateThread tt = new TerminateThread("C");
		new Thread(tt).start();
		
		for(int i=0; i<=99; i++) {
			if(i==88){
				tt.terminate();
				System.out.println("tt88");
			}
			System.out.println("main"+i);
		}
	}

}
