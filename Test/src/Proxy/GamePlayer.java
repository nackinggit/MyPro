package Proxy;

public class GamePlayer implements IGamePlayer {

	private String name;
	
	public GamePlayer(String name) {
		this.name = name;		
	}
	
	@Override
	public void login(String user, String password) {

		System.out.println("User:" + this.name + ", Login in!");
	}

	@Override
	public void killBoss() {
		System.out.println(this.name + " is fighting against boss!");	
	}

	@Override
	public void upgrade() {
		System.out.println("Now you are upgrade!");
	}
}
