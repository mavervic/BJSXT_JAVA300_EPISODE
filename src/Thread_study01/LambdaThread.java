package Thread_study01;

public class LambdaThread {
	// 靜態內部類
	static class Test implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("唱歌1");
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new Test()).start();

		// 局部內部
		class Test2 implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("唱歌2");
				}
			}
		}
		new Thread(new Test2()).start();

		// 匿名內部類
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("唱歌3");
				}
			}
		}).start();

		// jdk8 簡化lambda(介面裡面只能有一個方法)
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("唱歌4");
			}
		}).start();
	}
}