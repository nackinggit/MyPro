package algorithm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求最大子段和
 * 
 * @author Nacking
 * 
 */
public class Zuidaziduanhe {
	/**
	 * 最笨的方法,穷举
	 * 
	 * @param num
	 * @return
	 */
	public static Map<Integer, List<Integer>> maxSum(int[] num) {

		if (num == null) {
			return null;
		}

		int len = num.length;
		int bestS = 0;
		int bestE = 0;
		int sum = 0;

		if (len == 0) {
			return null;
		}

		for (int i = 0; i < len; i++) {
			int isum = 0;
			for (int j = i; j < len; j++) {
				isum += num[j];
				if (isum > sum) {
					bestS = i;
					bestE = j;
					sum = isum;
				}
			}
		}

		List<Integer> l = new ArrayList<>();
		l.add(bestS);
		l.add(bestE);

		Map<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
		res.put(sum, l);

		return res;
	}

	/**
	 * O(nlogn)方法， 归并
	 * 
	 * @param num
	 * @return
	 */
	public static int maxSum2(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}

		int len = num.length;

		return _maxSum2(num, 0, len - 1);

	}

	private static int _maxSum2(int[] num, int s, int e) {
		int k, sum = 0;
		if (s == e) {
			return num[s] >= 0 ? num[s] : 0;
		} else {
			int mid = (s + e) / 2;
			int lsum = _maxSum2(num, s, mid);
			int rsum = _maxSum2(num, mid + 1, e);

			int s1 = 0;
			int lefts = 0;

			for (k = mid; k >= s; k--) {
				lefts += num[k];
				if (lefts > s1) {
					s1 = lefts;
				}
			}

			int s2 = 0;
			int rights = 0;
			for (k = mid + 1; k <= e; k++) {
				rights += num[k];
				if (rights > s2) {
					s2 = rights;
				}
			}

			sum = s1 + s2;

			if (sum < lsum) {
				sum = lsum;
			}

			if (sum < rsum) {
				sum = rsum;
			}
		}

		return sum;
	}

	/**
	 * O(n)方法 DP算法:先求包含num[i]在内的最大子段和，用Si表示，则S = max（Si）。 而Si = MAX{S(i-1)+
	 * num[i], num[i]}
	 * 
	 * @param num
	 * @return
	 */
	public static int maxSum3(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int len = num.length;
		int sum = 0, b = 0;
		int bestS = 0, bestE = 0;
		for (int i = 0; i < len; i++) {
			if (b > 0) {
				b += num[i];
			} else {
				b = num[i];
				bestS = i;
			}

			if (b > sum) {
				sum = b;
				bestE = i;
			}
		}
		System.out.println(bestS + "," + bestE);
		return sum;
	}

	public static void main(String[] args) {
		int[] num = { -2, 11, -9, -4, 13, -5, 10, -2 };
		System.out.println(maxSum3(num));
	}
}
