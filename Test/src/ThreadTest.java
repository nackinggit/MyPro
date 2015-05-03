public class ThreadTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		System.out.println("r1");
		System.out.println("r2");
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new ThreadTest());
		t.run();
		System.out.println(Thread.currentThread().getName());
		System.out.println("m1");
		t.join();
		System.out.println("m2");
	}

}
