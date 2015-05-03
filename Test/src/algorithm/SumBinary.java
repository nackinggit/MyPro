package algorithm;

public class SumBinary {
	public static String addBinary(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != '0' && a.charAt(i) != '1') {
				throw new IllegalArgumentException();
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) != '0' && b.charAt(i) != '1') {
				throw new IllegalArgumentException();
			}
		}

		StringBuffer res = new StringBuffer();

		int flag = 0;
		int lena = a.length();
		int lenb = b.length();
		int len = Math.abs(lena - lenb);
		StringBuffer c = new StringBuffer();
		if (len != 0) {
			for (int i = 0; i < len; i++) {
				c.append('0');
			}
		}

		if (lena > lenb) {
			b = c.toString() + b;
			len = lena;
		} else if (lena < lenb) {
			a = c.toString() + a;
			len = lenb;
		} else {
			len = lena;
		}

		// System.out.println(a);
		// System.out.println(b);

		while (true) {
			if (len <= 0) {
				break;
			}

			int aint = a.charAt(len - 1) - '0';
			int bint = b.charAt(len - 1) - '0';

			if (aint + bint + flag > 1) {
				res.append((char) ('0' + aint + bint + flag - 2));
				flag = 1;
			} else {
				res.append((char) ('0' + aint + bint + flag));
				flag = 0;
			}

			len--;
		}

		if (flag == 1) {
			res.append((char) (flag + '0'));
		}

		return res.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "111";
		String b = "011";
		System.out.println(addBinary(a, b));
	}
}
