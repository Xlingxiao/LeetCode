package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:04
 * @Version: 1.0
 */
public class _17电话号码的字母组合 {
    private HashMap<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private int len;
    private String digits;

    public List<String> letterCombinations(String digits) {
        len = digits.length();
        this.digits = digits;
        List<String> target = new LinkedList<String>();
        if (len < 1) return target;
        start(0, new StringBuilder(), target);
        return target;
    }

    void start(int num, StringBuilder sb, List<String> target) {
        if (num == len) return;
        char a = digits.charAt(num);
        String tmp = map.get(a);
        for (char c : tmp.toCharArray()) {
            sb.append(c);
            start(num + 1, sb, target);
            if (sb.length() == len) target.add(sb.toString());
            sb.delete(num, num + 1);
        }
    }
}
