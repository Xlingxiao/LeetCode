package problems;

import java.util.HashMap;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:01
 * @Version: 1.0
 */
public class _13罗马数字转整数 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int len = s.length();
        if (len < 2) return map.get(s.charAt(0));
        int sum = map.get(s.charAt(0));
        for (int i = 0,j = 1; j < len;i++, j++) {
            int p = map.get(s.charAt(i));
            int q = map.get(s.charAt(j));
            if (p < q) sum -= 2 * p;
            sum += q;
        }
        return sum;
    }
}
