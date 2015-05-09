package algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü
 * b ¡Ü c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author Nacking
 * 
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		HashSet<List<Integer>> set = new HashSet<>();
		int len = nums.length;

		int s = 0, e = len - 1;
		Arrays.sort(nums);
		
		for (int i = 1; i < len; i++) {
			s = i;
			int target = -nums[s - 1];
			e = len - 1;

			while (s < e) {
				if (nums[s] + nums[e] > target) {
					e--;
				} else if (nums[s] + nums[e] < target) {
					s++;
				} else {
					List<Integer> subR = new ArrayList<>();
					subR.add(nums[i-1]);
					subR.add(nums[s]);
					subR.add(nums[e]);
					if(!res.contains(subR)) {
						res.add(subR);
					}
					s++;
					e--;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0,0,0,0,0,0 };
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(nums));
	}
}
