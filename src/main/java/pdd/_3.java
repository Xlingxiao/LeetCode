package pdd;

import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/2 21:50
 * @Version: 1.0
 */
public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    double a = (nums[i][1] - nums[j][1]) * 1.0 / (nums[i][0] - nums[j][0]) * 1.0 ;
                    double b = (nums[k][1] - nums[j][1]) * 1.0 / (nums[k][0] - nums[j][0]) * 1.0 ;
                    if (a != b) count++;
                }
            }
        }
        System.out.println(count);
    }
}
