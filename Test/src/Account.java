/**
 * 账户类，钱没有取完不准存，存多少取多少 洗黑钱？？？？
 * 
 * @author Nacking 2014年5月19日11:09:35
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
				System.out.println(Thread.currentThread().getName() + "取了"
						+ drawAmount + "元");
				balance = balance - drawAmount;

				System.out.println("余额为：" + balance);

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
				System.out.println(Thread.currentThread().getName() + "存了"
						+ depositAmount + "元");
				balance = balance + depositAmount;
				System.out.println("余额为" + balance + "元");
				flag = true;

				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
