package XieCheng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 未完成：多个path输出每个path中子目录在前面出现的次数，根和叶子固定为1
 */
public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pathNum = sc.nextInt();
        String row = sc.nextLine();
        row = row.substring(1);
        if(pathNum < 2){
            System.out.println(row);
            return;
        }
        String[] row_1 = row.split(" ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        for (String s : row_1) {
            String[] strings = s.split("/");

            for (int i = 1; i < strings.length; i++) {
                if (map.get(strings[i]) == null) {
                    map.put(strings[i], 1);
                }else{
                    int a = map.get(strings[i]);
                    map.put(strings[i], a + 1);
                }
            }

            if(stringMap.get(s) == null){
                stringMap.put(s, 1);
                for (int i = 1; i < strings.length; i++)
                    sb.append(1);
            }

            sb.append(1);
            for (int i = 1; i < strings.length - 2; i++) {
                sb.append(map.get(strings[i]));
            }
            sb.append(1);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
