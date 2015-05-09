package algorithm.dp;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [   [2], 
 *    [3,4], 
 *   [6,5,7], 
 *  [4,1,8,3] 
 * ]
 * 
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * @author Nacking
 * 
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[] res = new int[size];
		if (size == 0)
			return 0;
		if (size == 1)
			return triangle.get(size - 1).get(0);

		for (int i = 0; i < size; i++) {
			res[i] = triangle.get(size - 1).get(i);
		}

		for (int i = size - 2; i >= 1; i--) {
			for (int j = 0; j <= i; j++) {
				res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
			}
		}

		return Math.min(res[0], res[1]) + triangle.get(0).get(0);
	}
}
