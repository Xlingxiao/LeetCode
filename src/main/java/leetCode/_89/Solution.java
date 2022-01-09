package leetCode._89;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> grayCode(int n) {
        // 递推，找到递推公式为0+前一阶 U  1 + 前一阶
        int max = (int) Math.pow(2, n);
        List<Integer> res = new ArrayList<>(max);
        res.add(0);
        // 0 1 2 3 4
        /**
         * 0
         * 0 1
         * 00 01 11 10
         * 000 001 011 010 110 111 101 100
         */

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = head * 2 - 1; j >= head; j--) {
                res.add(head | res.get(j - head));
            }
            head = head << 1;
        }
        return res;
    }
}