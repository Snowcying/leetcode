package code.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XieCheng {
    void s1() {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//        String str = in.next();
//        System.out.println(str);
        String str = "aBc4Z.;x_i";
        char[] chars = str.toCharArray();
        StringBuffer res1 = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char x = chars[i];
            if (x >= 'A' && x < 'Z') {
                x++;
            } else if (x == 'Z') x = 'A';
            else if (x > 'a' && x <= 'z') x--;
            else if (x == 'a') x = 'z';
            res1.append(x);
//            System.out.println(chars[i]+" "+x);
        }
        System.out.println(res1);
    }

    void s2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ss = new String[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            ss[i] = in.next();
            v[i] = in.nextInt();
        }
        // ss[i][j] = 1   i<j
        //  -1 !=
        int[][] con = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                if(con[i][j]==0){
                boolean flag = false;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (con[i][k] == 1 && con[k][j] == 1) {
                        flag = true;
                    }
                }
                if (flag) {
                    con[i][j] = 1;
                    continue;
                }

                if (ss[j].contains(ss[i])) {
                    con[i][j] = 1;
                } else {
                    con[i][j] = -1;
                }
//                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (con[i][j] == 1) {
                    max = Math.max(max, v[i] + v[j]);
                }
            }
        }
        System.out.println(max);
    }

    static Map<String, Boolean> judge = new HashMap<>();

    static Boolean count(char[] cc) {
//        if (!judge.containsKey(num)) {
        int res = 0;
//            char[] chars = num.toCharArray();
        res = ((cc[2] - '0') % 10) + res;
//            num=num/10;
        res = ((cc[1] - '0') % 10) * 3 + res;
//            num=num/10;
        res += ((cc[0] - '0') % 10) * 9;
//            num=num/10;
        return res % 2 == 0;
//        }
//        return judge.get(num);
    }

    static Boolean count2(String cc) {
        if (!judge.containsKey(cc)) {
            int res = 0;
            res = ((cc.charAt(2) - '0') % 10) + res;
            res = ((cc.charAt(1) - '0') % 10) * 3 + res;
            res += ((cc.charAt(0) - '0') % 10) * 9;
            if (res % 2 == 0) {
                judge.put(cc, true);
                return true;
            } else {
                judge.put(cc, false);
            }

        }
        return judge.get(cc);
    }

    static boolean flag = false;

    static void dfs(StringBuffer num, int index) {
        if (flag) return;
        if (index == num.length()) {
            if (num.length() >= 3) {
                boolean flag2=true;
                for (int i = 0; i <= num.length() - 3; i++) {
                    String cc = num.substring(i, i + 3);

                    if (!count2(cc)) {
                        flag2=false;
                        break;
                    }
                }
                if(flag2) {
                    if(!flag){
                        flag=true;
                        System.out.println(num);
                    }

                }
            } else {
                System.out.println(num);
            }

            return;
        }
        if (num.charAt(index) != '?') {
            if (index > 0) {
                if (num.charAt(index - 1) == num.charAt(index)) {

                    return;
                }
            }
            dfs(num, index + 1);
        } else {
//            char[] chars = num.toCharArray();
            for (int i = 0; i < 3; i++) {
//                Integer.
                char c1 = (char) (i + '0');
                if (index > 0 && num.charAt(index - 1) == c1) continue;
                num.setCharAt(index, c1);
                StringBuffer num2 = new StringBuffer(num);
//                char[] num2 = new char[num.length];
//                for (int j = 0; j < num.length; j++) num2[j] = num[j];
//                String s1= Arrays.toString(chars);
                dfs(num2, index + 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//        String str = in.next();
        String str = "11?";
        char[] chars = str.toCharArray();
//        System.out.println(str);
        StringBuffer sb = new StringBuffer(str);
        dfs(sb, 0);
        if (!flag) System.out.println(-1);
//        sb.charAt()
//        sb.su
//        System.out.println(Arrays.toString(chars));
//        dfs(chars,0);
//        System.out.println(count(020));
//        System.out.println( (char) (8+'0'););
    }
}
