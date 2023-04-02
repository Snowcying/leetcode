package code.M4;

import java.util.ArrayList;
import java.util.List;

public class S78 {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void dfs(int[] nums, int k, List<Integer> res) {
        List<Integer> t = new ArrayList<>(res);
        if (k == nums.length) {
            ans.add(t);
        } else {
            dfs(nums, k + 1, t);
            t.add(nums[k]);
            dfs(nums, k + 1, t);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, res);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));

    }
}
