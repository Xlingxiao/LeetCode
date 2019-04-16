package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:07
 * @Version: 1.0
 */
public class _22括号生成 {
    public List<String> generateParenthesis(int n) {

        List<String> list = new LinkedList<String>();
        generate(n, 0, 0, list, new StringBuilder());
        return list;
    }

    void generate(int n, int count1, int count2, List<String> list, StringBuilder stringBuilder) {

        if (count1 > n || count2 > n) return;

        if (count1 == n && count2 == n) list.add(stringBuilder.toString());

        if (count1 >= count2) {
            generate(n, count1 + 1, count2, list, stringBuilder.append('('));
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            generate(n, count1, count2 + 1, list, stringBuilder.append(')'));
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
    }
}
