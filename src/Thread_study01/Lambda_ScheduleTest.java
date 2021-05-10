package Thread_study01;

public class Lambda_ScheduleTest {

	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println("123456");
		}).start();
		
		
		
//		new TimerTask(()-> {
//			
//		}).scheduleAtFixedRate(task, firstTime, period);
		
//		Timer timer = new Timer();
//		Calendar c = new GregorianCalendar(2020,Calendar.MARCH,25,00,00,00);
//		timer.scheduleAtFixedRate(task, c.getTime(), 1*60*1000);
		
	}

}
