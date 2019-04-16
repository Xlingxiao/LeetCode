package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 21:56
 * @Version: 1.0
 */
public class _3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int[] charts = new int[128];
        int rowLength = s.length();
        int targetLength = 0;
        for (int j = 0, i = 0; j < rowLength; j++) {
            i = Math.max(i, charts[s.charAt(j)]);
            targetLength = Math.max(targetLength, j - i + 1);
            charts[s.charAt(j)] = j + 1;
        }
        return targetLength;
    }
}
