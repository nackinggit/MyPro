package algorithm.arrays;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ¡Ý s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * @author Nacking
 * 
 */
public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        
        int len = nums.length;
        int si = 0, ei = 1;
        int minLen = 0;
        while(si < len && ei < len) {
        	if(nums[si] >= s || nums[ei] >= s) {
        		return 1;
        	}
        	int sum = 0;
        	for(int i=si; i<=ei; i++) {
        		sum += nums[i];
        	}
        	
        	if(sum >= s) {
        		if(minLen == 0) {
        			minLen = ei - si + 1;
        		}
        		else if(minLen > ei - si + 1) {
        			minLen = ei - si + 1;
        		} 
        		si++;
        	} else {
        		ei++;
        	}
        }
        
        return minLen;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}
}
