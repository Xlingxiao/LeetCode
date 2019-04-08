package problems;

import java.util.Arrays;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:03
 * @Version: 1.0
 */
public class _16最接近的三数之和 {
    @SuppressWarnings("Duplicates")
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) return 0;
        Arrays.sort(nums);
        long result = Integer.MIN_VALUE;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int tmp = nums[i] + nums[r] + nums[l];
                if (tmp == target) return target;
                result = Math.abs(target - tmp) > Math.abs(target - result) ? result : tmp;
                if(tmp < target){
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
        }
        return (int) result;
    }
}
