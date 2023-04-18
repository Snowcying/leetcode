package code.nowcoder;

import java.util.Scanner;

public class pdd {
    public static void S4() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int count = in.nextInt();
                int num1 = 0, num2 = 0;
                while (count > 0) {
                    if (count % 2 == 1) {
                        num1++;
                        count--;
                        if (count == 0) break;
                        int temp = count / 2;
                        if (count == 4 || count == 8) {
                            count = temp;
                            num2 += temp;
                        } else {
                            if (temp % 2 == 1) {
                                count = temp;
                                num2 += temp;
                            } else {
                                count--;
                                num2++;
                            }
                        }
                    } else {
                        int temp = count / 2;
                        if (count == 4 || count == 8) {
                            count = temp;
                            num1 += temp;

                            temp = count / 2;
                            count = count / 2;
                            num2 += temp;
                        } else {
                            if (temp % 2 == 1) {
                                count = temp;
                                num1 += temp;
                            } else {
                                count--;
                                num1++;
                            }
                            num2++;
                            count--;
                        }
                    }
                }
                System.out.println(num1 + " " + num2);
            }

        }
    }

    public static void S1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();
            int ans = 0;
            for (int i = 2; i <= x; i++) {
                for (int j = 2; j <= y; j++) {
                    if (i % 2 == 0 && j % 2 == 0) {
                        int xx = x - i, yy = y - j;
                        ans += (1 + xx) * (1 + yy);
                    }
                }
//
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        S4();
        S1();
    }
}
