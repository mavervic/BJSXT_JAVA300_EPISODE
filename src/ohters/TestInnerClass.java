package ohters;

public class TestInnerClass {
	public void testinner (A a) {
		a.run();
	}

	public static void main(String[] args) {
		TestInnerClass testInnerClass = new TestInnerClass();
		testInnerClass.testinner(new AA());
		
		//匿名內部類別
		testInnerClass.testinner(new A() {
			@Override
			public void run() {
				System.out.println("直接覆寫interface的匿名類別");
			}
		});
	}
}

//有名子的類別
class AA implements A {
	@Override
	public void run() {
		System.out.println("我是有名子的類別");
	}
}

interface A {
	public void run();
}
