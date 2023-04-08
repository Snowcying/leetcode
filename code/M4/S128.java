package code.M4;

import java.util.HashSet;
import java.util.Map;

public class S128 {
    static public int longestConsecutive(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for(int num:nums){
            hSet.add(num);
        }
        int max=0;
        for(int num:hSet){
            if(!hSet.contains(num-1)){
                int currentNum=num;
                int maxL=1;
                while(hSet.contains(currentNum+1)){
                    currentNum++;
                    maxL++;
                }
                max= Math.max(max,maxL);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(longestConsecutive(nums));
    }
}
