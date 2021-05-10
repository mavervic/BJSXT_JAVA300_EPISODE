package Date_study;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeatDateFormat {
	public static void main(String[] args) throws ParseException {
		
		//把Date物件實體按照設定的格式轉成String印出來
		DateFormat df = new SimpleDateFormat("yyyy年-MM-dd hh-mm-ss");
		String str = df.format(new Date(40000000));
		System.out.println(str);
		
		//把字串按照格式轉成Date物件實體
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh時mm分ss秒");
		Date date = df2.parse("1990年05月10日 10時30分59秒");
		System.out.println(date);
		
		//測試其他的字符，例如利用D顯示物件實體是該年的第幾天
		DateFormat df3 = new SimpleDateFormat("D");
		String str3 = df3.format(new Date());
		System.out.println(str3);
		
		
	}
}
