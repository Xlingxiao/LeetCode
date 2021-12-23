package leetCode._1;


import utils.DataUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = DataUtil.getArrays(-50, 50, 20);
        int[] result = s.twoSum(nums, 20);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    /**
     * 遍历nums，遍历过程中将数据存入map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int swap = target - nums[i];
            Integer result = map.get(swap);
            if (result != null) {
                return new int[]{i, result};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}