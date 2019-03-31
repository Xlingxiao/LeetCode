package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

public class _121买卖股票的最好时间 {

    @Test
    void Main() {
        DataUtil util = new DataUtil();
        int[] nums = util.getArraysAndDisplay(0, 10, 10);
        System.out.println(maxProfit(nums));
    }

    /*对于有len天的最优解为：
    * opt(len) = max(opt(len - 1), prices[len] - min(price[0-len))*/
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 1) return 0;
        int[] results = new int[len];
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (results[i - 1] < prices[i] - min) {
                results[i] = prices[i] - min;
            }else
                results[i] = results[i - 1];
            min = Math.min(prices[i], min);
        }
        return results[len - 1];
    }
}
