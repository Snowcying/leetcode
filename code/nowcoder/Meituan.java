package code.nowcoder;

import java.util.*;

import java.util.Scanner;

public class Meituan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {




            int n = in.nextInt();
            int k = in.nextInt();
//            int ans = 0;
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            int index=0;
            int nn=n;
            nums[0]--;
            if(nums[0]==0) {
                n--;
                System.out.println(1);
            };
            while(n>0){
                int kk=k%n;
                if(kk==0&&nums[index]==0){
                    kk=k;
                }

                while(kk>0){
                    if(nums[(index+1)%nn]!=0){
                        kk--;
                    }
                    index=(index+1)%nn;

                }
                nums[index]--;
                if(nums[index]==0){
                    System.out.println(index+1);
                    n--;
                }
            }

//            System.out.println(ans);
        }
    }
}