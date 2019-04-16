package _360;

import java.util.Scanner;
/*
* 将16进制或者8进制ip转为10进制
* 16进制和8进制ip前用O或者Ox表示
* 输入：0123.027.12.112/255.255.255.0
* 输出：83.23.10.74/24*/
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String row = sc.nextLine();
        String[] targets = row.split("/");
        int n = 10;
        if (targets[0].contains("0x")) n = 16;
        else if (targets[0].contains("0")) n = 8;

        if(n == 16) targets[0] = targets[0].substring(2);
        else if (n == 8) targets[0] = targets[0].substring(1);

        String[] snums = targets[0].split("\\.");
        int[] nums = new int[4];

        for (int i = 0; i < snums.length; i++)
            nums[i] = Integer.valueOf(snums[i], n);
        if (nums[0] == 0) {
            System.out.println("ERROR");
            return;
        }
        //将mac转为二进制
        String[] smac = targets[1].split("\\.");
        int num = 0;
        for (String s : smac) {
            int a = Integer.parseInt(s);
            while (true) {
                if (a > 0){
                    num++;
                    a = a >> 1;
                }
                else{ break;}
            }
        }
        System.out.print(String.format("%d.%d.%d.%d/%d", nums[0], nums[1], nums[2], nums[3], num));

    }
}
