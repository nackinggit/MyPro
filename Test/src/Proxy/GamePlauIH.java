package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlauIH implements InvocationHandler {

	Object obj = null;
	
	public GamePlauIH(Object _obj) {
		// TODO Auto-generated constructor stub
		this.obj = _obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object res = method.invoke(this.obj, args);
		if(method.getName().equalsIgnoreCase("login")) {
			System.out.println(" 有人在用我的账号登陆");
		}
		return res;
	}

}
