package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:00
 * @Version: 1.0
 */
public class _12整数转罗马数字 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
}
