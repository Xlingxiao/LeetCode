package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:01
 * @Version: 1.0
 */
public class _14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len < 1) return "";
        int target = 0;
        char c;
        int i = 0;
        while (true) {
            int j = 0;
            try {
                c = strs[0].charAt(i);
                for (; j < len; j++) {
                    if (c != strs[j].charAt(i)) break;
                }
            } catch (Exception e) {
                break;
            }
            if (j < len) break;
            target++;
            i++;
        }
        return strs[0].substring(0, target);
    }
}
