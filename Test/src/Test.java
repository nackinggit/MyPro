import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Singleton {

	// static final String s1 = System.currentTimeMillis() + "";
	// 缓存生成的单例类
	private static Singleton cache;

	private Singleton() {
		System.out.println("danlimoshi.");
	}

	// 获得该单例类对象的方法
	public static Singleton getInstance() {
		// 单例类对象是否已创建
		if (cache == null) {
			cache = new Singleton();
		}
		return cache;
	}
	
}

public class Test {
	public static void main(String[] args) {
		Singleton s = null;
		s = Singleton.getInstance();
		Singleton s2 = null;
		s2 = Singleton.getInstance();
		System.out.println(s == s2);

		HashSet<Character> ss = new HashSet<>();
		char c = 'a';
		char d = 'a';

		ss.add(c);
		ss.add(d);

		System.out.println(ss.size());
		
		
		
		String css = "  127.0.0.1  ";
		System.out.println(isIp(css));
	}
	
	public static boolean isIp(String s) {
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		
		s = s.trim();
		Pattern p = Pattern.compile(regex);	//编译一个正则表达式
		Matcher m = p.matcher(s);
		System.out.println(s);
		return (m.matches());
	}
}