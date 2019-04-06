package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

import java.util.Arrays;

/**
 * @Author: LX
 * @Date: 2019/4/6 13:22
 * @Version: 1.0
 */
public class _31下一个排列 {

    @Test
    void main() {
        DataUtil util = new DataUtil();
//        int[] nums = util.getArrays(10, 0, 10);
//        int[] nums = util.stringToArray("2,3,1,3,3", ",");
        int[] nums = util.stringToArray("2,3,0,2,4,1", ",");
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    * [1,2,3,4] ： [1,2,4,3]
    * [1,2,3,4,5]：[1,2,3,5,4]
    * [5,4,3,2,1]：[1,2,3,4,5]
    * [1,5,4,3,2]：[2,1,3,4,5]
    * [1,2,5,4,3]：[1,3,2,4,5]
    * [1,5,0,4,3,2]: [1,5,2,0,3,4]*/
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int i = len - 1;
        //从后往前找 找到后一个值比当前值小的位置 i
        for (; i >= 1; i--) {
            if(nums[i-1] >= nums[i]) continue;
            int j = i;
            //找到和i-1交换的位置
            while (j < len && nums[i - 1] < nums[j]) j++;
            swap(nums, i - 1, j - 1);
            Arrays.sort(nums, i, len);
            return;
        }
        //如果数组为降序 进行升序排序
        if (i == 0) Arrays.sort(nums);
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
