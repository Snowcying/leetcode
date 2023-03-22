package code;

import java.util.ArrayList;
import java.util.List;

class Solution46 {

    static public void dfs(List<List<Integer>> ans,List<Integer> temp,int len,int[] nums,boolean[] used){
        if(len==nums.length){
            List<Integer> l1=new ArrayList<>(temp);
            ans.add(l1);
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                temp.add(nums[i]);
                dfs(ans,temp,len+1,nums,used);
                temp.remove(len);
                used[i]=false;
            }
        }
    }
    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        dfs(ans,temp,0,nums,used);
        return ans;
    }
}
public class Hot46 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> ans=Solution46.permute(nums);
        System.out.println(ans);
    }
}
