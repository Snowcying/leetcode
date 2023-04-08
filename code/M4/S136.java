package code.M4;

public class S136 {
    static public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,2,3};
        System.out.println(singleNumber(nums));
    }
}
