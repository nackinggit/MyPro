package algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author Nacking
 * 
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		if (S == null || S.length == 0)
			return null;
		Arrays.sort(S);
		return _subsets(S, 0);

	}

	private List<List<Integer>> _subsets(int[] s, int startIndex) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (startIndex == s.length) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		List<List<Integer>> sub = _subsets(s, startIndex + 1);

		for (List<Integer> sList : sub) {
			res.add(sList);
			List<Integer> copy = new ArrayList<>();
			copy.add(s[startIndex]);
			copy.addAll(sList);
			res.add(copy);
		}
		return res;
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] S = new int[] { 1, 2, 3 };

		System.out.println(s.subsets(S));
	}
}
