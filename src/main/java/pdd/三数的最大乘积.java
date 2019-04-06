package pdd;


import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/2 20:48
 * @Version: 1.0
 */
public class 三数的最大乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        long max1 = 0, max2 = 0, max3 = 0;
        long min1 = 0, min2 = 0;
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        for (int num : nums) {
            if (num > 0 && num > max3) {
                if (num > max2) {
                    max3 = max2;
                    if (num > max1) {
                        max2 = max1;
                        max1 = num;
                    } else {
                        max2 = num;
                    }
                } else {
                    max1 = num;
                }
            } else if (num < min2) {
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else {
                    min2 = num;
                }
            }
        }

        long res = Math.max(max1 * min1 * min2, max1 * max2 * max3);
        System.out.println(res);

    }
}
