package code;

class Solution34 {
    static public int findOne(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            int mvalue=nums[mid];
            if(mvalue==target){
                return mid;
            }
            if(target<mvalue){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
    static public int findFirstRight(int[] nums,int target,int left,int right){
        int originLeft=left;
        int res=-1;
        if(nums[right]==target){
            return right;
        }
        while(left<=right){
            int mid=(left+right)>>1;
            int mValue=nums[mid];
            if(mValue>target){
                right=mid-1;
            }else if(mValue<target){
                left=mid+1;
            }else {
                res=mid;
                left=mid+1;
            }
        }
        return res;
    }
    static public int findFirst(int[] nums,int target,int left,int right,boolean flag){
        int res=-1;
        while(left<=right){
            int mid=(left+right)>>1;
            int mValue=nums[mid];

            if(mValue>target){
                right=mid-1;
            }else if(mValue<target){
                left=mid+1;
            }else {
                if(flag){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                res=mid;
            }
        }
        return res;
    }
    static public int findFirstLeft(int[] nums,int target,int left,int right){
//        int originRight=left;
        int res=-1;
        if(nums[left]==target){
            return left;
        }
        while(left<=right){
            int mid=(left+right)>>1;
            int mValue=nums[mid];
//            if(mValue<target&&nums[mid+1]==target){
//                return mid;
//            }
            if(mValue<target){
                left=mid+1;
            }else if(mValue>target){
                right=mid-1;
            }else {
                res=mid;
                right=mid-1;
            }
        }
        return res;
    }
    static public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int l=findFirst(nums,target,0,nums.length-1,true);
        int r=findFirst(nums,target,0,nums.length-1,false);
        System.out.println(l);
        System.out.println(r);
        return new int[]{l,r};
    }
}
public class Hot34 {
    public static void main(String[] args) {
//        int[] input={10};
        int[] input={0,0,1,2,2,2,2,2,3,3,3,3};
        int target=3;
        System.out.println(Solution34.searchRange(input,target));
    }
}
