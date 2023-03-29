package code;

public class S69_sqrtX {
    public static int mySqrt(int x) {
        int l=0,r=x;
        int ans=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(m*m<x){
                ans=m;
                l=m+1;
            }else if(m*m>x){
                r=m-1;
            }else {
                return m;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
}
