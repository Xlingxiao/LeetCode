package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: LX
 * @Date: 2019/4/8 21:51
 * @Version: 1.0
 */
public class _1两数之和 {

    @Test
    void main(){
        DataUtil util = new DataUtil();
        int[] nums = util.getArrays(0, 10, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(twoSum(nums, 1)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            Integer tmp = map.get(target - nums[i]);
            if(tmp != null){
                return new int[] {tmp,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
