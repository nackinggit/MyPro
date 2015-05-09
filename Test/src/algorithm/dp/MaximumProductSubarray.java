package algorithm.dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author Nacking
 * 
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		int pos = 0;
		int neg = 0;
		int res = A[0];

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				pos = (pos * A[i] > A[i]) ? pos * A[i] : A[i];
				neg = neg * A[i];
				if (pos > res)
					res = pos;
			} else if (A[i] < 0) {
				int buff = neg;
				neg = (pos * A[i] > A[i]) ? A[i] : pos * A[i];
				pos = buff * A[i];
				if (pos != 0 && pos > res)
					res = pos;
			} else if (A[i] == 0) {
				pos = 0;
				neg = 0;
				if (res < 0)
					res = 0;
			}
		}

		return res;
	}

}
