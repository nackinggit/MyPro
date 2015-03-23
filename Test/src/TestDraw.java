
public class TestDraw {
	public static void main(String[] args) {
		Account account = new Account("1234567", 0);
		
		DrawThread dt = new DrawThread(account, 800);
		
		DepositThread dp1 = new DepositThread(account, 800);
		DepositThread dp2 = new DepositThread(account, 800);
		DepositThread dp3 = new DepositThread(account, 800);
		
		Thread draw = new Thread(dt,"ȡǮ");
		Thread deposit1 = new Thread(dp1,"��Ǯ1");
		Thread deposit2 = new Thread(dp2,"��Ǯ2");
		Thread deposit3 = new Thread(dp3,"��Ǯ3");
		
		draw.start();
		deposit1.start();
		deposit2.start();
		deposit3.start();
	}

}
