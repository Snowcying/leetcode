package code;

class Solution42 {

    static public int V(int[] height, int l, int r) {
        int h = Math.min(height[l], height[r]);
        int ans = 0;
        for (int i = l + 1; i < r; i++) {
            if(height[i]<h){
                ans += h - height[i];
            }
        }
        System.out.println("ans1: "+Integer.toString(l)+" "+Integer.toString(r));
        System.out.println(ans);
        return ans;
    }

    static public int trap(int[] height) {
        int start=0,len=height.length;
        if(len==1||len==2){
            return 0;
        }
        for (int i = 0; i < len-1; i++) {
            if(height[i]>height[i+1]){
                start=i;
                break;
            }
        }
        int ans=0;
        int left=0,right=0;
        for (int i = start; i < len; ) {
            left=i;
            while(i+1<len&&height[i]>=height[i+1]){
                i++;
            }
            for(int j=i;j<len;j++){
                if(height[j]>=height[left]){
                    i=j;
                    break;
                }
            }
            while(i+1<len&&height[i]<=height[i+1]){
                i++;
            }
            right=i;
            ans+=V(height,left,right);
            if(i==len-1){
                break;
            }
//            System.out.println("left");
//            System.out.println(left);
//            System.out.println(right);
//            System.out.println("right");

        }
        return ans;
    }
    static public int trap2(int[] height) {
        int ans=0;
        int length = height.length;
        if(length==1||length==2){
            return 0;
        }
        for(int i=1;i<length;i++){
            int indexLeft=i-1,indexRight=i+1;
            int h=height[i];
            int lMax=h,rMax=h;
            while(indexLeft>=0){
                if(height[indexLeft]>=lMax){
                    lMax=height[indexLeft];
                }
                indexLeft--;
            }
            while(indexRight<length){
                if(height[indexRight]>=rMax){
                    rMax=height[indexRight];
                }
                indexRight++;
            }
//            System.out.println("---");
//            System.out.println(Integer.toString(indexLeft)+" "+Integer.toString());
//            System.out.println("---");
            if(Math.min(lMax,rMax)-h>0){
                ans+=Math.min(lMax,rMax)-h;
            }

        }

        return ans;
    }
    static int findMax(int[] height,int index){
        boolean flag=false;
        int max=height[index];
        int length = height.length;
        index++;
        while(index<length){
            if(height[index]>=max){
                flag=true;
                max=height[index];
            }
            index++;
        }
        if(!flag){
            return -1;
        }
        return max;
    }
    static public int trap3(int[] height) {
        int ans=0;
        int length = height.length;
        if(length==1||length==2){
            return 0;
        }
        int[] dp=new int[length];
//        System.out.println(dp);
        for (int i = 1; i < length; i++) {
            if(dp[i-1]==0){
                if(height[i]>=height[i-1]){
                    dp[i]=0;
                }else {
                    int temp=findMax(height,i);
                    int lMax=height[i-1];
                    int min=Math.min(temp,lMax);
                    dp[i]=Math.max(min-height[i],0);
                }
            }else{

                    int max=dp[i-1]+height[i-1];
                    dp[i]=Math.max(max-height[i],0);

            }
        }
        for(int a1:dp){
//            System.out.println(a1);
            ans+=a1;
        }
        return ans;
    }

    static public int trap4(int[] height) {
        int ans=0;
        int length = height.length;
        if(length==1||length==2){
            return 0;
        }
        int[] dp=new int[length];
//        System.out.println(dp);
        int[] lMax=new int[length];
        int[] rMax=new int[length];
        rMax[length-1]=height[length-1];
        lMax[0]=height[0];
        for (int i = 1; i < length; i++) {
            lMax[i]=Math.max(height[i],lMax[i-1]);
            int rIndex=length-1-i;
            rMax[rIndex]=Math.max(height[rIndex],rMax[rIndex+1]);
        }
        for (int i = 1; i < length-1; i++) {
            int max=Math.min(lMax[i],rMax[i]);
            dp[i]+=Math.max(max-height[i],0);
        }
        for(int a1:dp){
            System.out.println(a1);
            ans+=a1;
        }
        return ans;
    }
}

public class Hot42 {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {4,2,0,3,2,4,4,4,2,4};
        int[] height = {2,8,5,5,6,1,7,4,5};
//        int[] height = {2};
        int ans1 = Solution42.trap3(height);
        int ans2 = Solution42.trap4(height);
//        int ans = Solution42.V(height,7,10);
        System.out.println("---");
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
