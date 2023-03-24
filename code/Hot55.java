package code;

import java.util.LinkedList;
import java.util.Queue;

class Solution55 {
    static public boolean canJump(int[] nums) {
        Queue<Integer> q = new LinkedList<Integer>();
        int len = nums.length;
        int end = len - 1;
        boolean[] used = new boolean[len];
        q.add(0);
        used[0] = true;
        while (!q.isEmpty()) {
            int index = q.remove();
            int step = nums[index];
            for (int i = 1; i <= step; i++) {
                int j = Math.min(index + i, end);
                if (j == end) {
                    return true;
                }
                if (!used[j]) {
                    q.add(j);
                    used[j] = true;
                }
            }
        }
        return used[end];

    }

    static public boolean canJump2(int[] nums) {

        int max = nums[0];
        int end = nums.length - 1;
        for (int i = 0; i <= max; i++) {
            if (max >= end) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}

public class Hot55 {
    public static void main(String[] args) {
//        int[] nums={2,3,1,1,4};
//        int[] nums={3,2,1,0,4};
        int[] nums = {3};
        System.out.println(Solution55.canJump2(nums));

    }
}
