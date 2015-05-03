package algorithm;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			int j = Integer.parseInt(String.valueOf(digits[i]));
			j += 1;
			if (j <= 9) {
				digits[i] = j;
				return digits;
			} else {
				digits[i] = 0;
			}
		}

		if (digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			res[1] = 0;
			for (int i = 2; i < res.length; i++) {
				res[i] = digits[i - 1];
			}
			return res;
		}

		return digits;
	}

	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] digits = { 9, 9, 9, 9, 9, 9, 9 };
		int[] res = p.plusOne(digits);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
