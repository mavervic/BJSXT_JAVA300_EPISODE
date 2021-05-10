package Thread_study01;

/**
 * Lambda推導
 * 
 * @author YaoSheng
 *
 */
public class LambdaTest01 {
	static class Like2 implements iLike {

		@Override
		public void lambada() {
			System.out.println("Hello World2");
		}
	}

	public static void main(String[] args) {
		iLike like = new Like();
		like.lambada();
		like = new Like2();
		like.lambada();
		
		
		class Like3 implements iLike{
			@Override
			public void lambada() {
				System.out.println("Hello World3");
			}			
		}		
		like = new Like3();
		like.lambada();
		
		//匿名內部類
		like = new iLike() {
			public void lambada() {
				System.out.println("Hello World4");
			}
		};
		like.lambada();
	
		//lambda
		like = ()->{
			System.out.println("Hello World5");
		};
		like.lambada();
	}
}

interface iLike {
	void lambada();
}

class Like implements iLike {
	
	public void xy() {
		System.out.println(123);
	}

	@Override
	public void lambada() {
		System.out.println("Hello World");
	}

	

}
