package leetCode._1078;

import utils.DataUtil;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "alice is a good girl she is a good student";
        String first = "a", second = "good";
        String[] result = solution.findOcurrences(text, first, second);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
