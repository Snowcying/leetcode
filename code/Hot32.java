package code;


import java.util.Stack;

class Solution32 {
    static public int longestValidParentheses(String s) {

//        Stack<Character> st1 = new Stack<>();
        if(s==""){return 0;}
        int[] dp=new int[s.length()>0?s.length():1];
        dp[0]=0;
        int max = 0, nums = 0;
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current=='('){
                dp[i]=0;
            }
            else{
                char pre = s.charAt(i-1);
                if(pre=='('){
                    dp[i]=2;
                    if(i-2>=0){
                        dp[i]=dp[i]+dp[i-2];
                    }
                }else if(dp[i-1]>0){
                    if((i-dp[i-1]-1)>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i]=dp[i-1]+2;
                        if((i-dp[i-1]-2)>=0){
                            dp[i]=dp[i]+dp[i-dp[i-1]-2];
                        }
                    }
                }
            }
            max=max>dp[i]?max:dp[i];
        }

        return max;
    }
}

public class Hot32 {

    public static void main(String[] args) {
        String input = "";
//        String input = "(()";
//        String input = "()(())";
        System.out.println(Solution32.longestValidParentheses(input));
    }
}
