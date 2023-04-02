package code.M4;

public class S79 {
//    static boolean[][] used=new boolean[6][6];
    static boolean flag=false;
    static void dfs(char[][] board,String word,int k,int i,int j,boolean[][] used){
        int m=board.length,n=board[0].length;
        if(k==word.length()){
            flag=true;
            return;
        }
        if(i+1<m&&!used[i+1][j]&&board[i+1][j]==word.charAt(k)){
            used[i+1][j]=true;
            dfs(board,word,k+1,i+1,j,used);
            used[i+1][j]=false;
        }
        if(i-1>=0&&!used[i-1][j]&&board[i-1][j]==word.charAt(k)){
            used[i-1][j]=true;
            dfs(board,word,k+1,i-1,j,used);
            used[i-1][j]=false;
        }
        if(j+1<n&&!used[i][j+1]&&board[i][j+1]==word.charAt(k)){
            used[i][j+1]=true;
            dfs(board,word,k+1,i,j+1,used);
            used[i][j+1]=false;
        }
        if(j-1>=0&&!used[i][j-1]&&board[i][j-1]==word.charAt(k)){
            used[i][j-1]=true;
            dfs(board,word,k+1,i,j-1,used);
            used[i][j-1]=false;
        }

    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] used=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    used[i][j]=true;
                    dfs(board,word,1,i,j,used);
                    used[i][j]=false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word="ABCCED";
//        String word="SEE";
        char[][] board={{'a','b'}};
        String word="ab";
        System.out.println(exist(board,word));
    }
}
