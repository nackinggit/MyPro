import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Singleton {

	// static final String s1 = System.currentTimeMillis() + "";
	// �������ɵĵ�����
	private static Singleton cache;

	private Singleton() {
		System.out.println("danlimoshi.");
	}

	// ��øõ��������ķ���
	public static Singleton getInstance() {
		// ����������Ƿ��Ѵ���
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
		Pattern p = Pattern.compile(regex);	//����һ��������ʽ
		Matcher m = p.matcher(s);
		System.out.println(s);
		return (m.matches());
	}
}