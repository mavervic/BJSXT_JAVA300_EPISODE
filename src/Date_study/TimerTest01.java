package Date_study;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		// 一秒後執行一次
//		timer.schedule(new myTask(), 1000);
		// 執行多次
//		timer.schedule(new myTask(), 1000, 1000);
		// 指定時間執行
		Calendar cal = new GregorianCalendar(2020, Calendar.MARCH, 21, 0, 0, 0);
		timer.scheduleAtFixedRate(new myTask(), cal.getTime(), 1*60*60*1000);

	}

}

class myTask extends TimerTask {
	@Override
	public void run() {
		System.out.println(new Date(scheduledExecutionTime()));
	}
}