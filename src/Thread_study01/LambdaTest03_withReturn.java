package Thread_study01;
/**
 * Lambda推導，加入參數
 * @author YaoSheng
 *
 */
public class LambdaTest03_withReturn {
	public static void main(String[] args) {
		Iinterest interest = (int a, int c) ->{
			System.out.println("Hello Wrold" + (a+c));
			return a+c;
		};
		interest.lambada(0, 1);
		
		interest = (a, c) ->{
			System.out.println("Hello Wrold" + (a+c));
			return a+c;
		};
		
		interest = (a, c) ->{
			return a+c;
		};
		
		interest = (a, c) -> a+c;
		
		interest = (a, c) -> 100;
		
		System.out.println(interest.lambada(10, 20));
	}
}
	


//返回int
interface Iinterest{
	int lambada(int a, int b);
}

class Interest implements Iinterest{

	@Override
	public int lambada(int a, int c) {
		System.out.println("Hello Wrold" + (a+c));
		return a+c;
	}

	
}