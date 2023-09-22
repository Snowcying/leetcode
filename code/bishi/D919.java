package code.bishi;

import java.util.Scanner;

public class D919 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println(Long.MAX_VALUE);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                long x, y, a, b;
                x = in.nextLong();
                y = in.nextLong();
                a = in.nextLong();
                b = in.nextLong();
                long maxQ = a % 2 == 0 ? a : a - 1;
                long maxP = b % 2 == 1 ? b : b - 1;

                if (x == y) {
                    System.out.println(0);
                } else if (x < y) {
                    long count = -1;
                    if ((y - x) % 2 == 0) {
                        if (y - x <= maxQ) {
                            System.out.println(1);
                        } else {
                            System.out.println(((y - x) / maxQ) + 1);
                        }
                    } else {
                        if (y - x <= maxQ) {
                            System.out.println(2);
                        } else {
                            long gap = (y - x) % maxQ;
                            long xx = gap % 2 == 0 ? 1 : 2;
                            count = ((y - x) / maxQ) + xx;
                            System.out.println(count);
                        }
                    }
                } else {
                    long gap = x - y;
                    if (gap <= maxP) {
                        if (gap % 2 == 1) {
                            System.out.println(1);
                        } else {
                            System.out.println(3);
                        }
                    } else {
                        if (gap % maxP == 0) {
                            System.out.println(gap / maxP);
                        } else {
                            long count = gap / maxP;
                            gap = gap % maxP;
                            if (gap % 2 == 1) {
                                System.out.println(1 + count);
                            } else {
                                System.out.println(Math.min(gap, 2) + count);
                            }
                        }
                    }
                }
            }
        }
    }
}
