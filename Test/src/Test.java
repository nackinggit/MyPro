import java.util.HashSet;

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
	}
}