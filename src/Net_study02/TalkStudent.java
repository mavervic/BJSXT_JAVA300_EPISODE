package Net_study02;

public class TalkStudent {

	public static void main(String[] args) {
		new Thread(new TalkSend(7777,"localhost",9999)).start();
		new Thread(new TalkReceive("老師",8888)).start();
	}

}
