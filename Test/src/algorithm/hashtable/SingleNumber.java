package algorithm.hashtable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author Nacking
 * 
 */
public class SingleNumber {
	//方法一：利用hashset
	public int singleNumber(int[] nums) {
		int len = nums.length;
		Set<Integer> list = new HashSet<>();

		for (int i = 0; i < len; i++) {
			if (!list.contains(nums[i])) {
				list.add(nums[i]);
			} else {
				list.remove(nums[i]);
			}
		}

		Iterator<Integer> iterator = list.iterator();

		return iterator.next();
	}

	//方法二：异或运算！
	public int singleNumber2(int[] nums) {
        int len = nums.length;
        int m = 0;
        for(int i=0; i<len; i++) {
            m = m^nums[i];
        }
        
        return m;
    }
	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();
		int[] nums = { 1, 2, 2, 3, 3, 5 };

		System.out.println(s.singleNumber(nums));
	}
}
