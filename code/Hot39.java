package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution39 {


    static public void dp(List<List<Integer>>ans,int target,List<Integer> temp,int[] candidates,int current){
        if (target==0) {
            List<Integer> list1=new ArrayList<>(temp);
            ans.add(list1);
        }else {
            for (int i = 0; i < candidates.length; i++) {
                if(candidates[i]>=current&&target-candidates[i]>=0){
                    temp.add(candidates[i]);
                    dp(ans,target-candidates[i],temp,candidates,candidates[i]);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dp(ans,target,temp,candidates,0);
        return ans;
    }
}
public class Hot39 {
    public static void main(String[] args) {

//        int[] candidates = {2};
        int[] candidates = {2,3,6,7};
//        int target=1;
        int target=7;
        List<List<Integer>> ans=Solution39.combinationSum(candidates,target);

//        Set<Set<Integer>> sets=new HashSet<>();
//       for(List<Integer> i:ans){
//           Set<Integer> set=new HashSet<>(i);
//           sets.add(set);
//       }
//        System.out.println(sets);

        System.out.println(ans);
    }
}
