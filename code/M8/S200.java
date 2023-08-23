package code.M8;

public class S200 {
    static class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] reached = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1' && reached[i][j] == 0) {
                        res++;
                        search(grid, reached, i, j);
                    }
                }
            }
            return res;
        }

        void search(char[][] grid, int[][] reached, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if (i >= m || j >= n || i < 0 || j < 0) return;
            if (reached[i][j] == 1) return;
            reached[i][j] = 1;
            if (grid[i][j] != '0') {
                search(grid, reached, i + 1, j);
                search(grid, reached, i - 1, j);
                search(grid, reached, i, j + 1);
                search(grid, reached, i, j - 1);
            }

        }
    }

    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(input));
    }
}
