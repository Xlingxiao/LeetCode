package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 21:57
 * @Version: 1.0
 */
public class _7整数反转 {
    public int reverse(int x) {
        StringBuilder tmp = new StringBuilder();
        boolean flag = false;
        tmp.append(x);
        tmp.reverse();
        int len = tmp.length();

        if(x < 0) {
            tmp.deleteCharAt(len - 1);
            flag = true;
        }
        try {
            x = Integer.valueOf(tmp.toString());
        } catch (Exception e) {
            return 0;
        }
        if (flag) x = -x;
        return x;
    }
}
