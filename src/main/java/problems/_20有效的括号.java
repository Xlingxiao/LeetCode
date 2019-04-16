package problems;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:06
 * @Version: 1.0
 */
public class _20有效的括号 {
    public boolean isValid(String s) {
        boolean flag;
        int len = s.length();
        if (len % 2 != 0) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('(', -1);
            put('[', -2);
            put('{', -3);
            put(')', 1);
            put(']', 2);
            put('}', 3);
        }};
        LinkedList<Character> stack = new LinkedList<Character>();
        char[] chars = s.toCharArray();
        int last;
        int current;
        try {
            for (int i = 0; i < len; i++) {
                char c = chars[i];
                current = map.get(c);
                if (current < 0) stack.addLast(c);
                else {
                    last = map.get(stack.getLast());
                    if (last + current != 0) return false;
                    else stack.removeLast();
                }
            }
        } catch (Exception e) {
            return false;
        }
        flag = stack.size() <= 0;
        return flag;
    }
}
