package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

public class _122多次买卖股票 {
    @Test
    void Main() {
        DataUtil util = new DataUtil();
//        int[] nums = util.getArraysAndDisplay(0, 10, 10);
        int[] nums = util.stringToArray("7 6 4 3 3 4 6 1 4 9", " ");

        System.out.println(maxProfit(nums));
    }

    //出现减少就卖出
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int min = 0;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] > prices[i]) {
                sum += prices[i - 1] - prices[min];
                min = i;
            }
        }
        int t = prices[len - 1] - prices[min];
        sum = t > 0 ? sum + t : sum;
        return sum;
    }
}
