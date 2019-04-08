package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

import java.util.Arrays;

/**
 * @Author: LX
 * @Date: 2019/4/7 19:42
 * @Version: 1.0
 */
public class _33搜索旋转排序数组 {

    @Test
    void main(){
        DataUtil util = new DataUtil();
//        int[] nums = util.getSortedArrays(0, 10, 10);
        int[] nums = util.stringToArray("4,5,6,7,8,1,2,3", ",");
        System.out.println(Arrays.toString(nums));
//        System.out.println(find(nums, 0, 9, 4));
        System.out.println(search(nums, 8));
    }

    /*思路
    * 1. 二分找目标值
    * 2. 如果目标值处在单调区间
    *       直接调用二分查找*/
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) return -1;
        int i = 0;
        int j = len - 1;
        if(nums[i] == target) return i;
        if(nums[j] == target) return j;
        int result = -1;
        boolean flag = false;
        while (i < j) {
            if(nums[i] == target) return i;
            if(nums[j] == target) return j;
            int n = (i + j) / 2;
            if(nums[n] == target) return n;

            if (nums[i] <= nums[n] && nums[j] >= nums[n]) flag = true;
            if(flag) return find(nums, i, j, target);

            if (nums[n] > target) {
                if(nums[i] < target){
                    //往左
                    j = n - 1;
                }else if(nums[i] > target){
                    //往右
                    i = n + 1;
                }
            }else if(nums[n] < target){
                if(nums[j] < target){
                    //往右
                    i = n + 1;
                } else if (nums[j] > target) {
                    //往右
                    j = n - 1;
                }
            }
        }
        return result;
    }


    int find(int[] nums, int i, int j, int target) {
        if (i == j){
            if(nums[i] == target)
                return nums[i];
            return -1;
        }
        while (i < j) {
            if(nums[i] == target) return i;
            if(nums[j] == target) return j;
            int n = (i + j) / 2;
            if(nums[n] == target) return n;
            else if (nums[n] < target) i = n + 1;
            else j = n - 1;
        }
        return -1;
    }
}
