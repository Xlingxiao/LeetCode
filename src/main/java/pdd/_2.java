package pdd;

import utils.DataUtil;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        DataUtil util = new DataUtil();
        int[] times = util.getArrays(0, 20, 10);
//        Scanner sc = new Scanner(System.in);
//        int[] times = new int[10];
//        int Ab, Bb;
//        for (int i = 0; i < times.length; i++) {
//            times[i] = sc.nextInt();
//        }
//        Ab = sc.nextInt();
//        Bb = sc.nextInt();

        int Ab = 9;
        int Bb = 9;
        times[0] = 0;
        System.out.println(Arrays.toString(times));

        int a = getMin(times, Ab);
        int b = getMin(times, Bb);
        BigInteger ra = new BigInteger(String.valueOf(a));
        BigInteger rb = new BigInteger(String.valueOf(b));
        System.out.println(ra.multiply(rb));
    }

    private static StringBuilder sb = new StringBuilder();
    static int getMin(int[] times, int bitNum) {
        int count = 0;
        //从0开始分配
        for (int i = 0; i < times.length && count < bitNum; i++) {
            //times[i]个0
            for (int j = 0; j < times[i]&& count < bitNum; ) {
                sb.append(i);
                count++;
                times[i]--;
            }
        }
        int res = Integer.parseInt(sb.toString());
        sb.delete(0, sb.length());
        return res;
    }
}
