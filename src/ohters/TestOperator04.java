package ohters;
/*
 * https://www.bilibili.com/video/BV1L7411N77n?p=45
 * https://www.bilibili.com/video/BV1L7411N77n?p=46
 */
public class TestOperator04 {

	public static void main(String[] args) {
		int i = 7;
		int j = 8;
		
		System.out.println(i&j); //0
		System.out.println(i|j); //15
		System.out.println(i^j); //15
		System.out.println(~j); //-9
		
		//移位運算
		int k = 5 << 2; //表示5*2兩次
		System.out.println(k); //20
		System.out.println(40 >> 3); //表示40/2三次
		
		//char的加法
		char c1 = 'b'; //98
		char c2 = 'a'; //97
		System.out.println(c1+c2); //98+97=195
		System.out.println(""+c1+c2);
		
		//複雜優先級問題用小括號解決
		boolean b = (3>1||1<4)&&(4<6);
		System.out.println(b);
		
		//溢位問題
		long l1 = 100*60*24*365*80;	//人一生的心跳數
		long l2 = 100L*60*24*365*80;//人一生的心跳數
		System.out.println(l1);	//-90167296
		System.out.println(l2);	//4204800000
	}
}
