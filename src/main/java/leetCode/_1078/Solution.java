package leetCode._1078;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出第一个词first 和第二个词second，考虑在某些文本text中可能以 "first second third" 形式出现的情况，其中second紧随first出现，third紧随second出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和second由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 双指针遍历text
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new LinkedList<String>();
        if (text == null) {
            return null;
        }
        int firstLen = first.length();
        int secondLen = second.length();
        int i = 0;
        while (i < text.length()) {
            // 获取下一个词的位置
            if (getIt(text, first, second, i)) {
                // 取下一个词
                int next = getNext(text, i + firstLen + 2 + secondLen);
                next = next == text.length() ? next : next - 1;
                list.add(text.substring(i + firstLen + 2 + secondLen,next));
                i += firstLen + 1;
                continue;
            }
            i = getNext(text, i);
        }
        return list.toArray(new String[list.size()]);
    }

    boolean getIt(String text, String first, String second, int start) {
        int firstLen = first.length();
        int secondLen = second.length();
        int count = firstLen + secondLen + 1;
        for (int i = 0; i < count; i++) {
            if (i < firstLen) {
                if (first.charAt(i) != text.charAt(i + start)) {
                    return false;
                }
                continue;
            }
            if (i > firstLen) {
                if (second.charAt(i - (firstLen + 1)) != text.charAt(i + start)) {
                    return false;
                }
            }
        }
        return true;
    }

    int getNext(String text, int start) {
        for (int i = start; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                return i + 1;
            }
        }
        return text.length();
    }
}