package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 21:58
 * @Version: 1.0
 */
public class _8字符串转整数 {
    public int myAtoi(String str) {
        int target;
        boolean flag = false;
        str = str.trim();
        int len = str.length();
        if (len == 0) return 0;
        if (str.charAt(0) == '-' ||str.charAt(0) == '+'){
            flag = str.charAt(0) == '-';
            if(len < 2) return 0;
            str = str.substring(1, len--);
        }
        if(str.charAt(0)<48 || str.charAt(0)>57) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int c = str.charAt(i);
            if (c >= 48 && c <= 57) {
                sb.append(str.charAt(i));
            }else
                break;
        }
        try {
            target = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            if (flag) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        if(flag) target = -target;
        return target;
    }
}
