package pdd;

import java.util.Scanner;

/**
 * @Author: LX
 * @Date: 2019/4/3 18:54
 * @Version: 1.0
 * 对两个单词内的字符进行增删改，使其相等
 */
public class Word1ToWord2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        int len1 = word1.length() + 1;
        int len2 = word2.length() + 1;
        int[][] res = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            res[i][0] = i;
        }
        for (int j = 1; j < len2; j++) {
            res[0][j] = j;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]) + 1,
                        res[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        System.out.println(res[len1-1][len2 - 1]);
    }
}
