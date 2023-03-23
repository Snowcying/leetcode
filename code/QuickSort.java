package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    static int partSort(int[] nums, int l, int r) {
        int preL = l;
        int x = nums[l];
        while (l < r) {
            while (nums[r] >= x && l < r) {
                r--;
            }
            while (nums[l] <= x && l < r) {
                l++;
            }
            swap(nums, r, l);
        }
        swap(nums, l, preL);
        return l;

    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void qsort(int[] nums, int l, int r) {

        if (l >= r) {
            return;
        }
        int key = partSort(nums, l, r);
        qsort(nums, l, key - 1);
        qsort(nums, key + 1, r);

    }

    static void maopaoSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    static List<Integer> sort(int[] nums) {
        qsort(nums,0,nums.length-1);
//        maopaoSort(nums);
        List<Integer> ans = new ArrayList<>();
//        ans= Arrays.asList(nums);
        for (int x : nums) {
//            System.out.println(x);
            ans.add(x);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={2,1,5,8,6,5};
//        int[] nums = {3, 18, 6, 13, 5, 16, 10, 19, 1, 15};
        System.out.println(sort(nums));
    }
}
