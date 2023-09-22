package code.M9;

public class S221 {

    int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

//        for(int i=0;i<matrix.length;i++){
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.println(matrix[i][j]);
//            }
//            System.out.println("-----");
//        }
        System.out.println(new S221().maximalSquare(matrix));
    }
}
