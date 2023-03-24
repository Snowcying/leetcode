package code;

class Solution70 {
    static public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int ans1=1;
        int ans2=2;
        int temp;
        n=n-2;
        while(n>0){
            temp=ans2;
            ans2=ans1+ans2;
            ans1=temp;
            n--;
        }

        return ans2;
    }
}
public class Hot70 {
    public static void main(String[] args) {
        int n=6;
        System.out.println(Solution70.climbStairs(n));
    }
}

//  1 2 3 4
