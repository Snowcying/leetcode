package code;

public class Hot75 {
    class Solution {

        public static void sortColors(int[] nums) {
            int n0=0,n1=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    if(nums[n0]==1){
                        int temp=nums[i];
                        nums[i]=nums[n0+n1];
                        nums[n0+n1]=nums[n0];
                        nums[n0]=temp;
                    }else if(nums[n0]==2){
                        // swap(nums,i,n0);
                        int temp=nums[i];
                        nums[i]=nums[n0];
                        nums[n0]=temp;
                    }
                    n0++;
                }else if(nums[i]==1){

                    if(nums[n0+n1]==2){
                        // swap(nums,n0+n1,i);
                        int temp=nums[n0+n1];
                        nums[n0+n1]=nums[i];
                        nums[i]=temp;
                    }
                    n1++;
                }
            }

        }
    }

    public static void main(String[] args) {

    }
}
