package code.M8;

public class S152 {
    static class Solution {
        public int maxProduct(int[] nums) {
            int[] dpMax = new int[20001];
            int[] dpMin = new int[20001];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int item = nums[i];
                int item2 = item * dpMax[i - 1];
                int item3 = item * dpMin[i - 1];
                dpMax[i] = maxIn3(item, item2, item3);
                dpMin[i] = minIn3(item, item2, item3);
                max = Math.max(dpMax[i], max);
            }
            return max;
        }

        static int maxIn3(int x, int y, int z) {
            int max = Math.max(x, y);
            return Math.max(max, z);
        }

        static int minIn3(int x, int y, int z) {
            int max = Math.min(x, y);
            return Math.min(max, z);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{-2, 0, -1}));
    }
}
