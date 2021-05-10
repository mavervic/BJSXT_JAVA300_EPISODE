package ohters;
/*
 * https://www.bilibili.com/video/BV1L7411N77n?p=37
 */
public class TestFloatNumber {

	public static void main(String[] args) {
		double d1 = 3.14;
		double d2 = 3.14E2;
		System.out.println(d1);
		System.out.println(d2);
		
		//浮點數是不精確的
		float d3 = 0.1f;
		double d4 = 1.0/10;
		System.out.println(d4);
		System.out.println(d3 == d4);//false
		
		float f5 = 23432412341L;
		float f6 = f5+1;
		System.out.println(f5 == f6);//true
		
		
		//取特定位數的浮點數
		double d5 = 10.0/3;
		System.out.println(d5);
		System.out.println(Math.round(d5*100)/100.0);
		
	}
}
