package code;

class Solution24 {



// 2, 6, 3, 5, 4, 1
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0&&nums[i]>nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(j>=0&&nums[j]<=nums[i]){
                j--;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        int left = i+1,right=nums.length-1;
        while(left<right){
//            int ll=left+1;
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
public class Hot31 {

    public static void main(String[] args) {
        Solution24 s24 = new Solution24();
        int[] nums={4,3,2,1};
        s24.nextPermutation(nums);
    }

}
