package problems;

import org.junit.jupiter.api.Test;
import utils.DataUtil;

import java.util.Arrays;

/**
 * @Author: LX
 * @Date: 2019/3/31 17:54
 * @Version: 1.0
 */
@SuppressWarnings({"unused", "NonAsciiCharacters"})
public class _28找出字符串在另一个字符串中的位置 {

    @Test
    void main() {
        String a = "mississippi";
        String b = "issip";
        System.out.println(strStr(a, b));
    }

    /*思路
    * 1. 双指针
    * 2. 指针j指向第一个字符串，指针i指向第二个字符串
    * 3. 遍历 j
    * 4. 当j指向的字符和i指向的字符相同时i向后移动*/
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) return -1;
        else if(len2 == 0) return 0;
        return -1;
    }
}
