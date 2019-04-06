package pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/3 15:41
 * @Version: 1.0
 * 幼儿园吃巧克力，每人只能吃一块，最多吃饱
 */
public class 幼儿园吃巧克力 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hn = sc.nextInt();
        int[] hs = new int[hn];
        for (int i = 0; i < hn; i++) hs[i] = sc.nextInt();

        int wn = sc.nextInt();
        int[] ws = new int[wn];
        for (int i = 0; i < wn; i++) ws[i] = sc.nextInt();

        Arrays.sort(hs);
        Arrays.sort(ws);

        int j = ws.length - 1;
        for (int i = hs.length - 1; i >= 0 && j >= 0; i--) {
            int t = hs[i] - ws[j];
            if (t <= 0) {
                j--;
                hs[i] = t;
            }
        }

        int count = 0;
        for (int h : hs)
            if (h <= 0)
                count++;

        System.out.println(count);
    }
}
