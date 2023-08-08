package code.M8;

import java.util.HashMap;
import java.util.Iterator;

public class S169 {
    static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            Iterator<Integer> iterator = map.keySet().iterator();
            Integer max = Integer.MIN_VALUE;
            Integer res = nums[0];
            while (iterator.hasNext()) {
                Integer val = iterator.next();
                if (map.get(val) > max) {
                    max = map.get(val);
                    res = val;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] nums={2,2,1,1,1,2,2};
        int[] nums = {3, 3, 4};
        System.out.println(new Solution().majorityElement(nums));
    }
}
