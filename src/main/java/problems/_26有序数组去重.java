package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

import java.util.Arrays;

/**
 * @Author: LX
 * @Date: 2019/3/31 17:23
 * @Version: 1.0
 */
public class _26有序数组去重 {

    @Test
    void main() {
        DataUtil util = new DataUtil();
        int[] nums = util.getSortedArrays(0, 10, 100);
        System.out.println(Arrays.toString(nums));
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    /*解题过程
    * 1. 双指针一个 i 指着不重复数据的最后一个
    * 2. 另一个 j 向后滑动找到不重复的数据，遇到重复就跳过
    * 3. 将i的后一个位置赋值为j指向的值
    * 4. 最后i即为返回值*/
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int i = 1;
        for (int j = 1; j < len; j++) {
            if (nums[j - 1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
