package code.nowcoder;

import java.math.BigInteger;
import java.util.*;

public class Huawei {


    static Boolean judgeNum(String num){
        if(num.length()==1) return true;
        char x=num.charAt(0);
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)!=x) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        System.out.println(Integer.MAX_VALUE);
      while(s.hasNext()){
          String M=s.next();
          BigInteger N = s.nextBigInteger();
          String k=s.next();
          Set<String> s1=new HashSet<>();
//          System.out.println(M+" "+N+" "+k);
          String max;
//          BigInteger bi=new
          for(int i=0;i<M.length();i++){
              for(int j=i;j<M.length();j++){
                  int ii=i;
                  while(ii<=j){
                      if(M.charAt(ii)=='0') ii++;
                      else break;
                  }
//                  if(M.charAt(ii)=='0')
                  String substring = M.substring(ii, j+1);
                  if(!substring.isEmpty()) s1.add(substring);

//                  System.out.println(substring);
              }
          }
          for(String str:s1){
//              System.out.println(str+"str  ");
//              Long num = str2long(str);
              BigInteger num=new BigInteger(str);
              BigInteger ans = null;
              if(Objects.equals(k, "+")){
                  ans= num.add(N);
              }else if(Objects.equals(k, "*")) ans=num.multiply(N);
              else if(Objects.equals(k, "-")) ans=num.subtract(N);
              assert ans != null;
              String str2 = ans.toString();
                if(judgeNum(str2)){
                    Boolean aBoolean = judgeNum(str);
                    System.out.println(str);
                }
          }
      }

    }
}
