package algorithm;

public class Strstr {
	public static int strStr(String haystack, String needle) {

		/*
		 * if(needle.length() > haystack.length()) { return -1; }
		 */

		if (haystack.equals(needle))
			return 1;

		for (int i = 0; i < haystack.length(); i++) {

			if (haystack.length() - i < needle.length())
				return -1;

			String str = haystack.substring(i, i + needle.length());
			if (str.equals(needle)) {
				return i + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		String haystack = "";
		String needle = "";
		System.out.println(strStr(haystack, needle));
	}
}
