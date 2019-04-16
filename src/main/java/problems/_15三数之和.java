package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:02
 * @Version: 1.0
 */
public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> target = new LinkedList<List<Integer>>();
        if (len < 3) return target;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int sum = 0 - nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int t = nums[l] + nums[r];
                if (t == sum) {
                    target.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (t < sum) {
                    while (l < r && nums[l] == nums[l+1]) l++;
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
        }
        return target;
    }
}
