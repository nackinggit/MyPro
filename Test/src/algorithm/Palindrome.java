package algorithm;

public class Palindrome {
	public static boolean isPalindrome(int x) {
		int xx = x;
		long reverseX = 0;

		if (x < 0)
			return false;

		while (x > 0) {
			reverseX = reverseX * 10 + x % 10;
			x = x / 10;
		}

		if (reverseX > Integer.MAX_VALUE)
			return false;

		return reverseX == xx;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(Integer.MAX_VALUE));
	}
}
