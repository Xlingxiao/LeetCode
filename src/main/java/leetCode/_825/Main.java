package leetCode._825;


import utils.DataUtil;

public class Main {
    public static void main(String[] args) {
//        int[] ages = DataUtil.getArraysAndDisplay(1, 20, 5);
        int[] ages = DataUtil.stringToArray("14 14 6 10 14", " ");
        Solution solution = new Solution();
        System.out.println(solution.numFriendRequests(ages));

    }
}
