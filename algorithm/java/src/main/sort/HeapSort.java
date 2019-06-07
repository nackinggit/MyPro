package sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] nums) {
        if (nums != null) {
            doSort(nums, 0, nums.length - 1);
        }
    }

    private static void doSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            doSort(nums, start, mid);
            doSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int s = start, s1 = mid + 1, index = 0;
        while (s <= mid && s1 <= end) {
            if (nums[s] <= nums[s1]) {
                temp[index++] = nums[s++];
            } else {
                temp[index++] = nums[s1++];
            }
        }

        while (s <= mid) {
            temp[index++] = nums[s];
            s += 1;
        }

        while (s1 <= end) {
            temp[index++] = nums[s1];
            s1 += 1;
        }

        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = temp[index++];
        }
        System.out.println(Arrays.toString(temp));
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4, 0};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
