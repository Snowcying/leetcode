package code;

class Solution33 {


    static public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            int lvalue=nums[left],rvalue=nums[right],mvalue=nums[mid];
            if(mvalue==target){
                return mid;
            }
            if(lvalue<=mvalue){
                // 左边有序
                if(target<=mvalue&&target>=lvalue){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {
                // 右边有序
                if(target>=mvalue&&target<=rvalue){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}

public class Hot33 {
    public static void main(String[] args) {
//        int[] input = {4,5,6,7,8,9,10,11,0,1,2};
        int[] input = {1};
//        int[] input = {4,5,6,7,0,1,2};
//        int[] input = {3,1};
//        int[] input = {6,7,0,1,2,3,4,5};
        System.out.println(Solution33.search(input,1));

    }
}
