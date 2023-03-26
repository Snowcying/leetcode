package code;

class Solution62 {
    static public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    static public int uniquePaths2(int m, int n) {
        if(n>m){
            int temp=m;
            m=n;
            n=temp;
        }
        int[] dp=new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=1;
        }
        int pre;
        for(int i=0;i<m-1;i++){
            pre=1;
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+pre;
                pre=dp[j];
            }
        }
        return dp[n-1];
    }
}
public class Hot62 {
    public static void main(String[] args) {
        int m=7;
        int n=3;
        System.out.println(Solution62.uniquePaths2(m,n));
    }
}
