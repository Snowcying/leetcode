package code;

public class Hot72 {
    static class Solution {

        public static int minDistance(String word1, String word2) {
            int[][] dp=new int[word1.length()+1][word2.length()+1];
            int len1=word1.length(),len2=word2.length();
            for (int i = 0; i <= len1; i++) {
                dp[i][0]=i;
            }
            for (int i = 0; i <= len2; i++) {
                dp[0][i]=i;
            }
            for(int i=1;i<=len1;i++){
                for(int j=1;j<=len2;j++){
                    char c1=word1.charAt(i-1);
                    char c2=word2.charAt(j-1);
                    dp[i][j]= c1==c2?(dp[i-1][j-1]):(Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1);
                }
            }
            return dp[len1][len2];
        }

        public static int minDistance2(String word1, String word2) {
            if(word1.length()>word2.length()){
                String temp=word1;
                word1=word2;
                word2=temp;
            }
            int[] dp=new int[word1.length()+1];
            int len1=word1.length(),len2=word2.length();
            for (int i = 0; i <= len1; i++) {
                dp[i]=i;
            }
            for(int i=1;i<=len2;i++){
                dp[0]=i;
                int pre=i;
                int prePre=i-1;
                for(int j=1;j<=len1;j++){
                    char c1=word1.charAt(j-1);
                    char c2=word2.charAt(i-1);
                    int temp=dp[j];
                    if(c1==c2){
                        dp[j]=prePre;
                    }else{
                        dp[j]=Math.min(Math.min(pre,dp[j]),prePre)+1;
                    }
                    prePre=temp;
                    pre=dp[j];
                }
            }
            return dp[len1];
        }
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
//        String s1 = "intention";
//        String s2 = "execution";

        System.out.println(Solution.minDistance2(s1, s2));

    }
}
