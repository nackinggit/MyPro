package algorithm.dp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping: 
 * 		'A' -> 1 
 * 		'B' -> 2 
 * 		... 
 * 		'Z' -> 26
 * 
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author Nacking
 * 
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;

		if (s.length() == 1) {
			return s.charAt(0) == '0' ? 0 : 1;
		}

		if (s.charAt(0) == '0')
			return 0;

		int[] num = new int[s.length()];
		num[0] = 1;
		num[1] = 0;

		if (valid(s, 0, 1)) {
			num[1] += 1;
		}

		if (s.charAt(1) != '0') {
			num[1] += 1;
		}

		if (num[1] == 0) {
			return 0;
		}

		for (int i = 2; i < s.length(); i++) {
			if (!valid(s, i - 1, i)) {
				if (s.charAt(i) == '0') {
					return 0;
				} else {
					num[i] = num[i - 1];
				}
			} else {
				if (s.charAt(i) == '0') {
					num[i] = num[i - 2];
				} else {
					if (!valid(s, i - 2, i - 1)) {
						num[i] = num[i - 2] * 2;
					} else {
						num[i] = num[i - 2] + num[i - 1];
					}
				}
			}
		}
		return num[s.length() - 1];
	}

	public boolean valid(String s, int i, int j) {
		if (s.charAt(i) == '0' || s.charAt(i) >= '3') {
			return false;
		}

		if (s.charAt(i) == '2' && s.charAt(j) > '6') {
			return false;
		} else {
			return true;
		}
	}
}
