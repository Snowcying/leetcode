package code;

public class Hot64 {
    static public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        int pre=dp[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0]=pre+grid[i][0];
            pre=dp[i][0];
        }
        pre=dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i]=pre+grid[0][i];
            pre=dp[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        for(int[] x:dp){
            for(int y:x){
                System.out.println(y);
            }
        }
        return dp[m-1][n-1];
    }

    static public int minPathSum2(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[n];
        dp[0]=grid[0][0];
        int[] pre=new int[m];
        pre[0]=dp[0];
        for(int i=1;i<m;i++){
            pre[i]=pre[i-1]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+grid[0][i];
        }
        int preV;
        for(int i=1;i<m;i++){
            preV=pre[i];
            for(int j=1;j<n;j++){
                dp[j]=Math.min(preV,dp[j])+grid[i][j];
                preV=dp[j];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum2(grid));

    }
}
