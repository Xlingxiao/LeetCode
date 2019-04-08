package XieCheng;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * 判断链表是否有环
 */

public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String[] target = t.split(",");
        HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        boolean flag = false;
        for (String s : target) {
            if (map.get(s) == null) {
                map.put(s, 1);
            }else{
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }
}
