package Thread_study01;
/**
 * Lambda推導，加入參數
 * @author YaoSheng
 *
 */
public class LambdaTest02_withArg {
	public static void main(String[] args) {
		
		iLove love = (int a)-> {
			System.out.println("Hello World" + a);
		};
		love.lambada(0);
		
		//簡化1，將型別int省略
		love = (a)-> {
			System.out.println("Hello World" + a);
		};
		love.lambada(1);
		
		//簡化2，將括號省略
		love = a-> {
			System.out.println("Hello World" + a);
		};
		love.lambada(2);
		
		//簡化3，將大括號省略
		love = a-> System.out.println("Hello World" + a);
		love.lambada(3);
	}
}

//多個int a的參數
interface iLove{
	void lambada(int a);
}

class Love implements iLove{

	@Override
	public void lambada(int a) {
		System.out.println("Hello World" + a);
	}
	
}