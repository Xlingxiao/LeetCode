package XieCheng;

import java.util.Scanner;

/**
 * 链表按照固定值进行反转
 */

public class _2 {
    static int len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String row = sc.nextLine();
        int k = sc.nextInt();
        String[] row_1 = row.split(",");
        len = row_1.length;
        if(len  < 2 || len <= k){
            System.out.println(row);
            return;
        }
        try {
            row_1[0] = row_1[0].replace("[", "");
            row_1[len - 1] = row_1[len - 1].replace("]", "");
            int[] nums = new int[row_1.length];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(row_1[i]);
            }
            //System.out.println(Arrays.toString(nums));

            for (int i = 0; i < len; i += k) {
                onceReverse(nums, i, i + k - 1);
            }
            display(nums);
        } catch (Exception e) {
            System.out.println(row);
        }
    }

    static void display(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int num : nums) {
            sb.append(num).append(",");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }

    static void onceReverse(int[] nums, int i, int j) {
        // 0 1 2 3 4 5  i:0 j:2
        if (j >= len || i >= len) {
            return;
        }
        for (int k = 0; k + i < j - k; k++) {
            swap(nums, i + k, j - k);
        }

    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
