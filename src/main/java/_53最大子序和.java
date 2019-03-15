import org.junit.jupiter.api.Test;
import utils.DataUtil;

public class _53最大子序和 {

    @Test
    void main() {
        DataUtil util = new DataUtil();
        int[] nums = util.getArraysAndDisplay(-50, 145, 10);
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int tmp = 0;
        for (int num : nums) {
            if (tmp > 0) {
                tmp += num;
            } else {
                tmp = num;
            }
            sum = Math.max(sum, tmp);
        }
        return sum;
    }
}
