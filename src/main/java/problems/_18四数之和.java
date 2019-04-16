package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:05
 * @Version: 1.0
 */
@SuppressWarnings("Duplicates")
public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (len < 4) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = len - 1; j > i + 2; j--) {
                if (j != len - 1 && nums[j] == nums[j + 1]) continue;
                int sum = target - (nums[i] + nums[j]);
                int l = i + 1, r = j - 1;
                while (l < r) {
                    int tmp = nums[l] + nums[r];
                    if (tmp == sum) {
                        lists.add(Arrays.asList(nums[i], nums[l], nums[r], nums[j]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (tmp < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return lists;
    }
}
