package algorithm;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int count = 0;

		if (s == null)
			return 0;

		String m = (new StringBuffer(s)).reverse().toString().trim();
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) != ' ') {
				count++;
				continue;
			}
			break;
		}
		return count;
		/*
		 * String[] parts = s.split(" "); if (parts.length == 0) return 0;
		 * return parts[parts.length - 1].length();
		 */
	}

	public static void main(String[] args) {
		LengthOfLastWord l = new LengthOfLastWord();
		String s = "a haha word ";
		System.out.println(l.lengthOfLastWord(s));
	}
}
