package pdd;

import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/2 19:54
 * @Version: 1.0
 */
public class _1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < nums.length; i++)
            nums[i] = sc.nextInt();
        int[] res = new int[4];
        res[0] = nums[2] - nums[0];

        if (nums[0] >= nums[2] + nums[3]) {
            res[0] = res[1] = nums[2];
            res[2] = res[3] = nums[3];
        } else if (nums[0] >= nums[2]) {
            res[0] = res[1] = nums[2];
            res[2] = nums[0] - nums[2];
            int t = nums[0] + nums[1] - nums[2] + nums[3];
            res[3] = t > 0 ? nums[3] : -t;
        } else if (nums[0] + nums[1] > nums[2]) {
            res[0] = nums[0];
            res[1] = nums[2];
            res[2] = 0;
            res[3] = nums[2] - nums[0];
            }
        else {
            res[0] = nums[0];
            res[1] = nums[0] + nums[1];
            }
        System.out.println(String.format("%d %d %d %d", res[0], res[1], res[2], res[3]));
    }
}
