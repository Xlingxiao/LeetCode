package utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayUtils {
    public static void main(String[] args) {
        String a = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        char[][] chars = stringToChar2Array(a, ",");
        for (char[] aChar : chars) {
            for (int i = 0; i < aChar.length; i++) {
                System.out.print(aChar[i]);
            }
            System.out.println();
        }
    }

    public static void printChar2Array(char[][] chars) {
        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // 字符串转数组
    public static char[][] stringToChar2Array(String string, String separator) {
        Pattern pattern = Pattern.compile("\\[\\[|\\],\\[|\\]\\]");
        Matcher matcher = pattern.matcher(string);
        String[] stringArray = matcher.replaceAll("\n").split("\n");
        char[][] result = new char[stringArray.length - 1][stringArray.length];
        for (int i = 1; i < stringArray.length; i++) {
            char[] chars = stringToCharArray(stringArray[i], separator);
            result[i - 1] = chars;
        }
        return result;

    }

    // 字符串转数组
    public static char[] stringToCharArray(String string, String separator) {
        if ("".equals(string)) {
            return null;
        }
        String[] a = string.replace("\"'", "").split(separator);
        char[] chars = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            chars[i] = a[i].charAt(1);
        }
        return chars;
    }
}
