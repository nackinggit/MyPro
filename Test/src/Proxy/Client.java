package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Date;

public class Client {
	public static void main(String[] args) {
		
		IGamePlayer player = new GamePlayer("nacking");
		InvocationHandler handler = new GamePlauIH(player);
		
		System.out.println("startTime : " + new Date(System.currentTimeMillis()));
		ClassLoader cl = player.getClass().getClassLoader();
		
		IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
		proxy.login("nacking", "123");
		proxy.killBoss();
		proxy.upgrade();
		System.out.println("EndTime: " + new Date(System.currentTimeMillis()));
	}
}
