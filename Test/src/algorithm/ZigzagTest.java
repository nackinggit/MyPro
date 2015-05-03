package algorithm;

public class ZigzagTest {
	public static String convert(String s, int nRows) {
		StringBuffer res = new StringBuffer();
		if (s == null || s.length() <= nRows || nRows <= 1) {
			return s;
		}

		for (int i = 0; i < s.length(); i += (nRows - 1) * 2) {
			res.append(s.charAt(i));
		}

		for (int i = 1; i < nRows - 1; i++) {
			for (int j = i; j < s.length(); j += (nRows - 1) * 2) {
				res.append(s.charAt(j));
				if (j + (nRows - i - 1) * 2 < s.length()) {
					res.append(s.charAt(j + (nRows - i - 1) * 2));
				}
			}
		}

		for (int i = nRows - 1; i < s.length(); i += (nRows - 1) * 2) {
			res.append(s.charAt(i));
		}

		return res.toString();
	}

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";

		System.out.println(convert(s, 3));
	}
}
