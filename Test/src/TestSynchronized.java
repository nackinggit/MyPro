public class TestSynchronized {
	private int i = 0;

	public synchronized void hehe() {
		++i;
		System.out.println(i);
	}

	public static void main(String[] args) {
		TestSynchronized ts = new TestSynchronized();
		ts.hehe();
		TestSynchronized ts2 = new TestSynchronized();
		ts2.hehe();
	}
}
