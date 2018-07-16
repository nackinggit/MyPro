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
    /**
     * 递归方法
     *
     * @param nums
     * @return
     */
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
        } else {
            for (int k = startIndex; k < endIndex; k++) {
                if (isSwap(nums, startIndex, k)) {
                    swap(nums, startIndex, k);
                    doNPerm(res, nums, startIndex + 1, endIndex);
                    swap(nums, startIndex, k); //状态还原
                }
            }
        }
    }

    /**
     * 非递归
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> nPermWithoutRecrutive(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> res = new LinkedList<>();

        int[] last = reverse(nums, 0, nums.length - 1);

        int[] cur = Arrays.copyOfRange(nums, 0, nums.length);

        res.add(Arrays.stream(cur).boxed().collect(Collectors.toList()));

        while (!Arrays.equals(cur = nextPerm(cur), last) && cur != null) {
            res.add(Arrays.stream(cur).boxed().collect(Collectors.toList()));
        }

        res.add(Arrays.stream(last).boxed().collect(Collectors.toList()));

        return res;
    }

    private static int[] nextPerm(int[] cur) {
        int[] next = Arrays.copyOfRange(cur, 0, cur.length);
        int smallerIndex, largerIndex, m;
        //从右往左找到第一个比前一个小的数的下标
        for (smallerIndex = cur.length - 2; smallerIndex >= 0; smallerIndex--) {
            if (cur[smallerIndex + 1] > cur[smallerIndex]) {
                break;
            }
        }

        if (smallerIndex < 0) return null;

        m = smallerIndex;
        smallerIndex++;

        //从右往左找到第一个比a[smallerIndex]大的数的下标
        for (largerIndex = cur.length - 1; largerIndex > smallerIndex; largerIndex--) {
            if (cur[m] < cur[largerIndex]) {
                break;
            }
        }

        //交换两个index的元素
        swap(next, m, largerIndex);

        //reverse一下
        next = reverse(next, m + 1, cur.length - 1);
        return next;

    }

    private static int[] reverse(int[] nums, int s, int e) {
        int[] newNums = Arrays.copyOfRange(nums, 0, nums.length);
        while (s < e) {
            int tmp = newNums[s];
            newNums[s] = newNums[e];
            newNums[e] = tmp;
            s++;
            e--;
        }
        return newNums;
    }

    //能不能交换，就是说交换数字中间不能出现与后面交换的重复数字
    //如：122那个1只能和第一个2交换却不能和第二个2交换
    private static boolean isSwap(int[] num, int i, int j) {
        for (int index = i; index < j; index++) {
            if (num[index] == num[j])
                return false;
        }
        return true;
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
        System.out.println(nPermWithoutRecrutive(nums));
    }

}
