package utils;

import java.util.Arrays;

@SuppressWarnings("unused")
public class DataUtil {

    /*获得int型随机数数组*/
    public int[] getArrays(int min, int max, int count) {
        int[] nums = new int[count];
        int a = max - min;
        for (int i = 0; i < count; i++) {
            nums[i] = (int) ((Math.random() * a) + min);
        }
        return nums;
    }

    /*获得int型随机数数组并打印出来*/
    public int[] getArraysAndDisplay(int min, int max, int count) {
        int[] nums = getArrays(min, max, count);
        display(nums);
        return nums;
    }

    /*获得long型随机数数组*/
    public long[] getArrays(long min, long max, int count) {
        long[] nums = new long[count];
        long a = max - min;
        for (int i = 0; i < count; i++) {
            nums[i] = (long) ((Math.random() * a) + min);
        }
        return nums;
    }

    /*打印数组*/
    private void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    /*将数组字符串转为数组*/
    public int[] stringToArray(String nums, String splitChar) {
        String[] t = nums.split(splitChar);
        int[] nn = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            nn[i] = Integer.parseInt(t[i]);
        }
        return nn;
    }

    /*获得排序数组*/
    public int[] getSortedArrays(int min, int max, int count) {
        int[] nums = getArrays(min, max, count);
        Arrays.sort(nums);
        return nums;
    }
}
