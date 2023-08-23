package code.M8;

public class S198 {
    static class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            if (len == 1) return nums[0];
            if (len == 2) return Math.max(nums[0], nums[1]);

            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            int res = Integer.MIN_VALUE;
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println(new Solution().rob(input));
    }
}
