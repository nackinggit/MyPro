
public class DrawThread implements Runnable {

	private Account account;
	
	public double drawAmount;
	public DrawThread(Account account, double drawAmount) {
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0 ; i<100; i++) {
			account.draw(drawAmount);
		}
	}
}
