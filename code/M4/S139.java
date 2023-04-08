package code.M4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class S139 {
    static HashSet<String> set = new HashSet<>();

    static public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        boolean[] dp1=new boolean[s.length()+1];
        dp1[0]=true;
        for(int i=1;i<=s.length();i++){
//            for(int j=0;j<i;j++){
            for(int j=i-1;j>=0;j--){
                if(!dp1[j]){
                    continue;
                }
                String sub=s.substring(j,i);
                if(dp1[j]&&wordDict.contains(sub)){
                    dp1[i]=true;
                    break;
                }
            }
        }


        return dp1[s.length()];
    }

    public static void main(String[] args) {
        String s="leetcode";
//        List<String>wordDict=new ArrayList<>(){
//            {
//                add("leet");
//                add("code");
//            }
//        };
        List<String> wordDict=new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s,wordDict));
    }
}
