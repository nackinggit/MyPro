public class DepositThread implements Runnable {

	private Account account;
	private double depositAmount;

	// private String accountName;

	public DepositThread(Account account, double depositAmount) {
		this.account = account;
		this.depositAmount = depositAmount;
		;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}

}
