package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

import java.util.Arrays;

/**
 * @Author: LX
 * @Date: 2019/3/31 17:44
 * @Version: 1.0
 */
public class _27数组移除元素 {

    @Test
    void main() {
        DataUtil util = new DataUtil();
        int[] nums = util.getArrays(0, 10, 10);
        System.out.println(Arrays.toString(nums));
        int i = removeElement(nums, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    /*思路
    * 1. 双指针
    * 2. 指针i指向不重复的元素位置
    * 3. 指针j遍历数组
    * 4. 当j指向的数值为目标数值时跳过，否则将值赋给i对应的位置
    * 5. 最后返回i*/
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len < 1) return 0;
        int i = 0;
        for (int j = 0; j < len; j++)
            if (nums[j] != val) nums[i++] = nums[j];
        return i;
    }
}
