package Date_study;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		//取得現在時間的毫秒數
		System.out.println(d.getTime());
		//自己創一個時間
		Date d2 = new Date(2020-1900,3,10);
		System.out.println(d2);
	}

}
