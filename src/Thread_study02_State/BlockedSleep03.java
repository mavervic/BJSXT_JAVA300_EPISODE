package Thread_study02_State;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedSleep03 {

	public static void main(String[] args) throws InterruptedException {
		//沒意義又奇怪的倒數計時範例
		Date prevTime = new Date(System.currentTimeMillis() + (1000 *10));
		long endTime = prevTime.getTime() - (1000 * 10);
		
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(prevTime));
			Thread.sleep(1000);
			prevTime = new Date(prevTime.getTime() - 1000);
			if(prevTime.getTime() < endTime) {
				break;
			}
		}
	}
}