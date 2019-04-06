package problems;

import org.junit.jupiter.api.Test;


public class _29两数相除 {


    @Test
    void main() {
        int a = -22222222;
        int b = -2147483648;
        System.out.println(divide(a, b));
        System.out.println(a / b);
    }

    /*
    * 思路：
    * 1. 将两数取绝对值
    * 2. 判断被除数是否大于除数
    *    小于：返回0
    *    大于：循环增加除数本身直到超过被除数，每次增加用一个count记录*/
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            else {
                a = Integer.MAX_VALUE;
            }
        }
        if(a<b) return 0;
        int bBind = b;
        int count = 1;
        while (a > b) {
            int t = b << 1;
            if (t < b || t > a) {
                if(dividend == Integer.MIN_VALUE)
                    count += divide(a - b + 1, bBind);
                 else
                     count += divide(a - b, bBind);
                break;
            }else{
                b = t;
                count = count << 1;
            }
        }
        if (dividend < 0 && divisor > 0 || dividend >= 0 && divisor < 0) {
            count = -count;
        }
        return count;
    }
}
