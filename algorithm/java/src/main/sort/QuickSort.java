package sort;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] nums) {
        if (nums != null) {
            doQuickSort(nums, 0, nums.length - 1);
        }
    }

    private static void doQuickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mIndex = split(nums, start, end);
            doQuickSort(nums, start, mIndex - 1);
            doQuickSort(nums, mIndex + 1, end);
        }
    }

    private static int split(int[] nums, int start, int end) {
        int aim = nums[start];
        while (start < end) {
            while (nums[end] > aim && start < end) {
                end--;
            }
            nums[start] = nums[end];
            while (nums[start] < aim && start < end) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = aim;
        System.out.println(Arrays.toString(nums));
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4, 0,-1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
