package code;

class Solution53 {
    static public int maxSubArray(int[] nums) {
        int pre=nums[0];
        int max=pre;
        for(int i=1;i<nums.length;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            max=Math.max(pre,max);
        }
        return max;

    }
}

public class Hot53 {
    public static void main(String[] args) {
//        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int[] nums={5,4,-1,7,8};

        System.out.println(Solution53.maxSubArray(nums));
    }
}
