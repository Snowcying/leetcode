package code.M4;

public class S85 {
    public static int maximalRectangle(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] nums=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    if(matrix[i][j]=='1'){
                        nums[i][j]=1;
                    }else{
                        nums[i][j]=0;
                    }
                }else{
                    if(matrix[i][j]=='1'){
                        nums[i][j]=nums[i][j-1]+1;
                    }else{
                        nums[i][j]=0;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j]>0){
                    int ii=i-1;
                    int minW=nums[i][j];
                    max=Math.max(max,minW);
                    while(ii>=0&&nums[ii][j]>0){
                        minW=Math.min(minW,nums[ii][j]);
                        max=Math.max(max,minW*(i-ii+1));
                        ii--;
                    }
                }
            }
        }


        return max;
    }

    public static void main(String[] args) {
//        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        char[][] matrix={{'1'}};
        char[][] matrix={{'0','1'},{'0','1'}};
        System.out.println(maximalRectangle(matrix));
    }
}
