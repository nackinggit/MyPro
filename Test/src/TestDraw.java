public class TestDraw {
	public static void main(String[] args) {
		Account account = new Account("1234567", 0);

		DrawThread dt = new DrawThread(account, 800);

		DepositThread dp1 = new DepositThread(account, 800);
		DepositThread dp2 = new DepositThread(account, 800);
		DepositThread dp3 = new DepositThread(account, 800);

		Thread draw = new Thread(dt, "取钱");
		Thread deposit1 = new Thread(dp1, "存钱1");
		Thread deposit2 = new Thread(dp2, "存钱2");
		Thread deposit3 = new Thread(dp3, "存钱3");

		draw.start();
		deposit1.start();
		deposit2.start();
		deposit3.start();
	}

}
