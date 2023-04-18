package code.M4;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

public class Test {
    static int maxX = 0;
    static int maxY = 0;

    static int judge1(long x) {
        int ans = 0;
        while (x > 0) {
            if ((x & 1) == 1) {
                ans++;
            }
            x = x >> 1;
            maxX++;
        }
        return ans;
    }

    static int judge0(long x) {
        int ans = 0;
        while (x > 0) {
            if ((x & 1) == 0) {
                ans++;
            }
            x = x >> 1;
            maxY++;
        }
        return ans;
    }

    static int yMax(long x) {
        int ans = 0;
        while (x > 0) {
            x = x >> 1;
            ans++;
        }
        return ans;
    }

    static long cnn(int x, int y) {
        if (y == 0 || x == 0) {
            return 1;
        }
        if(y>x){
            return 0;
        }
        long ans1 = 1;
        long ans2 = 1;
        for (int i = 0; i < y; i++) {
            ans1 = ans1 * (x - i);
            ans2 = ans2 * (y - i);
        }
        return ans1 / ans2;
    }

    static void s1() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        int T = 1;

        for (int i = 0; i < T; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
//            int l = 2, r = 4;
//            long x = 2, y = 3;
//            int l = 3, r = 5;
//            long x = 20, y = 61;
            int num1 = judge1(x), num0 = judge0(y);
            int max = Math.max(maxX, maxY);
            l = l - num1;
            r = r - num1;

            int leave = max - num1 - num0;
            if (l < 0 || r < 0 || max < 0 || leave < 0||leave<l||l>r) {
                System.out.println(0);
                continue;
            }
//            System.out.println(leave);
//            System.out.println(l);
//            System.out.println(r);
            long ans = 0;
//            System.out.println(cnn(4,0));
            for (int j = l; j <= r; j++) {
//                if()
                ans = ans + cnn(leave, j);
            }
            System.out.println(ans);
            maxX = 0;
            maxY = 0;
        }
    }

    static void s2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
//        int n =10 ;
//        int[] nums= {32 ,23, 93, 21 ,30 ,9 ,27, 88 ,93, 61};
//        int[] nums= {-32 ,23, -93, -21 ,30 ,9 ,27, -88 ,93, 61};
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

//        System.out.println(nums);
        int l = 0, r = 0;
        int sum = 0;
        int mL = 0, mR = 0, mS = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                l = i;
                sum = 0;
            } else {
                sum += nums[i];
                r = i;
                if (sum > mS) {
                    mL = l;
                    mR = r;
                    mS = sum;
                }
            }
        }
        int ans = mS;
        for (int i = mL + 1; i <= mR; i++) {
            nums[i] = -1;
        }
        l = 0;
        r = 0;
        sum = 0;
        mL = 0;
        mR = 0;
        mS = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                l = i;
                sum = 0;
            } else {
                sum += nums[i];
                r = i;
                if (sum > mS) {
                    mL = l;
                    mR = r;
                    mS = sum;
                }
            }
        }
        ans = ans + mS;
        System.out.println(ans);


//        System.out.println(mL+1);
//        System.out.println(mR);
//        System.out.println(mS);
    }

    public static void main(String[] args) {
        s1();

    }
}
