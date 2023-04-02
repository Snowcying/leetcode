package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Exam {
    static double max=Double.MIN_VALUE;

    static void dfs(double M,double MM,double[] historyPrices,int k,int today){
        if(k==0){
            if(M>max){
                max=M;
            }
        }else{
            if(today==historyPrices.length-1){
                M+=MM*historyPrices[today];
                if(M>max){
                    max=M;
                }
            }else{
                double MM2=M/historyPrices[today]+MM;
                dfs(0,MM2,historyPrices,k,today+1);
                double M2=MM*historyPrices[today]+M;
                dfs(M2,0,historyPrices,k-1,today+1);
                dfs(M,MM,historyPrices,k,today+1);
            }
        }
    }
    public static double get_max_profit (double M, int N, double[] historyPrices, int K) {
        // write code herer
//        int max=Integer.MIN_VALUE;
        dfs(M,0,historyPrices,K,0);
        return max-M;
    }

    public static void main(String[] args) {
        double M=10000;
        int N=7;
        double[] historyPrices={1.0,2.0,1.0,2.0,2.0,3.0,2.0};
        int K=2;
        System.out.println(get_max_profit(M,N,historyPrices,K));
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> res=new ArrayList<>();
        res.add(153);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            for(int i=n-1;i>10;i--){
                if(i>=res.get(res.size()-1)){
                    int nn=i;
                    int index=0;
                    while(nn>0){
                        nn=nn/10;
                        index++;
                    }
                    int ans=0;
                    int input=i;
                    while(input>0){
                        int x=input%10;
                        ans+=pow(x,index);
                        input=input/10;
                    }
                    if(ans==i){
                        res.add(ans);
                        System.out.println(ans);
                    }
                }else{
                    if(res.contains(i)){
                        System.out.println(i);
                    }
                }

            }
        }
    }
}
