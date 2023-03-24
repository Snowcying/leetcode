package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution56 {
    static public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<intervals.length;){
            int left=i;
            int right=i;
            int rightMax=intervals[left][1];
            while(i+1!=intervals.length&&intervals[i][1]>=intervals[i+1][0]){
                rightMax=Math.max(rightMax,intervals[i+1][1]);
                i++;
            }
            List<Integer> l1=Arrays.asList(intervals[left][0],rightMax);
            ans.add(l1);
            i++;
        }
        int[][] ans1=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<2;j++){
                ans1[i][j]=ans.get(i).get(j);
            }
        }


        return ans1;
    }
}

public class Hot56 {
    public static void main(String[] args) {
//        int[][] nums={{1,2},{4,6},{2,3}};
        int[][] nums={{1,4},{2,3}};
        int[][] ans= Solution56.merge(nums);

//        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        List<List<Integer>> lists= new ArrayList<>();
        for(int[] num:ans){
            List<Integer> list=new ArrayList<>();
            for(int x:num){
                list.add(x);
            }
            lists.add(list);
        }
        System.out.println(lists);
    }
}
