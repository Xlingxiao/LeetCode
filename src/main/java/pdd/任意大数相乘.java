package pdd;

import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/3 14:13
 * @Version: 1.0
 * 两个任意大数相乘
 */
public class 任意大数相乘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rwo = sc.nextLine();
        String[] target = rwo.split(" ");

        int an = target[0].length();
        int bn = target[1].length();

        int[] res = new int[an + bn];

        for (int i = bn - 1; i >= 0; i--) {
            for (int j = an - 1; j >= 0; j--) {
                int t = (target[0].charAt(j) - '0') * (target[1].charAt(i) - '0');
                res[j + i + 1] += t;
            }
        }

        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = an + bn - 1; i >= 0; i--) {
            res[i] = res[i] + s;
            s = res[i] / 10;
            res[i] = res[i] % 10;
            sb.append(res[i]);
        }
        int len = sb.length();
        if (sb.charAt(len - 1) == '0') {
            sb.delete(len - 1, len);
        }
        System.out.println(sb.reverse().toString());
    }
}
