package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution56 {
    static public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int[][] ans2 =new int[intervals.length][2];
        int len=0;
        for(int i=0;i<intervals.length;){
            int left=i;
            int rightMax=intervals[left][1];
            int leftMin=intervals[left][0];
            while(i!=intervals.length-1&&!(intervals[i+1][0]>rightMax)){
                rightMax=Math.max(rightMax,intervals[i+1][1]);
                i++;
            }
            ans2[len++]=new int[]{leftMin,rightMax};
            i++;
        }
        int[][] ans1=new int[len][2];
        for(int i=0;i<len;i++){
            for(int j=0;j<2;j++){
                ans1[i][j]=ans2[i][j];
            }
        }
        return ans1;
    }
}

public class Hot56 {
    public static void main(String[] args) {
//        int[][] nums={{1,2},{4,6},{2,3}};
//        int[][] nums={{1,4},{2,3}};
        int[][] nums={{2,3},{4,5},{6,7},{8,9},{1,10}};
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
