package code.bishi;

import java.util.Scanner;

public class D923 {

    void S1() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                b[i] = a[x - 1] + a[y - 1];
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = res + Math.min(a[i], b[i]);
            }
            System.out.println(res);
//            int b = in.nextInt();
//            System.out.println(a + b);
        }
    }

    void S2() {
//        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long[] a = new long[n];
            long min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                long input = in.nextLong();
                a[i] = input;
                min = Math.min(min, a[i]);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (i + 2 < n) {
                    if (a[i] <= a[i + 1] && a[i + 1] <= a[i + 2]) {
//                        if (i + 3 < n) {
//                            a[i + 2] = a[i + 1] - 1;
//                        }else {
//                            a[i+2]=
//                        }
                        a[i + 2] = a[i + 1] - 1;
                        min--;
//                        i=i+2;
                        res++;
                    }
                }
            }
            System.out.println(res);

        }
    }

    public static void main(String[] args) {
        new D923().S2();
    }
}
