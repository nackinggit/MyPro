/**
 * Thread difference of sleep and wait
 * 
 * @author Nacking 2014-5-8 11:22:33
 */
public class TestWaitSleep implements Runnable {

	int number = 10;

	public void firstMethod() {
		synchronized (this) {
			number += 1;
			System.out.println(number);
		}
	}

	public void secondMethod() throws Exception {
		synchronized (this) {
			/**
			 * sleep or wait 2s ����֤��ǰ�̶߳���Ļ�����ռ��ʱ, �Ƿ񱻿��Է�������ͬ�������
			 */

			// Thread.sleep(2000);
			this.wait(2000);

			number *= 2;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			firstMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		TestWaitSleep tws = new TestWaitSleep();
		Thread thread = new Thread(tws);
		thread.start();
		tws.secondMethod();
	}
}
