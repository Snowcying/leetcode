package code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution22 {

    void dfs(List<String> ans, Integer left,Integer right, String s1) {
        if (left == 0&&right == 0) {
            ans.add(s1.toString());
        } else {
            if(left>right){
                return;
            }
            if(left>0){
                dfs(ans,left-1,right,s1+"(");
//                s1.delete()
            }
            if(right>0){
                dfs(ans,left,right-1,s1+")");
            }

        }

    }

    public List<String> generateParenthesis(int n) {
        long l = System.currentTimeMillis();
        List<String> ans = new ArrayList<>();
        String s1="";
        dfs(ans,n,n,s1);
        long l2 = System.currentTimeMillis();
        long ll = l2-l;
        System.out.println(ll);
        return ans;
    }

    public List<String> generateParenthesis2(int n) {
        long l = System.currentTimeMillis();

        List<List<String>> ans =new ArrayList<>();
        if(n==0){
            return List.of();
        }
        ans.add(List.of(""));
        ans.add(List.of("()"));
        for (int i = 2; i < n+1; i++) {
            List<String> temp=new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int k=i-1-j;
                List<String> list1= ans.get(j);
                List<String> list2= ans.get(k);

                for(int nn=0;nn<list1.size();nn++){
                    for(int mm=0;mm<list2.size();mm++){
                        String x= list1.get(nn);
                        String y= list2.get(mm);
                        String ansL="("+x+")"+y;
                        temp.add(ansL);
                    }
                }

            }
            ans.add(temp);
        }

        long l2 = System.currentTimeMillis();
        long ll = l2-l;
        System.out.println(ll);


        return ans.get(n);
    }
}

public class Hot22 {
    public static void main(String[] args) {
        Solution22 s22=new Solution22();
        List<String> ans =  s22.generateParenthesis(5);

    }
}
