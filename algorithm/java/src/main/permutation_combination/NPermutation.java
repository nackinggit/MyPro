package permutation_combination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * N个数的全排列, 大小为n的数字数组的全排列
 * 本质上是深度优先遍历（dfs）
 */
public class NPermutation {
    public static List<List<Integer>> nPerm(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> res = new LinkedList<>();
        doNPerm(res, nums, 0, nums.length);
        return res;
    }

    private static void doNPerm(List<List<Integer>> res, int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex - 1) {
            List<Integer> one = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(one);
        }

        for (int k = startIndex; k < endIndex; k++) {
            if(k == startIndex || nums[startIndex] != nums[k]) {
                swap(nums, startIndex, k);
                doNPerm(res, nums, startIndex + 1, endIndex);
                swap(nums, startIndex, k); //状态还原
            }
        }
    }

    private static void swap(int[] nums, int i, int k) {
        if (nums[i] != nums[k]) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3};
        System.out.println(nPerm(nums));
    }

}
