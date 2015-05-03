/**
 * �˻��࣬Ǯû��ȡ�겻׼�棬�����ȡ���� ϴ��Ǯ��������
 * 
 * @author Nacking 2014��5��19��11:09:35
 * 
 */
public class Account {
	private String accountNo;
	private double balance;

	boolean flag = false;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}

	public synchronized void draw(double drawAmount) {
		try {
			if (!flag) {
				wait();
			}

			else {
				System.out.println(Thread.currentThread().getName() + "ȡ��"
						+ drawAmount + "Ԫ");
				balance = balance - drawAmount;

				System.out.println("���Ϊ��" + balance);

				flag = false;

				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public synchronized void deposit(double depositAmount) {
		try {
			if (flag) {
				wait();
			}

			else {
				System.out.println(Thread.currentThread().getName() + "����"
						+ depositAmount + "Ԫ");
				balance = balance + depositAmount;
				System.out.println("���Ϊ" + balance + "Ԫ");
				flag = true;

				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
