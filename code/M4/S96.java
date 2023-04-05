package code.M4;

public class S96 {
    static public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int x = j, y = i - x - 1;
                dp[i] += dp[x] * dp[y];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(numTrees(1));
    }
}
