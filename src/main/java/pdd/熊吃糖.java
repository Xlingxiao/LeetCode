package pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/2 20:58
 * @Version: 1.0
 * 熊吃糖，使得更多的熊吃到糖
 */
public class 熊吃糖 {
    /*3 5
    5 6 110 20 30
    4 34
    3 35
    7 11*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n2];
        Bear[] bears = new Bear[n1];
        for (int i = 0; i < n2; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            bears[i] = new Bear(i, sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(nums);
        Arrays.sort(bears, new Comparator<Bear>() {
            public int compare(Bear o1, Bear o2) {
                return -(o1.f - o2.f);
            }
        });

        for (Bear bear : bears) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] != -1 &&bear.h >= nums[i]) {
                    bear.h -= nums[i];
                    nums[i] = -1;
                }
            }
        }
        Arrays.sort(bears, new Comparator<Bear>() {
            public int compare(Bear o1, Bear o2) {
                return o1.id - o2.id;
            }
        });
        for (Bear bear : bears) {
            System.out.println(bear.h);
        }
    }

    static class Bear {
        int id;
        int f;
        int h;

        Bear(int id, int f, int h) {
            this.id = id;
            this.f = f;
            this.h = h;
        }
    }

}
