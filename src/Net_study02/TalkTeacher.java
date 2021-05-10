package Net_study02;

public class TalkTeacher {

	public static void main(String[] args) {
		new Thread(new TalkReceive("學生",9999)).start();
		new Thread(new TalkSend(5555,"localhost",8888)).start();
	}

}
